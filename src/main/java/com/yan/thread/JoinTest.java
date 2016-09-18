package com.yan.thread;

/**
 * join test: main方法等待thread线程执行完毕或者等待一定的时间
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-18 9:59
 */
public class JoinTest {

    public static void main(String[] args) {
        System.out.println("进入线程" + Thread.currentThread().getName());
        JoinTest test = new JoinTest();
        MyThread thread1 = test.new MyThread();
        thread1.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            thread1.join();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }
}
