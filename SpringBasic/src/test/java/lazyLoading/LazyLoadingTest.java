package lazyLoading;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyLoadingTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("lazyLoading.xml");
        // 可以看到普通bean在上下文创建时就被加载，lazyBean则是在使用时加载，默认bean是按照全局设置加载，全局不设置则默认非懒加载。
        // 可以在配置bean的时候设置懒加载开关。
        // 懒加载可以节约资源，对象不会过早创建，但增加了使用时的延迟
        System.out.println(context);
        Bean bean = context.getBean("bean", Bean.class);
        Bean defaultBean = context.getBean("defaultBean", Bean.class);
        Bean lazyBean = context.getBean("lazyBean", Bean.class);

    }
}
