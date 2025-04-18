package beannaming;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class AuditConfiguration
{

    public AuditConfiguration() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Bean("simple")
    @Qualifier("qualifiedSimple")
    public AuditService theSimpleOne()
    {
        log.info("AuditService::theSimpleOne() called");
        return new SimpleAuditService();
    }

    @Bean
    public AuditService obsolete()
    {
        log.info("AuditService::obsolete() called");
        return new LegacyAuditService();
    }
}
