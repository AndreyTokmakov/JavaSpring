package users_repository;


//import jakarta.persistence.*;
//import javax.persistence.GeneratedValue;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy= javax.persistence.GenerationType.AUTO)
    private String userId;

    private String name;
    private String email;
    private String timestamp;
}
