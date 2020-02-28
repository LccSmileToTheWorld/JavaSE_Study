package org.study.thread.create;

/**
 * 实现Runnable接口创建线程.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/27     
 */
public class ImplementsRunnable {
    public static void main(String[] args) {
        //3、创建实现类对象
        RunnableImplClass implClass = new RunnableImplClass();
        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread类对象
        Thread thread = new Thread(implClass);
        Thread thread1 = new Thread(implClass);
        //5、通过Thread类的对象调用start()
        thread.start();
        thread1.start();
    }
}

//1、创建Runnable接口的实现类
class RunnableImplClass implements Runnable{

    //2、实现run()，将线程要执行的操作声明在run()中
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}