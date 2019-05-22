package annotationInject;

import actionScope.Doubleton;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// spring会生成一个BeanFactory叫做myConfiguration
// 某个类想要创建自己的bean就通过@Bean注解注册一个工厂方法
// 工厂还能通过加@ComponentScan注解去搜罗想要创建bean的类


@Configuration // 指明该类是用来配置spring上下文的，功效类似xml文件
@ComponentScan(value = {"annotationInject"}) // 定义要扫描的包路径，可以是一个数组传入多个路径。路径下的加了@Component注解的class会被创建相应的bean
@Lazy // 全局配置，不加注解则是非懒加载，加了注解默认懒加载。
public class MyConfiguration {

    // 要交由spring管理bean的类可以通过@Bean注解注册一个工厂方法，返回相应实例的
    @Bean(value = {"bean1", "anotherBean"}) // value参数可以指定多个名字，注意：如果没指定，则bean名字默认为工厂方法名，如指定了，则工厂方法名失效。
    public BeanX beanX(){ return new BeanX();}  // 方法中创建相应类例

    // 可以注册实例工厂方法，也可以设置静态工厂方法。
    @Bean(value = "doubleton")
    public static Doubleton myScope(){return new Doubleton();}

    // @Bean method MyConfiguration.getCustomScopeConfigurer is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details.
    // 如果声明为静态工厂方法则会出现以上提示。
    @Bean
    public static CustomScopeConfigurer getCustomScopeConfigurer(){
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("doubleton", myScope());
        return customScopeConfigurer;
    }

    // 创建与销毁的配置，类似xml配置，如果要自定义，则Java9以后只能用注册工厂函数法。不过实现接口方法是最方便的，都不需要手动指定。
    @Bean(value = "instanceForTestingInitAndDestroy", initMethod = "onInit", destroyMethod = "onDestroy")
    public InitAndDestroy getInstanceToTestInitAndDestroy(){
        return new InitAndDestroy();
    }

    @Bean(value = "specificList")
    public List<String> list(){
        List<String> list= new ArrayList<>();
        list.add("aaaaa");
        list.add("bbbbb");
        return list;
    }

    @Bean
    @Order(value = 43342)
    public String string1(){return "222222";}

    @Bean
    @Order(value = 63)
    public String string2(){return "333333";}

    @Bean(value = "specificMap")
    public Map<String,Integer> map(){
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("xxxxx", 4132412);
        map.put("yyyyy", 413497);
        return map;
    }

    @Bean
    @Order(value = 43342)
    public int int1(){return 222222;}

    @Bean
    @Order(value = 63)
    public int int2(){return 333333;}
}
