package com;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
1. 实例化Bean
2. 保存Bean
3. 提供Bean
4. 每一个Bean都应该有一个ID与之对应，从而可以取到。
 */


public class IocContainer {
    private Map<String, Object> map = new ConcurrentHashMap<>();

    /**
     * @param beanID
     * @return
     */
    public Object getBean(String beanID) {
        return map.get(beanID);
    }

    /**
     * 委托Ioc容器创建一个bean, 并假设所依赖的bean已经被创建并保存好了
     *
     * @param beanID         要创建的bean的beanID
     * @param beanClass      要创建按的bean的class
     * @param beanParameters 要创建的bean所依赖的bean们的beanID列表
     */
    public void setBean(String beanID, Class<?> beanClass, String... beanParameters) {
        // 1. 组装构造方法所需要的参数
        Object[] paramTable = new Object[beanParameters.length];
        for (int i = 0; i < beanParameters.length; i++) {
            paramTable[i] = map.get(beanParameters[i]);
        }

        // 2. 遍历各个构造方法，直到碰到合适的为止
        Object bean = null;
        for (Constructor<?> constructor : beanClass.getConstructors()) {
            try {
                bean = constructor.newInstance(paramTable);
                break;
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        // 前面的构造异常都不处理，如果不满足任何一个构造方法，则bean一定为null，主动抛出异常
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法去实例化该bean");
        }

        // 3. 讲实例化后的bean保存起来
        map.put(beanID, bean);
    }
}
