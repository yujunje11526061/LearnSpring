package injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BeanWithCollections {
    private Map<String, Integer> map;
    private Map<AnotherBean, AnotherBean> beanMap;
    private ConcurrentHashMap<AnotherBean, AnotherBean> concurrentHashMap;
    private Set<String> set;
    private Set<AnotherBean> beanSet;
    private List<String> list;
    private List<AnotherBean> beanList;
    private Properties properties;

//    右键generate或alt+insert键可以快速生成一些方法

    @Override
    public String toString() {
        return "\nBeanWithCollections{" +
                "\nmap=" + map +
                "\nbeanMap=" + beanMap +
                "\nconcurrentMap=" + concurrentHashMap +
                "\nset=" + set +
                "\nbeanSet=" + beanSet +
                "\nlist=" + list +
                "\nbeanList=" + beanList +
                "\nproperties=" + properties +
                "\n}";
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<AnotherBean, AnotherBean> getBeanMap() {
        return beanMap;
    }

    public void setBeanMap(Map<AnotherBean, AnotherBean> beanMap) {
        this.beanMap = beanMap;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Set<AnotherBean> getBeanSet() {
        return beanSet;
    }

    public void setBeanSet(Set<AnotherBean> beanSet) {
        this.beanSet = beanSet;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<AnotherBean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<AnotherBean> beanList) {
        this.beanList = beanList;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public ConcurrentHashMap<AnotherBean, AnotherBean> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public void setConcurrentHashMap(ConcurrentHashMap<AnotherBean, AnotherBean> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }
}
