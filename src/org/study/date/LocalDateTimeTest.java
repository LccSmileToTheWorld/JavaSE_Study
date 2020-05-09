package org.study.date;

import org.junit.Test;

import java.time.*;

/**
 * .
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/9     
 */
public class LocalDateTimeTest {

    @Test
    public void test0(){
        //static now(): 以默认时区获取当前时间对象
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();
        //static now(ZoneId zone): 指定时区，获取当前时间对象
        LocalDateTime now3 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now1);
        System.out.println(now2);
        System.out.println(now);
        System.out.println(now3);
        //static of(): 指定时间，创建时间对象
        LocalDateTime of = LocalDateTime.of(2020, 5, 1, 10, 9, 9);
        System.out.println(of);
    }


    /**
     *<p> 获取时间的属性.
     *    方法定义的都特别简单，getXxx().
     *    只有获取天和月的时候特别。
     *
     * @param
     */
    @Test
    public void test1(){
        LocalDateTime now = LocalDateTime.now();
        //int getDayOfYear(): 获取指定日期是一年中的第几天
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
        //int getDayOfMonth(): 获取指定日期是月份中的几号
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);
        //DayOfWeek getDayOfWeek()：获取指定日期是星期几, 返回的是DayOfWeek枚举，可以通过DayOfWeek的getValue()获取1-7
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);
        int value = dayOfWeek.getValue();
        System.out.println(value);
        //int year(): 获取年份
        int year = now.getYear();
        System.out.println(year);
        //Month getMonth(): 获取月份，返回的是Month枚举，可以通过Month的getValue()获取1-12，也可以通过时间对象直接调用getMonthValue()
        Month month = now.getMonth();
        System.out.println(month);
        int value1 = month.getValue();
        System.out.println(value1);
        int monthValue = now.getMonthValue();
        System.out.println(monthValue);
    }


    /**
     *<p> 修改时间 withXxx().
     *      修改天时，分为修改月份中的天（1-31）和修改年份中的天（1-366）
     * @param
     */
    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.withDayOfMonth(8);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = now.withDayOfYear(100);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = now.withYear(2021);
        System.out.println(localDateTime2);
    }


    /**
     *<p> 加时间 plusXxx().
     *
     * @param
     */
    @Test
    public void test3(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusDays(1);
        System.out.println(localDateTime);
    }

    /**
     *<p> 减时间 minusXxx().
     *
     * @param
     */
    @Test
    public void test4(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusDays(1);
        System.out.println(localDateTime);
    }
}
