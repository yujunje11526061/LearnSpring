package inherit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("inherit.xml");
//        配置文件中，father若标记为abstract="true"，则不会创建该bean，但他仍然可以注入属性供子类继承。
//        Father father = context.getBean("father", Father.class);
        Son son = context.getBean("son", Son.class);
        Son son1 = context.getBean("son1", Son.class);
        Daughter daughter = context.getBean("daughter", Daughter.class);
        Daughter daughter1 = context.getBean("daughter1", Daughter.class);
//        System.out.println(father);
        System.out.println(son);
        System.out.println(daughter);
        System.out.println(son1);
        System.out.println(daughter1);
    }
}
