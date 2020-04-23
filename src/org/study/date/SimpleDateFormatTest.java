package org.study.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat格式化，解析时间.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/21     
 */
public class SimpleDateFormatTest {

    @Test
    public void test() throws ParseException {
        //无参构造器
        SimpleDateFormat format = new SimpleDateFormat();
        //有参构造器
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        //格式化
        String dateStr = format1.format(date);
        System.out.println(dateStr);
        //解析
        Date parse = format1.parse(dateStr);
        System.out.println(parse);
    }
}
