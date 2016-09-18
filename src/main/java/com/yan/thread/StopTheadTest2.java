package com.yan.thread;

/**
 * stop thread: 单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常
 *
 * @author jingyangyan
 * @version 1.0
 * @create 2016-09-12 17:34
 */
public class StopTheadTest2 {

    public static void main(String[] args) throws Exception {
        StopTheadTest2 test = new StopTheadTest2();
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
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }
}
