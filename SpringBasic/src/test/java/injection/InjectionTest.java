package injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InjectionTest {

    @Test
    public void test(){
        System.out.println("现在开始属性注入实验");
        ApplicationContext context = new ClassPathXmlApplicationContext("injection.xml");
        Bean bean1 = context.getBean("bean1", Bean.class);
        Bean bean2 = context.getBean("bean2", Bean.class);
        List<Bean> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        for(Bean bean:list) {
            System.out.println();
            System.out.println(bean.toString1());
            System.out.println(bean.toString2());
        }
        BeanWithCollections beanWithCollections = context.getBean("beanWithCollections", BeanWithCollections.class);
        HashMap<String, Integer> hashMap = context.getBean("hashMap",HashMap.class);
        hashMap.put("xxxxx",777777);
        hashMap.put("yyyyy",888888);
//      由下面输出可见，若属性用的接口类型，默认用的容器是LinkedHashMap，LinkHashSet，ArrayList。
//      如果要使用特定容器，则可以定义属性时使用特定类型。
//      或者额外注入一个特定容器，用标签中的ref属性引用目标容器对应的bean，但是里面的元素得在代码里自行填充
        System.out.println(beanWithCollections);
        Field[] fields = beanWithCollections.getClass().getDeclaredFields(); // 返回所有属性，包括私有的，但不包括继承来的。
        for(Field field:fields){
            field.setAccessible(true);
            try {
                System.out.println(field.get(beanWithCollections).getClass().getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
