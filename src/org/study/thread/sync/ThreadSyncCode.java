package org.study.thread.sync;

/**
 * 线程同步
 * 继承Thread类，同步代码块.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/27     
 */
public class ThreadSyncCode {
    public static void main(String[] args) {
        ThreadWindow window = new ThreadWindow();
        ThreadWindow window1 = new ThreadWindow();
        ThreadWindow window2 = new ThreadWindow();
        window.setName("一号窗口");
        window1.setName("二号窗口");
        window2.setName("三号窗口");
        window.start();
        window1.start();
        window2.start();
    }
}

/**
 * 格式：
 * synchronized(同步监视器){
 *      需要被同步的代码
 * }
 * 同步监视器：俗称--锁。任何一个类的对象，都可以充当锁。
 * 要求：多个线程必须要共用同一把锁。
 * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 */

class ThreadWindow extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            /**
             * 同步监视器(锁)可以是任一类的对象，但多个线程的锁要保持一致
             * 继承Thread类方式，需要创建三次次对象，所以不能用this作为锁
             * 类.class(Class对象)只会加载一次，所以可以当作锁
             * 这里要用obj的话，obj必须用static修饰
             */
            synchronized (ThreadWindow.class) {
                if (ticket > 0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
