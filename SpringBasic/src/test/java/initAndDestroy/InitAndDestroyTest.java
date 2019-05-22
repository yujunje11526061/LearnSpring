package initAndDestroy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitAndDestroyTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("initAndDestroy.xml");
        context.getBean("bean", Bean.class);
        context.getBean("bean2", Bean2.class);

//      通过实现接口的初始化的创建方法，则必然会被执行，且先于自定义方法被执行。
        ((ClassPathXmlApplicationContext) context).close();
    }
}
