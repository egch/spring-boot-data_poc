package org.enricogiurin.poc.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by enrico on 2/12/17.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("printing beans provided by Spring Boot:");

            String[] beans = ctx.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String name : beans) {
                System.out.println(name);
            }

        };
    }

}
