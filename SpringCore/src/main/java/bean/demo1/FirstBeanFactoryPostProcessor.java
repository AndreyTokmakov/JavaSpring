/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* FirstBeanFactoryPostProcessor.java class
*
* @name    : FirstBeanFactoryPostProcessor.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 25, 2020
****************************************************************************/

package bean.demo1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FirstBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public FirstBeanFactoryPostProcessor() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final BeanDefinition beanDefinition = beanFactory.getBeanDefinition("greetingBean");
        beanDefinition.setInitMethodName("sayHello");
    }
}
