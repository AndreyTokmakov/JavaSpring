package beannaming;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DatabaseService
{
    public DatabaseService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Autowired
    @Qualifier("simple")
    private AuditService simpleAuditServiceFromBean;

    @Autowired
    @Qualifier("qualifiedSimple")
    private AuditService simpleAuditServiceFromQualifier;

    @Autowired
    @Qualifier("advanced")
    private AuditService advancedAuditServiceFromComponent;

    @Autowired
    @Qualifier("qualifiedAdvanced")
    private AuditService advancedAuditServiceFromQualifier;

    @Autowired
    @Qualifier("legacyAuditService")
    private AuditService legacyAuditServiceFromDefault;

    @Autowired
    @Qualifier("obsolete")
    private AuditService obsoleteAuditServiceFromMethodName;
}
