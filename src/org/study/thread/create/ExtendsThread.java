package org.study.thread.create;

/**
 * 继承Thread类创建线程.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/27     
 */
public class ExtendsThread {

    public static void main(String[] args) {
        //3、创建Thread类子类对象
        ThreadChildrenClass childrenClass = new ThreadChildrenClass();
        ThreadChildrenClass childrenClass1 = new ThreadChildrenClass();
        //4、通过此对象调用start()
        childrenClass.start();
        childrenClass1.start();
    }
}

// 1、创建Thread类的子类
class ThreadChildrenClass extends Thread{
    // 2、重写run()，将此线程执行的操作声明在run()中
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
