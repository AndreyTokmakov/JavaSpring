package service_users_and_balances.model;

import org.springframework.data.jpa.repository.JpaRepository;
import service_users_and_balances.model.entities.AccountType;
import service_users_and_balances.model.entities.BalanceBase;

import java.util.List;
import java.util.UUID;

public interface BalanceRepository<BalanceEntity extends BalanceBase>
        extends JpaRepository<BalanceEntity, UUID> {
    List<BalanceEntity> findByAccountTypeAndSubAccountEmail(AccountType accountType,
                                                            String subAccountEmail);
}