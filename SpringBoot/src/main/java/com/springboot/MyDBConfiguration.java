package com.springboot;


import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Mybatis 的核心：
 * 1：sqlSession代表和数据库的一次会话，用完必须关闭
 * 2：sqlSession不是线程安全的，每次使用时都应该去获取新的对象
 * 3：mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
 *
 * 在spring中整合Mybatis，无需手动管理sqlSession的生成，连接和关闭，但是需要配置sqlSession工厂的Bean并交由Ioc容器管理，由该工厂Bean负责sqlSession的生成，连接和关闭
 */


@Configuration
@MapperScan(basePackages = {"com.mmall.dao"}, sqlSessionFactoryRef = "sqlSessionFactoryMaster" ) // 开启Mapper接口扫描，并和对应的sqlSessionFactory关联
@MapperScan(basePackages = {"com.mmall.dao2"}, sqlSessionFactoryRef = "sqlSessionFactorySlave")
public class MyDBConfiguration {

    DataSource dataSource;

    // 定义多个数据源，此时关于数据源的自动配置失效
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Primary
    public DataSource getMasterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource getSlaveDataSource(){
        return DataSourceBuilder.create().build();
    }


    public DataSource getDataSource() {
        return dataSource;
    }
    // 此处注入的应该时被标记为@Primary的Bean
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 手动配置SqlSessionFactoryBean。一旦手动配置就会导致自动配置失效，很多相关的东西得自己配，具体参看MybatisAutoConfiguration源码。
    // 且由于不自动配置，applyConfiguration(factory)对此会话工厂失效，会导致全局配置文件中配的属性无法被用上
    // mybatis的相关属性在全局配置文件中以mybatis开头，MybatisProperties类组合了Configuration类，对应配置文件中的mybatis.configuration开头的属性，且这些属性和mybatis单独配置文件不能共存
    // 故自定义SqlSessionFactory的bean时，要配置三大关键要素：dataSource，Configuration，plugins。
    @Bean(name = "sqlSessionFactoryMaster")
    @Primary // 指定当有多个同类型Bean时，注入时优先用哪个
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        // DataSource是必须设置的
        factoryBean.setDataSource(this.dataSource);


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


    @Bean(name = "sqlSessionFactorySlave") //此处直接用传参的方式并指定数据源的Bean，因为自动注入时只能注入一个，不指定则用被标记为@Primary的
    public SqlSessionFactory sqlSessionFactory2(@Qualifier(value = "slaveDataSource") DataSource slaveDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(slaveDataSource);
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        interceptor.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[] {interceptor});
        factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return factoryBean.getObject();

    }

}
