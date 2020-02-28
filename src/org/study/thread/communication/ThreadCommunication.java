package org.study.thread.communication;

/**
 * 线程通信.
 * 经典案例：生产者/消费者
 *
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *    否则，会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：sleep()是Thread类中声明的静态方法 , wait()是Object类中声明的非静态方法
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          3) sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
 *          4）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *          5) sleep的作用是让线程休眠制定的时间，在时间到达时恢复，
 *             wait会将调用者的线程挂起，直到同一同步监视器调用notify()/notifyAll()才会被唤起。
 * @author lcc
 * @version 1.0
 * @date 2020/2/28     
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Producer producer = new Producer(counter);
        Thread producerThread = new Thread(producer);
        producerThread.setName("生产者");
        producerThread.start();
        Consumer consumer = new Consumer(counter);
        Thread consumerThread = new Thread(consumer);
        consumerThread.setName("消费者");
        consumerThread.start();
    }
}

/**
 * 柜台.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28
 */
class Counter {
    private int count = 0;

    /**
     *<p> 生产产品.
     *
     * @param
     */
    public synchronized void produce() {
        if (count >= 20) {
            System.out.println("柜台已满");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            count++;
            System.out.println(Thread.currentThread().getName() + "+++++生产，柜台存有" + count + "个商品，");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }

    /**
     *<p> 消费产品.
     *
     * @param
     */
    public synchronized void consume() {
        if (count <= 0) {
            System.out.println("柜台已空");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            count--;
            System.out.println(Thread.currentThread().getName() + "-----消费，柜台存有" + count + "个商品，");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }
}

/**
 * 生产者.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28
 */
class Producer implements Runnable {

    private Counter counter;

    public Producer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while (true){
            counter.produce();
        }
    }
}

/**
 * 消费者.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28
 */
class Consumer implements Runnable {

    private Counter counter;

    public Consumer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while (true) {
            counter.consume();
        }
    }
}
