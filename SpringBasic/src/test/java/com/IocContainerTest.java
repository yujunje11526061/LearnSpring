package com;

import com.car.Audi;
import com.car.Buick;
import com.human.Bob;
import com.human.Human;
import com.human.Jack;
import org.junit.Before;
import org.junit.Test;

public class IocContainerTest {
    private IocContainer iocContainer = new IocContainer();

    @Before
    public void before(){
        // 所有的依赖关系被集中管理起来了，每个类自身只需关注自己的业务逻辑。
        iocContainer.setBean("audi", Audi.class);
        iocContainer.setBean("buick", Buick.class);
        iocContainer.setBean("jack", Jack.class, "audi");
        iocContainer.setBean("bob", Bob.class, "buick");
    }

    @Test
    public void test(){
        Human jack = (Human) iocContainer.getBean("jack");
        jack.goHome();
        Human bob = (Human) iocContainer.getBean("bob");
        bob.goHome();
    }
}
