package org.study.thread.sync;

/**
 * 死锁.
 * 1、死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 *  都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 * 2、说明：
 *  1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 *  2）我们使用同步时，要避免出现死锁。
 * @author lcc
 * @version 1.0
 * @date 2020/2/28     
 */
public class BeadLock {

    public static void main(String[] args) {

        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    a.append("1");
                    b.append("a");
                    System.out.println(a);
                    System.out.println(b);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        a.append("2");
                        b.append("b");
                        System.out.println(a);
                        System.out.println(b);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    a.append("3");
                    b.append("c");
                    System.out.println(a);
                    System.out.println(b);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        a.append("4");
                        b.append("d");
                        System.out.println(a);
                        System.out.println(b);
                    }
                }
            }
        }).start();
    }
}
