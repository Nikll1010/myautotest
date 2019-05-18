/**
 * @program: myautotest
 * @description: spring boot application
 * @author Nikll
 * @date 2019/5/15 21:31
 */
package com.nikll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @author Nikll

 * @date 2019/5/15 21:31

 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan(basePackages = "com.nikll.mapper.UserDao")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}