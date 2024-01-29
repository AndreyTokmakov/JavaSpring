package lifecycle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MixedService implements InitializingBean, DisposableBean {

	public MixedService() {
		log.info(this.getClass().getName() + " created");
	}
	
    @PostConstruct
    public void annotationInit() {
    	log.info("Initializing since @PostConstruct");
    }

    @PreDestroy
    public void annotationDestroy() {
    	log.info("Destroying since @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
    	log.info("Destroying since DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    	log.info("Initializing since InitializingBean");
    }

    public void customInit() {
    	log.info("Initializing since init-method");
    }

    public void customDestroy() {
    	log.info("Destroying since destroy-method");
    }
}
