/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* QualifierA4.java class
*
* @name    : QualifierA4.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 11, 2021
****************************************************************************/

package qualifier.demo1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 
import org.springframework.beans.factory.annotation.Qualifier;
 
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface QualifierA4 {
	public String value() default "A4";
}