package annotationInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 不指定value则没有名字，类名首字母小写作为beanID。如果指定则默认名无效。此法一个类只能产生一个bean，要想产生多个，则需要去配置类里注册工厂方法
@Scope(value = "prototype")
@Lazy(value = false) // 因为全局配置了懒加载，这里要非懒加载，得单独配置关闭懒加载，因为注解默认为true。
public class Bean {
    /**
     * 依赖关系的三种注入方式：
     * 1. 直接属性定义处注入
     * 2. 构造方法处注入
     * 3. setter方法注入
     */

    @Autowired // 通过直接注解属性定义来注入
    @Qualifier(value = "bean1") // 当同一个类存在多个bean时，可这样指定beanID
    private BeanX beanX;

    @Autowired(required = false)// required默认为true，表示找不到或者不能确定唯一一个符合类型的bean则报错，为false则表示不必须，找不到会跳过
    @Qualifier("XX") // 指定一个不存在的BeanID看是否报错
    private BeanX beanXX;

    private BeanZ beanZ;
    private BeanY beanY;

    public BeanY getBeanY() {
        return beanY;
    }

    @Autowired() // 通过setter方法来注入.
    public void setBeanY(BeanY beanY) {
        this.beanY = beanY;
    }

    @Autowired // 通过构造方法来注入
    public Bean(BeanZ beanZ) {
        this.beanZ = beanZ;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "beanX=" + beanX +
                ", beanXX=" + beanXX +
                ", beanZ=" + beanZ +
                ", beanY=" + beanY +
                '}';
    }
}
