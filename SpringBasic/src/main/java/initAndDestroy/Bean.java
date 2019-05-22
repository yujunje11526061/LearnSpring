package initAndDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean implements InitializingBean, DisposableBean {

    public Bean(){
        System.out.println("Constructing");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying by implementing interface");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing by implementing interface");
    }

    public void onInit(){
        System.out.println("Initializing");
    }

    public void onDestroy(){
        System.out.println("Destroying");
    }
}
