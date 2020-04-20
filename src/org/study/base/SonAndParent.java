package org.study.base;

import org.junit.Test;

/**
 * .
 *
 * @author lcc
 * @version 1.0
 * @date 2020/4/16     
 */
public class SonAndParent {

    @Test
    public void test(){
        new Parent();
    }

    @Test
    public void test1(){
        new Son("sdf");
    }

    @Test
    public void test2(){
        new Parent();
        System.out.println("=========================");
        new Son();
    }
}


class Parent {
    public String name;

    {
        System.err.println("父类---代码块");
    }

    static {
        System.err.println("父类---静态代码块");
    }

    public Parent() {
        System.err.println("父类---无参构造器");
    }

    public Parent(String name) {
        System.err.println("父类---有参构造器");
    }
}


class Son extends Parent{
    {
        System.out.println("子类---代码块");
    }

    static {
        System.out.println("子类---静态代码块");
    }

    public Son() {
        System.out.println("子类---无参构造器");
    }

    public Son(String name) {
        this.name = name;
        System.out.println("子类---有参构造器");
    }
}