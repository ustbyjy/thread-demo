package com.yan.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock test: 将lock声明为类的属性
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-18 13:42
 */
public class LockTest {
    private List<Integer> list = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final LockTest test = new LockTest();

        new Thread() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                list.add(i);
                System.out.println(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

}
