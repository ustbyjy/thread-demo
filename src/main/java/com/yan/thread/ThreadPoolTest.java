/**
 *
 */
package com.yan.thread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yanjingyang
 * @version 1.0
 * @Description: ThreadPoolTest
 * @date 2016年8月12日 下午2:29:17
 */
public class ThreadPoolTest {

    /**
     * @throws java.lang.Exception
     * @Description: setUp
     * @date 2016年8月12日 下午2:29:17
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     * @Description: tearDown
     * @date 2016年8月12日 下午2:29:17
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        SubThread st = new SubThread();
        pool.submit(st);
        pool.submit(st);
        pool.shutdown();
    }

}

class SubThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值为：" + i);
        }
    }

}
