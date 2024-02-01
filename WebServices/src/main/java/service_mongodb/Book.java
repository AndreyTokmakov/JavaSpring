package service_mongodb;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private String id;

    @NonNull
    @Field("title")
    private String title;

    @NonNull
    @Field("author")
    private String author;

    @NonNull
    @Field("isbn")
    private String isbn;
}