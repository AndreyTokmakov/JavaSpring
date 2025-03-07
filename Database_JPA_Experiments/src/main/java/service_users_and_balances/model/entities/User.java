package service_users_and_balances.model.entities;


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
    Integer userId;

    private String name;
    private String email;
    private String timestamp;
}
