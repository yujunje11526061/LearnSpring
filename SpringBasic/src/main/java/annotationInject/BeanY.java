package annotationInject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "newBean") // 此注解可以让ComponentScan可以扫到该类，并为之创建Bean，不同于在配置上下文的类中创建，此注解只能指定一个名字，因为源码显示value不是String[]，默认为类名，一旦指定，则类名无效。
@Scope(value = "singleton")
public class BeanY {
}
