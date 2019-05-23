package com.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return slf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
