package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
@Component
public class AnnotationBasedService {

	public AnnotationBasedService() {
		log.info(this.getClass().getName() + " created");
	}

    @PostConstruct
    public void init() {
    	log.info("Initializing " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
    	log.info("Destroying " + getClass().getSimpleName());
    }
}
