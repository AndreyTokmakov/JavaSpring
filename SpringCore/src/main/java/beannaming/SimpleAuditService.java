package beannaming;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SimpleAuditService implements AuditService
{
    public SimpleAuditService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }
}
