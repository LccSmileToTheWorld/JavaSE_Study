package org.study.thread.sync;

/**
 * 线程同步
 * 实现Runnable接口，同步方法.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/27     
 */
public class RunnableSyncMethod {

    public static void main(String[] args) {
        RunnableWindow runnableWindow = new RunnableWindow();
        Thread thread = new Thread(runnableWindow);
        Thread thread1 = new Thread(runnableWindow);
        Thread thread2 = new Thread(runnableWindow);
        thread.setName("一号窗口");
        thread1.setName("二号窗口");
        thread2.setName("三号窗口");
        thread.start();
        thread1.start();
        thread2.start();

    }
}

class RunnableWindow implements Runnable{

    private int ticket = 100;

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
     */
    public synchronized void sell(){
        if (ticket > 0){
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
