package annotationInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BeanWithCollections {

    @Value(value = "0x7fffffff")
    private int number;

    @Value(value = "简单类型直接注入")
    private String statement;

    // springIoC容器内置接口实例注入。
    @Autowired
    private ApplicationContext context;
    @Autowired
    private Environment environment;

    // 直接注入则会把容器中所有符合泛型类的bean都注入到新容器中，且按照Order注解的值从小到大排序，而不会注入现成已经有的容器。
    @Autowired
    private  List<String> list;

    // 想要注入现成有的某个b容器，则需要专门指定容器对应的beanID
    @Autowired
    @Qualifier(value = "specificList")
    private List<String> specificList;

    // map也会把返回值符合Value泛型类的bean都注入到新容器中，beanID充当Key
    @Autowired
    private Map<String, Integer> map;

    @Autowired()
    @Qualifier(value = "specificMap")
    private Map<String, Integer> specificMap;

    @Override
    public String toString() {
        return "BeanWithCollections{" +
                "\nnumber=" + number +
                ", statement='" + statement + '\'' +
                ", \ncontext=" + context +
                ", \nenvironment=" + environment  +
                ", \nlist=" + list +
                ", specificList=" + specificList +
                ", \nmap=" + map +
                ", specificMap=" + specificMap +
                '}';
    }
}
