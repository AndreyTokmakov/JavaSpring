package service_users_and_balances.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_users_and_balances.model.entities.AccountType;
import service_users_and_balances.model.SpotBalancesRepository;

@Log4j2
@Service
public class BalancesService
{
    @Autowired
    SpotBalancesRepository spotBalancesRepository;

    public BalancesService()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public void findByAccount()
    {
        System.out.println("=".repeat(180));
        System.out.println("BalancesService::findByAccount()");
        System.out.println("=".repeat(180));
        var balance = spotBalancesRepository.findByAccountTypeAndSubAccountEmail(
                AccountType.SubAccount, "");
    }
}
