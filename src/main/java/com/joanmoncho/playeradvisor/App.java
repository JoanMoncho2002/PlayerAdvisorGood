package com.joanmoncho.playeradvisor;

import com.joanmoncho.playeradvisor.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //Run runApp = appContext.getBean(Run.class);

        //runApp.run(args);

        ((AnnotationConfigApplicationContext) appContext).close();


    }

}
