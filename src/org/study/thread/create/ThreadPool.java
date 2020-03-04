package org.study.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池.
 *
 * @author lcc
 * @version 1.0
 * @date 2020/3/4     
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1、创建线程池
        /**
         * Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
         * Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
         * Executors.newFixedThreadPool(n): 创建一个可重用固定线程数的线程池
         * Executors.newSingleThreadExecutor(): 创建一个只有一个线程的线程池
         * Executors.newScheduledThreadPool(n)): 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
         */
        ExecutorService service = Executors.newFixedThreadPool(10);

        /**
         * 设置连接池属性
         * corePoolSize ：核心池的大小
         * maximumPoolSize ：最大线程数
         * keepAliveTime ：线程没有任务时最多保持多长时间后会终止
         */
        System.out.println(service.getClass());
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) service;
        poolExecutor.setMaximumPoolSize(10);

        //2、执行指定线程的操作
        service.execute(new MyThread());
        //execute适用于Runnable，submit适用于Callable
        //service.submit(Callable callable);

        //3、不用时，关闭线程池
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
