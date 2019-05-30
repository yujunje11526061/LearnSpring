package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyHandler implements InvocationHandler {

    // handler中需要组合实际的被代理对象
    private IObject realObject;

    public JdkDynamicProxyHandler(IObject realObject) {
        this.realObject = realObject;
    }

    /**
     *
     * @param proxy 客户端中封装了持有该handler对象的代理对象
     * @param method 真实对象要被代理方法
     * @param args 方法执行所需要的参数。
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是handler的invoke方法内部");
        System.out.println("Before...");
        Object result = null;
        try{
            result=method.invoke(realObject,args); // 调用被代理对象的method方法。
        }catch (Exception e){
            System.out.println("Get exception: "+ e);
        }finally {
            System.out.println("After...");
        }
        return result;
    }

}
