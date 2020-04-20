package org.study.string;

import org.junit.Test;

/**
 * String拼接.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/20     
 */
public class StringConcat {

    @Test
    public void test(){
        String a = "abv上空";
        String a1 = "abv";
        String a2 = "上空";
        String b = new String("abv上空");
        String c = "abv" + "上空";
        String d = a1 + a2;
        String e = a1 + "上空";
        String f = "abv" + a2;
        String intern = f.intern();
        //a在常量池中，b是new出来的，在堆中，所以==判断为false
        System.out.println(a == b);
        //字面量+字面量，结果在常量池中
        System.out.println(a == c);
        //变量参与+运算时，结果在堆中
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(a == f);
        //堆中String可以通过调用intern(),将堆中字符串复制到常量池中
        System.out.println(a == intern);
    }
}
