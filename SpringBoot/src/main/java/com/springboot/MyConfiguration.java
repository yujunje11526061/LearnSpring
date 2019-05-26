package com.springboot;


import com.github.pagehelper.PageInterceptor;
import com.utils.MyConverter;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import javax.sql.DataSource;
import java.util.Date;
import java.util.Properties;

@Configuration
public class MyConfiguration {

    @Autowired
    DataSource dataSource;


    @Bean // 由WebMvcAutoConfiguration类的源码知，会自动搜索容器中存在的Converter
    public Converter<String, Date> getConverter() {
        return new MyConverter();
    }


    // 手动配置SqlSessionFactoryBean。一旦手动配置就会导致自动配置失效，很多相关的东西得自己配，具体参看MybatisAutoConfiguration源码。
    // 且由于不自动配置，applyConfiguration(factory)对此会话工厂失效，会导致全局配置文件中配的属性无法被用上
    // mybatis的相关属性在全局配置文件中以mybatis开头，MybatisProperties类组合了Configuration类，对应配置文件中的mybatis.configuration开头的属性，且这些属性和mybatis单独配置文件不能共存
    // 故自定义SqlSessionFactory的bean时，要配置三大关键要素：dataSource，Configuration，plugins。
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        // DataSource是必须设置的，可以注入自动配置的，也可以手动配置一个DataSource的Bean
        factoryBean.setDataSource(dataSource);



        // 配置插件，可选
        // 分页插件PageHelper 5.0+ 用的是PageInterceptor。分页的参数参见https://github.com/pagehelper/Mybatis-PageHelper，注意安全性
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        interceptor.setProperties(properties);

        // 插件的注册，需放在开启驼峰之前，否则由bug。
        factoryBean.setPlugins(new Interceptor[] {interceptor});

        // configuration的修改，可选
        // 开启驼峰命名，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的映射，否则会导致部分字段为查询结果为null
        factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

        return factoryBean.getObject(); // 获取其中的泛型对象SqlSessionFactory

    }


}
