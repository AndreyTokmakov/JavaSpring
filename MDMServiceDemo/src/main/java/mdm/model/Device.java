package mdm.model;

import lombok.*;
import mdm.devices.RoleType;
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