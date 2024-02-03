package mongodb_tests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mongodb_tests.devices.RoleType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "devices")
public class Device {
    @Id
    @Field("id")
    private String id;

    @Field("role")
    private RoleType role;

    @Field("group")
    private String group;
}