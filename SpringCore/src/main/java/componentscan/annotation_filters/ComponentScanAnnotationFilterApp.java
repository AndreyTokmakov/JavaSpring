/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* ComponentScanAnnotationFilterApp.java class
*
* @name    : ComponentScanAnnotationFilterApp.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 24, 2020
****************************************************************************/

package componentscan.annotation_filters;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Animal.class))
public class ComponentScanAnnotationFilterApp {
    public static void main(String[] args) {
    }
}