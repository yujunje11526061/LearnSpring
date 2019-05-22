package dataBinding.formatterAndConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyFormatter implements org.springframework.format.Formatter<Date> {
    /**
     * 把String类型转化为泛型类型,这里为Date
     *
     * @param
     * @param
     * @return
     * @throws ParseException
     */

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
        return sdf.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
