package mdm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mdm.devices.RoleType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "devices")
public class Device {
    @NonNull
    @Field("id")
    private String id;

    @NonNull
    @Field("role")
    private String role;

    @NonNull
    @Field("group")
    private String group;
}