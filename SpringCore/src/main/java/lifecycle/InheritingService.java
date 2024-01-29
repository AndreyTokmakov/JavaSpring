package lifecycle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class InheritingService implements InitializingBean, DisposableBean {
	
	public InheritingService() {
		log.info(this.getClass().getName() + " created");
	}

    @Override
    public void afterPropertiesSet() throws Exception {
    	log.info("Initializing " + getClass().getSimpleName());
    }

    @Override
    public void destroy() {
    	log.info("Destroying " + getClass().getSimpleName());
    }
}
