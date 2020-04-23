package org.study.date;

import org.junit.Test;

import java.util.Date;

/**
 * Date类测试.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/23     
 */
public class DateTest {

    @Test
    public void test1(){
        //无参构造器
        Date date = new Date();
        /**
         * 调用toString(),返回以下形式的字符串： dow mon dd hh:mm:ss zzz yyyy
         * 其中： dow 是一周中的某一天 (Sun, Mon, Tue,Wed, Thu, Fri, Sat) zzz 是时间标准
         */
        System.out.println(date);
        //获取时间戳
        long time = date.getTime();
        System.out.println(time);
        //以时间戳作为参数的构造器
        Date date1 = new Date(time);
        System.out.println(date1);
        /**
         * java.util.Date 转换为 java.sql.Date
         * 1.java.util.Date获取时间戳
         * 2.java.sql.Date有参构造器
         */
        Date date2 = new java.sql.Date(time);
        System.out.println(date2);
        System.out.println(date2.getClass());
    }
}
