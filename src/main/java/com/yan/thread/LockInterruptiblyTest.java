package com.yan.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock interruptibly test:
 * 当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，假若此时线程A获取到了锁，而线程B只能在等待，
 * 那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-18 14:03
 */
public class LockInterruptiblyTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyTest test = new LockInterruptiblyTest();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}

class MyThread extends Thread {
    private LockInterruptiblyTest test = null;

    public MyThread(LockInterruptiblyTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
