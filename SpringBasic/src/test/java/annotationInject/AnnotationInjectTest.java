package annotationInject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class AnnotationInjectTest {

    @Test
    public void test() {
        System.out.println("\n---------------------注解法依赖注入的实现方式、beanID指定、scope、方法注入、required与否实验，创建与销毁----------------------------------");
        testDependencyInjectionAndScope();
        System.out.println("\n---------------------容器注入，内置接口注入与简单类型直接注入实验----------------------------------");
        testCollectionAndSimpleTypeInjection();
    }

    public void testDependencyInjectionAndScope() {
        System.out.println("\n来自配置类的上下文");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class); // 还可以指定一个包路径
        BeanX beanX = context.getBean("bean1", BeanX.class);
        Bean bean = context.getBean("bean", Bean.class);
        Bean beanbean = context.getBean("bean", Bean.class);
        System.out.println(bean);
        System.out.println(beanbean);
        System.out.println(beanX);
        System.out.println("bean==beanbean: " + (bean == beanbean)); // 因为bean的scope="prototype", 其依赖的beanZ也是多例的，不设置默认为单例

        System.out.println("\n来自XML文件的上下文");
        ApplicationContext contextFromXML = new ClassPathXmlApplicationContext("annotationInject.xml");
        Bean beanFromXML = contextFromXML.getBean("bean", Bean.class);
        Bean beanbeanFromXML = contextFromXML.getBean("bean", Bean.class);
        System.out.println(beanFromXML);
        System.out.println(beanbeanFromXML);
        BeanX beanbeanX = contextFromXML.getBean("bean1", BeanX.class);
        System.out.println(beanbeanX);
        // 由输出可以看到，来自两个上下文的单例不等同，但起到的效果相同，只是自成一个上下文。
        // 且通过注册工厂方法而非@Componet的类BeanX也照样能被xml配置方法扫到，说明ComponentScan既可以用注解加在配置类里，也可以写在xml文件里，二选一即可。

        System.out.println("\n创建与销毁实验"); // 配置了全局懒加载，使用时才创建。
        InitAndDestroy initAndDestroy = contextFromXML.getBean("instanceForTestingInitAndDestroy", InitAndDestroy.class);
        ((ClassPathXmlApplicationContext) contextFromXML).close();

        System.out.println("\n自定义作用域实验");
        Map<DoubletonBean, Integer> map = new ConcurrentReferenceHashMap<>();
        for (int i = 0; i < 10; i++) {
            DoubletonBean doubletonBean = context.getBean("doubletonBean", DoubletonBean.class);
            map.merge(doubletonBean, 1, Integer::sum);
        }
        System.out.println(map);

        System.out.println("\n方法注入实验");
        BeanWithMethodInjection beanWithMethodInjection = context.getBean("beanWithMethodInjection", BeanWithMethodInjection.class);
        Set<BeanZ> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(beanWithMethodInjection.getBeanZ());
        }
        System.out.println(set.size());

    }

    public void testCollectionAndSimpleTypeInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        BeanWithCollections beanWithCollections = context.getBean("beanWithCollections", BeanWithCollections.class);
        System.out.println(beanWithCollections);
    }
}
