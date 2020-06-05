package org.study.base;

import org.junit.Test;

/**
 * .
 *
 * @author lcc
 * @version 1.0
 * @date 2020/5/13     
 */
public class MyTest {

    private static int d;

    private char s;

    @Test
    public void test01(){
        B b = new B();
        b.say();
        System.out.println(s);
        System.out.println(d);
        b.hah("1", "2");
        b.hah();
    }

}

class A{


    public final void say(){
        final String a;
        System.out.println("dkflsjf");
    }

    public void hah(String ... s){
        System.out.println(s.length);
    }
}

class B extends A{
}