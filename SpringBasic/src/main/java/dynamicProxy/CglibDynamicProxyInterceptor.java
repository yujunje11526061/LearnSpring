package dynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyInterceptor implements MethodInterceptor {

    /**
     * 即定义一个指定方法的拦截器
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这里是cglib动态代理拦截器的内部");
        System.out.println("Before in cglib");
        Object result = null;
        try{
            // cglib动态代理是通过继承实现的，继承目标类为指定方法创建代理方法，故执行实际方法用invokeSuper
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            System.out.println("Get exception: "+ e);
        }finally {
            System.out.println("After in cglib");
        }
        return result;
    }
}
