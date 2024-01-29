/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* BeanA.java class
*
* @name    : BeanA.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 11, 2021
****************************************************************************/

package qualifier.demo1;

public class BeanA {
    private String name;
     
    public BeanA() {
    	
    }
     
    public BeanA(String name){
        this.name = name;
    }
     
    @Override
    public String toString() {
        return name == null ? super.toString() : "BeanA(" + name + ")";                
    }
}