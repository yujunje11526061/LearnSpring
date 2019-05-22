package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    public void test(){
        System.out.println("现在测试Bean的创建");
        // 从ClassPath路径下找一个spring.xml文件，生成一个spring的上下文。
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // 获取bean
        Bean bean = context.getBean("bean", Bean.class); // getBean有多种重载方法，具体使用哪种参看源码
        System.out.println("bean = " + bean);
        System.out.println("\n");
    }
}
