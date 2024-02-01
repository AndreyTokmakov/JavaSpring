package service_mongodb;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@CrossOrigin("http://0.0.0.0:8080")
@RestController
@RequestMapping("/v1/mongodbapp")
public class BookController
{
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String bookTitle)
    {
        log.info("getAllBooks() called");
        try
        {
            List<Book> listOfBooks = new ArrayList<>();
            if(bookTitle == null || bookTitle.isEmpty())  {
                bookRepository.findAll().forEach(listOfBooks::add);
            }  else  {
                bookRepository.findByTitleContaining(bookTitle).forEach(listOfBooks::add);
            }

            if (listOfBooks.isEmpty())  {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id)
    {
        log.info("getBookById() called");
        try {
            Optional<Book> bookOptional = bookRepository.findById(id);
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }  catch (Exception e)  {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addABookToLibrary(@RequestBody Book book)
    {
        log.info("addABookToLibrary() called");
        try {
            Book createdBook = bookRepository.save(new Book(book.getTitle(), book.getAuthor(), book.getIsbn()));
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateABook(@PathVariable("id") String id,
                                            @RequestBody Book book)
    {
        log.info("updateABook() called");
        final Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent())  {
            Book updatedBook = bookOptional.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setIsbn(book.getIsbn());
            return new ResponseEntity<Book>(bookRepository.save(updatedBook), HttpStatus.OK);
        }  else  {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteABook(@PathVariable("id") String id)
    {
        log.info("deleteABook(" + id + ") called");
        try  {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }  catch (Exception e)  {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}