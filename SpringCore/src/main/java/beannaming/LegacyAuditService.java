package beannaming;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class LegacyAuditService implements AuditService
{
    public LegacyAuditService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }
}
