package mongodb_tests.model;

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
@Document(collection = "groups")
public class Group {
    @Id
    @NonNull
    @Field("name")
    private String name;

    @Field("key")
    private String key;

    @Field("certificate")
    private String certificate;
}