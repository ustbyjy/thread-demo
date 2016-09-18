package com.yan.thread;

/**
 * stop thread: 设置标记来中断异常，安全，较为常用
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-12 17:34
 */
public class StopTheadTest extends Thread {
    private volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit) {
            System.out.println("thread is running!");
        }
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public static void main(String[] args) throws Exception {
        StopTheadTest thread = new StopTheadTest();
        thread.start();
        sleep(5000);
        thread.setExit(true);
        System.out.println("线程退出！");
    }

}
