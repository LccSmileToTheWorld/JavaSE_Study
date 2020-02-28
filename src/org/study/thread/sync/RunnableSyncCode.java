package org.study.thread.sync;

/**
 * 线程同步
 * 实现Runnable接口，同步代码块.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/27     
 */
public class RunnableSyncCode {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread = new Thread(window);
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        thread.setName("一号窗口");
        thread1.setName("二号窗口");
        thread2.setName("三号窗口");
        thread.start();
        thread1.start();
        thread2.start();
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
class Window implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        Object obj1 = new Object();
        while (true){
            /**
             * 同步监视器(锁)可以是任一类的对象，但多个线程的锁要保持一致
             * 这里可以使用obj，但不能使用obj1
             * this--类的对象，实现Runnable接口方式，只需要创建一次对象，所以三个线程的锁是同一个
             */
            synchronized (this) {
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