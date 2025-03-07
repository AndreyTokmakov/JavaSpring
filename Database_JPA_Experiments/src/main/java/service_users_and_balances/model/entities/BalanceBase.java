package service_users_and_balances.model.entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "balances")
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
