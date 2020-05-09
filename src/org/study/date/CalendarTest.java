package org.study.date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * .
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/23     
 */
public class CalendarTest {

    @Test
    public void test0(){
        /**
         * Calendar：是一个抽象基类，获取实例有两种方式
         * 1. 调用Calendar.getInstance()：内部也是创建GregorianCalendar对象
         * 2. 创建子类GregorianCalendar对象
         */
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getClass());
    }

    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        //toString()
        System.out.println(calendar);
        //getTime()：Calendar--->Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime(Date date)：Date--->Calendar
        Date date2 = new Date(24313401384L);
        calendar.setTime(date2);
        System.out.println(calendar);
    }

    @Test
    public void test2(){
        Calendar calendar = Calendar.getInstance();
        //get(int field)：获取想要的时间信息，field：Calendar静态属性
        int i = calendar.get(Calendar.DATE);
        System.out.println(i);
        //set(int field, int value)：以field方向改变时间信息
        calendar.set(Calendar.DATE, 11);
        Date date1 = calendar.getTime();
        System.out.println(date1);
    }

    @Test
    public void test3(){
        Calendar calendar = Calendar.getInstance();
        //add(int field, int amount)：以field方向加时间，如果要减时间，将amount参数写成负数
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }
}
