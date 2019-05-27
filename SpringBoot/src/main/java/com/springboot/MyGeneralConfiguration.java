package com.springboot;

import com.utils.MyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

@Configuration
public class MyGeneralConfiguration {

    @Bean // 由WebMvcAutoConfiguration类的源码知，会自动搜索容器中存在的Converter
    public Converter<String, Date> getConverter() {
        return new MyConverter();
    }
}
