package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
//@PropertySource(value ={})  // 默认从全局配置文件读，可使用该注解指定配置文件，但是该注解不支持读取指定的yml文件，只能读取properties文件，除非自定义yml文件的读取工厂，实现PropertySourceFactory接口
@ConfigurationProperties(prefix = "book")
public class Book {

    @Autowired
    public Author author;

    // 当只需配置几个属性的时候可以这样单独设置，配置整个组建的属性的话直接@ConfigurationProperties映射配置文件更好
    //    @Value("#{book.name}")
    public String name;

    public Map<String, String> map;
    public List<Integer> list;

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", name='" + name + '\'' +
                ", map=" + map +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
