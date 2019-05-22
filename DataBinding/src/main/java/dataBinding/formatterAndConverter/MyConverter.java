package dataBinding.formatterAndConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements org.springframework.core.convert.converter.Converter<String, Date> {
    /**
     * IN转化为OUT,此处为String转化为Date
     * 相比Formatter更灵活,因为可以自定义IN, Formatter只能自定义OUT
     * @param
     * @return
     */

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf= new SimpleDateFormat("yy-mm-dd");
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
