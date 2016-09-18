package com.yan.thread;

/**
 * sleep方法不会释放锁，也就是如果当前线程持有对某个对象的锁，
 * 即使调用sleep方法，其他线程也无法访问这个对象。
 * Created by Administrator on 2016/9/17.
 */
public class SleepTest2 {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) {
        SleepTest2 test = new SleepTest2();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i: " + i);
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态...");
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
                i++;
                System.out.println("i: " + i + "\n");
            }
        }
    }
}
