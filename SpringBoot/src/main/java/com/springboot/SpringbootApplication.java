package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;





//此为引导类，也是主配置类

//@EnableAutoConfiguration() 此注解用于排除不需要自动配置的类。
//默认情况下spring boot只会扫描启动类当前包和以下的包，别的包需要用String[]指定
//以下注解是一个组合注解，包括@ComponentScan，@EnableAutoConfiguration， @Configuration
@SpringBootApplication(scanBasePackages = {"com"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
