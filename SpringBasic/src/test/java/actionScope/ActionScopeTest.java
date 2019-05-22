package actionScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionScopeTest {
    @Test
    public void test() {
        System.out.println("\n已知Father中有Son类，即Father依赖于Son");

        System.out.println("\nCase 1: 双单例测试，默认的scope就是singleton，返回的父子都是同一个实例");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("actionScope.xml");
        Father father1_1 = context1.getBean("father1", Father.class);
        Father father1_2 = context1.getBean("father1", Father.class);
        System.out.println(father1_1);
        System.out.println(father1_2);
        System.out.println("father1_1==father1_2: " + (father1_1 == father1_2));
        System.out.println("father1_1'son==father1_2'son: " + (father1_1.getSon() == father1_2.getSon()));

        System.out.println("\nCase 1': 不同上下文的单例测试，可见不同上下文环境的单例是不一样的，spring的单例只对当前上下文有效");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("actionScope.xml");
        Father father1_3 = context2.getBean("father1", Father.class);
        System.out.println(father1_3);
        System.out.println("father1_1==father1_3: " + (father1_1 == father1_3));
        System.out.println("father1_1'son==father1_3'son: " + (father1_1.getSon() == father1_3.getSon()));

        System.out.println("\nCase 2: 双多例测试，返回的父子都不同");
        Father father2_1 = context1.getBean("father2", Father.class);
        Father father2_2 = context1.getBean("father2", Father.class);
        System.out.println(father2_1);
        System.out.println(father2_2);
        System.out.println("father2_1==father2_2: " + (father2_1 == father2_2));
        System.out.println("father2_1'son==father2_2'son: " + (father2_1.getSon() == father2_2.getSon()));

        System.out.println("\nCase 3: 父多例、子单例测试，返回的父不同，子相同");
        Father father3_1 = context1.getBean("father3", Father.class);
        Father father3_2 = context1.getBean("father3", Father.class);
        System.out.println(father3_1);
        System.out.println(father3_2);
        System.out.println("father3_1==father3_2: " + (father3_1 == father3_2));
        System.out.println("father3_1'son==father3_2'son: " + (father3_1.getSon() == father3_2.getSon()));

        System.out.println("\nCase 4: 父单例、子多例测试，返回的父子都相同，因为父只有一个，取子比较必然是同一个");
        Father father4_1 = context1.getBean("father4", Father.class);
        Father father4_2 = context1.getBean("father4", Father.class);
        System.out.println(father4_1);
        System.out.println(father4_2);
        System.out.println("father4_1==father4_2: " + (father4_1 == father4_2));
        System.out.println("father4_1'son==father4_2'son: " + (father4_1.getSon() == father4_2.getSon()));

        // 可以看到即使Mother是一个抽象类，仍能生成mother实例，实际上是利用了动态代理，mother是代理类生成的。
        System.out.println("\nCase 5: 母单例，子多例的情况，通过方法产生孩子，而不是用属性记录，则每次返回的孩子都不一样，这是方法注入");
        Mother mother1 = context1.getBean("mother", Mother.class);
        Mother mother2 = context1.getBean("mother", Mother.class);
        System.out.println(mother1);
        System.out.println(mother2);
        System.out.println("mother1==mother2: " + (mother1 == mother2));
        System.out.println("mother1'son==mother2'son: " + (mother1.getSon() == mother2.getSon()));

        System.out.println("\n同一个类不同的单例bean产生的实例并不同，即区分原生类的单例和bean的单例");
        System.out.println("father1_1==father4_1: " + (father1_1==father4_1));


    }
}
