package lifecycle;

import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CustomMethodsService {

	public CustomMethodsService() {
		log.info(this.getClass().getName() + " created");
	}

    public void initialize() {
    	log.info("Initializing " + getClass().getSimpleName());
    }

    public void destroy() {
    	log.info("Destroying " + getClass().getSimpleName());
    }
}
