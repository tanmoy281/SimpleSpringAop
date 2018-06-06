package com.tanmoy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tanmoy.config.AppConfig;
import com.tanmoy.service.CalculateSomething;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculateSomething obj = (CalculateSomething) context.getBean("calculateSomething");
        obj.makeMyCalculation();
        obj.returnSomeValue();
        obj.makeSomeOtherCalculation();
        obj.throwSomeException();
        
    }
}
