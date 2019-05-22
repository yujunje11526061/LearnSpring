package actionScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfDefineScopeTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("selfDefineScope.xml");

        System.out.println("\n自定义双例的scope实验，从输出可以看到，自定义双例模式下，当前上下文通过getBean只可能返回两个实例。");
        Map<Son, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            Son son = context.getBean("son", Son.class);
            map.merge(son, 1, Integer::sum);
        }
        ((ConcurrentHashMap<Son, Integer>) map).forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\nspring自带的simpleThreadScope实验，从输出可以看到，通过同一个bean，单个线程能得到单个实例，不同线程有不同实例");
        for (int i = 0; i < 3; i++) {
            Son son2 = context.getBean("son2", Son.class);
            System.out.println(Thread.currentThread().getName() + " : " + son2);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Son son2 = context.getBean("son2", Son.class);
                    System.out.println(Thread.currentThread().getName() + " : " + son2);
                }
            });
            thread.start();
        }
    }
}
