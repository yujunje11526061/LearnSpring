package dynamicProxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {


        // 静态代理不方便复用，对于每一个要代理的方法，都得在代理对象中一一实现代理逻辑
        System.out.println("以下由静态代理实现");
        IObject realObject = new RealObject();
        IObject proxyObject = new ProxyObject(realObject);
        proxyObject.doSomething();

        System.out.println("以下由JDK动态代理实现");
        // JDK动态代理基于接口实现，适用于没有被代理对象实现接口的情况
        // 动态代理把通用的代理封装成一个Handler，传给Proxy的工厂方法。
        JdkDynamicProxyHandler jdkDynamicProxyHandler = new JdkDynamicProxyHandler(new RealObject());
        // 第一个参数指定代理对象的类加载器(通常可以从已经创建的对象中获取并传递给他)
        // 指定代理对象需要实现的接口列表
        // 指定代理执行所需要分派的handler，即必须传入一个实现了InvocationHandler接口的对象，在其invoke方法中实现代理的逻辑。故该handler可被复用.
        // 然后就会创建一个实现了所有指定接口的代理对象，完事后需要强转为后面要执行方法所对应的接口。
        // 此后调用代理对象的handler指定方法，即可执行handler中invoke方法的逻辑
        IObject proxy = (IObject) Proxy.newProxyInstance(IObject.class.getClassLoader(), new Class[]{IObject.class}, jdkDynamicProxyHandler);
        proxy.doSomething();


        System.out.println("以下由cglib实现动态代理");
        // cglib动态代理基于继承实现，适用于没有被代理对象没有实现接口的情况
        /**
         * Enhancer的作用
         * Generates dynamic subclasses to enable method interception. This
         * class started as a substitute for the standard Dynamic Proxy support
         * included with JDK 1.3, but one that allowed the proxies to extend a
         * concrete base class, in addition to implementing interfaces. The dynamically
         * generated subclasses override the non-final methods of the superclass and
         * have hooks which callback to user-defined interceptor
         * implementations.
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealObject.class); // 设置父类，即要被代理的类
        enhancer.setCallback(new CglibDynamicProxyInterceptor()); // 设置要植入的拦截器
        IObject cglibProxy = (IObject) enhancer.create(); // 创建代理对象
        cglibProxy.doSomething();
    }
}
