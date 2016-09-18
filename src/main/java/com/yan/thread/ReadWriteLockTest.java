package com.yan.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * read write lock test
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-18 14:43
 */
public class ReadWriteLockTest {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadWriteLockTest test = new ReadWriteLockTest();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
