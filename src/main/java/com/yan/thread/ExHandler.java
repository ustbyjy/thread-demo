/**
 * 
 */
package com.yan.thread;

class MyExHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + " 线程出现了异常：" + e);
	}

}

/**
 * @Description: ExHandler
 * @author Yanjingyang
 * @date 2016年8月12日 上午11:07:29
 * @version 1.0
 */
public class ExHandler {

	/**
	 * @Description: main
	 * @date 2016年8月12日 上午11:07:29
	 * @param args
	 */
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
		System.out.println("线程正常结束！");
	}

}
