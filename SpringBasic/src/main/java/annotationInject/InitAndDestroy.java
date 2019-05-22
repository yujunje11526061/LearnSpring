package annotationInject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class InitAndDestroy implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy by implementing interface");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init by implementing interface");
    }

    public void onInit(){
        System.out.println("Init by self-defined method");
    }

    public void onDestroy(){
        System.out.println("Destroy by self-defined method");
    }
}
