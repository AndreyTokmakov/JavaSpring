/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* QualifierAnnotationExample.java class
*
* @name    : QualifierAnnotationExample.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 11, 2021
****************************************************************************/

package qualifier.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
 
@Configuration
@Import(Config.class)
public class QualifierAnnotationExample {
 
	@Autowired
	@Qualifier("beanA")
	private BeanA beanA;
 
    @Autowired
    @Qualifier("beanA0")
    private BeanA beanA0;
 
    @Autowired
    @Qualifier
    private BeanA beanA1;
 
    @Autowired
    @Qualifier("A3")
    private BeanA beanA3;
 
    @Autowired
    @QualifierA4
    private BeanA customQualifiedBeanA;
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(QualifierAnnotationExample.class);
        try {
            QualifierAnnotationExample qualifierAnnotationExample = 
            		(QualifierAnnotationExample) context.getBean("qualifierAnnotationExample");
 
            System.out.println("BeanA member: " + qualifierAnnotationExample.getBeanA());
            System.out.println("BeanA1 member: " + qualifierAnnotationExample.getBeanA1());
            System.out.println("Qualified BeanA member: " + qualifierAnnotationExample.getBeanA3());
            System.out.println("Custom Qualified BeanA member: " + qualifierAnnotationExample.getCustomQualifiedBeanA());
            System.out.println("InnerConfig:\n" + context.getBean("innerConfig"));
 
        } finally {
            context.close();
        }
    }
 
    public BeanA getBeanA() {
		return beanA;
    }
 
    public BeanA getBeanA0() {
		return beanA0;
    }
 
    public BeanA getBeanA1() {
		return beanA1;
    }
 
    public BeanA getBeanA3() {
		return beanA3;
    }
 
	public BeanA getCustomQualifiedBeanA() {
		return customQualifiedBeanA;
	}

	@Component("innerConfig")
	static class InnerConfig {
        private BeanA beanA;
        private BeanA beanA0;
        private BeanA beanA1;
        private BeanA beanA2;
        private BeanA beanA3;
        private BeanA beanA4;
 
        @Autowired
        public InnerConfig(@Qualifier("beanA") BeanA beanA,
                		   @Qualifier("beanA0") BeanA beanA0, 
                		   @Qualifier BeanA beanA1,
                		   @Qualifier("A2") BeanA beanA2, 
                		   @Qualifier("A3") BeanA beanA3,
                		   @QualifierA4 BeanA beanA4) {
            this.beanA  = beanA;
            this.beanA0 = beanA0;
            this.beanA1 = beanA1;
            this.beanA2 = beanA2;
            this.beanA3 = beanA3;
            this.beanA4 = beanA4;
        }
 
        public String toString() {
            return "BeanA(" + beanA + "),\nBeanA0(" + beanA0 + "),\nBeanA1("
                    + beanA1 + "),\nBeanA2(" + beanA2 + "),\nBeanA3(" + beanA3
                    + "),\nBeanA4(" + beanA4 + ")";
        }
    }
}