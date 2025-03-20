package beannaming;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
@Component("advanced")
@Qualifier("qualifiedAdvanced")
public class AdvancedAuditService implements AuditService
{
	public AdvancedAuditService() {
		log.info("{} created!", this.getClass().getSimpleName());
	}
}
