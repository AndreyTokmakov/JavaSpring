package service_mongodb.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import service_mongodb.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>
{
    List<Book> findByTitleContaining(String title);

    List<Book>  findByAuthor(String name);
}