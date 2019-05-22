package actionScope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Doubleton implements Scope {
    /**
     * 自定义作用域，实现双例模式
     * 要实现org.springframework.beans.factory.config.Scope接口
     */

    private Map<String, Object> map1 = new ConcurrentHashMap<>();
    private Map<String, Object> map2 = new ConcurrentHashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if(!map1.containsKey(s)){
            map1.put(s, objectFactory.getObject());
            return map1.get(s);
        }
        if(!map2.containsKey(s)){
            map2.put(s, objectFactory.getObject());
            return map2.get(s);
        }

        int n = new Random().nextInt(2);
        return n==0?map1.get(s):map2.get(s);
    }

    @Override
    public Object remove(String s) {
        if(map1.containsKey(s)){
            return map1.remove(s);
        }
        if(map2.containsKey(s)){
            return map2.remove(s);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }


}
