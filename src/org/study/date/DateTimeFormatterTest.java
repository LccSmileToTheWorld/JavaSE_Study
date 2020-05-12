package org.study.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormatter测试.
 * 该类提供了三种格式化方法
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/11     
 */
public class DateTimeFormatterTest {

    /**
     *<p> 预定义的标准格式.
     *
     */
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        //获取实例
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        //格式化
        String format = isoDateTime.format(now);
        System.out.println(format);
        //解析
        TemporalAccessor parse = isoDateTime.parse(format);
        System.out.println(parse);
    }

    /**
     *<p> 本地化相关的格式.
     *
     */
    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        //获取实例
        DateTimeFormatter isoDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format = isoDateTime.format(now);
        System.out.println(format);
    }

    /**
     *<p> 自定义格式.
     *
     */
    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now();
        //获取实例
        DateTimeFormatter isoDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String format = isoDateTime.format(now);
        System.out.println(format);
    }
}
