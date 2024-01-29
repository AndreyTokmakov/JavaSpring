package beannaming;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component("advanced")
@Qualifier("qualifiedAdvanced")
public class AdvancedAuditService implements AuditService {
	private static final Logger logger = LogManager.getLogger(AdvancedAuditService.class);
	  
	public AdvancedAuditService() {
		logger.info(this.getClass().getName() + " created");
	}
}
