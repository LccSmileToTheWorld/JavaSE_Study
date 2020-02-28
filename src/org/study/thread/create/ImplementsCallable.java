package org.study.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口创建线程.
 *
 *
 * 与使用 Runnable 相比， Callable 功能更强大些
 *  1）相比 run() 方法，可以有返回值
 *  2）方法 可以抛出异常
 *  3）支持泛型的返回值，借助FutureTask类对象，获取返回结果
 *
 * @author lcc
 * @version 1.0
 * @date 2020/2/28     
 */
public class ImplementsCallable {

    public static void main(String[] args) {
        //3、创建Callable接口实现类对象
        CallableImpl callable = new CallableImpl();
        //4、将实现类对象作为参数传递到FutureTask类的构造器中，创建FutureTask类对象
        FutureTask<Integer> futureTask = new FutureTask(callable);
        //5、将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread类对象
        Thread thread = new Thread(futureTask);
        //6、Thread对象调用start()
        thread.start();


        try {
            //如果想获取call()返回值，用FutureTask对象调用get()
            Integer a = futureTask.get();
            System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


//1、生命Callable接口实现类
class CallableImpl implements Callable<Integer> {

    //2、重写call()，将此线程执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 0;
    }
}
