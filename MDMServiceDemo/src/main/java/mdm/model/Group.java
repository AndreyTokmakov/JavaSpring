package mdm.model;

import lombok.*;
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