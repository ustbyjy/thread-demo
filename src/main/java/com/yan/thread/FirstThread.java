/**
 * 
 */
package com.yan.thread;

/**
 * @Description: FirstThread
 * @author Yanjingyang
 * @date 2016年8月11日 上午10:35:23
 * @version 1.0
 */
public class FirstThread extends Thread {
	private int i;

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	/**
	 * @Description: main
	 * @date 2016年8月11日 上午10:35:23
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}

	}

}
