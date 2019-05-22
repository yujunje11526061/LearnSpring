package instantiation;

public class BeanFactory {

    public static Bean2 getBean2(){
        System.out.println("通过静态工厂方法创建Bean2实例");
        return new Bean2();
    }

    public Bean3 getBean3(){
        System.out.println("通过工厂实例方法创建Bean3实例");
        return new Bean3();
    }
}
