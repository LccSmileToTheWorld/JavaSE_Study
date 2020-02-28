package org.study.thread.sync;

/**
 * 线程同步
 * 继承Thread类，同步方法.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28     
 */
public class ThreadSyncMethod {
    public static void main(String[] args) {
        MethodThreadWindow window = new MethodThreadWindow();
        MethodThreadWindow window1 = new MethodThreadWindow();
        MethodThreadWindow window2 = new MethodThreadWindow();
        window.setName("一号窗口");
        window1.setName("二号窗口");
        window2.setName("三号窗口");
        window.start();
        window1.start();
        window2.start();
    }
}

class MethodThreadWindow extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            sell();
        }
    }

    /**
     * 同步方法也有同步监视器(锁)，是隐式的
     * 非静态同步方法---this
     * 静态同步方法---当前类(类.class)
     * 继承Thread类，需要创建多个对象，this不唯一，所以同步方法只能为静态的
     */
    public synchronized static void sell(){
        if (ticket>0){
            System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ ticket);
            ticket--;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
