package annotationconfig;

import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component("history")
public class HistoryService {
	
	private static final Logger logger = LogManager.getLogger(HistoryService.class);
	  
	public HistoryService() {
		logger.info(this.getClass().getName() + " created");
	}

    public void store() {
        System.out.println("Storing the history");
    }
}
