package org.study.thread.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock线程同步.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28     
 */
public class LockTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        thread.setName("一号窗口");
        thread1.setName("二号窗口");
        thread2.setName("三号窗口");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class MyThread implements Runnable {

    //1、实例化Lock实现类
    private ReentrantLock lock = new ReentrantLock(true);

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                //2、调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3、释放锁
                lock.unlock();
            }
        }
    }
}
