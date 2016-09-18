package com.yan.thread;

/**
 * stop thread: 直接调用interrupt方法不能中断正在运行中的线程（可以终端阻塞状态的线程）。
 * 但是如果配合isInterrupted()能够中断正在运行的线程，
 * 因为调用interrupt方法相当于将中断标志位置为true，
 * 那么可以通过调用isInterrupted()判断中断标志是否被置位来中断线程的执行。
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-12 17:34
 */
public class StopTheadTest3 {

    public static void main(String[] args) throws Exception {
        StopTheadTest3 test = new StopTheadTest3();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted() && i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        }
    }
}
