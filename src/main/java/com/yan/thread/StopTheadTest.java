package com.yan.thread;

/**
 * stop thread
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-12 17:34
 */
public class StopTheadTest extends Thread {
    public volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit) {
            System.out.println("thread is running!");
        }
    }

    public static void main(String[] args) throws Exception {
        StopTheadTest thread = new StopTheadTest();
        thread.start();
        sleep(5000);
        thread.exit = true;
        System.out.println("线程退出！");
    }
}
