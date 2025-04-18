package bean.bean_resolution;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BeenKeeper
{
    @Autowired
    //@Qualifier("makeProductPrimary")
    @Qualifier("makeProductSecondary")
    private Product product;

    public BeenKeeper()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    public void info()
    {
        log.info("{}::info()", this.getClass().getSimpleName());
        System.out.println(product);
    }
}
