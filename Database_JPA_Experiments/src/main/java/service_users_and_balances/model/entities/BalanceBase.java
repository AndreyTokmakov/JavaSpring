package service_users_and_balances.model.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorColumn(name = "type", discriminatorType=DiscriminatorType.STRING)
@Table(name = "balances", uniqueConstraints=@UniqueConstraint(columnNames="type"))
public class BalanceBase
{
    /*
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= javax.persistence.GenerationType.AUTO)
    private Integer id;
    */

    /** Prior to Hibernate 6.2 - without - @GeneratedValue(strategy = GenerationType.UUID) **/
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "sub_account_email")
    private String subAccountEmail;
}
