/**
 * @program: myautotest
 * @description: spring boot application
 * @author Nikll
 * @date 2019/5/15 21:31
 */
package com.nikll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @author Nikll

 * @date 2019/5/15 21:31

 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}