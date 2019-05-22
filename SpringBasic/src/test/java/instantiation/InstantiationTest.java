package instantiation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiationTest {

    @Test
    public void test(){
        /**
         * 可见把bean交给spring统一管理，不管用哪种方法创建bean，业务代码里的写法都是统一整齐的。
         * 只需要获得上下文后，指定beanID以及bean类型即可从上下文获取对应的bean。
         */
        System.out.println("现在测试多种方法创建bean, 由输出可知，导入xml文件后，是先由spring创建完所有bean，再执行下面测试代码, 故会有别的包中的bean乱入");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 -> "+bean1);

//        Bean2 bean2 = BeanFactory.getBean2(); // 静态工厂方法创建，这是通常的代码写法，如果交由spring管理则如下
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 -> "+bean2);


//        BeanFactory beanFactory = new BeanFactory(); // 工厂实例方法创建，常规写法
//        Bean3 bean3 = beanFactory.getBean3();
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("bean3 -> "+bean3);

//        别名的使用，可见别名指向的都是同一个bean
        Bean4 bean4_1 = context.getBean("bean4_1", Bean4.class);
        Bean4 bean4_2 = context.getBean("bean4_2", Bean4.class);
        Bean4 bean4_3 = context.getBean("bean4_3", Bean4.class);
        Bean4 bean4_4 = context.getBean("bean4_4", Bean4.class);
        System.out.println("bean4_1 -> "+bean4_1);
        System.out.println("bean4_2 -> "+bean4_2);
        System.out.println("bean4_3 -> "+bean4_3);
        System.out.println("bean4_4 -> "+bean4_4);
    }
}
