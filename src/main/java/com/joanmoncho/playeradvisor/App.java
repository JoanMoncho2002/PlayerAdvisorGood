package com.joanmoncho.playeradvisor;

import com.joanmoncho.playeradvisor.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        PlayerAdvisorRunApp runApp = appContext.getBean(PlayerAdvisorRunApp.class);

        runApp.run(args);

        ((AnnotationConfigApplicationContext) appContext).close();

    }

}
