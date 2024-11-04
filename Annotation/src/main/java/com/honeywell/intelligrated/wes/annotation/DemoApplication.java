package com.honeywell.intelligrated.wes.annotation;

import com.honeywell.intelligrated.wes.annotation.business.MyService1;
import com.honeywell.intelligrated.wes.annotation.business.MyService2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            MyService1 myService1 = ctx.getBean(MyService1.class);
            MyService2 myService2 = ctx.getBean(MyService2.class);

//            myService1.method1("Test Input 1", 123);
//            myService1.method2(456, true);
//            myService1.method3(false, 78.9);
//
//            myService2.method1("Test Input 2", 789);
//            myService2.method2(101, false);
//            myService2.method3(true, 23.45);
        };
    }
}
