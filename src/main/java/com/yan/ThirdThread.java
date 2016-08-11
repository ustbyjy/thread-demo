/**
 * 
 */
package com.yan;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: ThirdThread
 * @author Yanjingyang
 * @date 2016年8月11日 上午11:42:07
 * @version 1.0
 */
public class ThirdThread {

	/**
	 * @Description: main
	 * @date 2016年8月11日 上午11:42:07
	 * @param args
	 */
	public static void main(String[] args) {
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int i = 0;
				for (; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
				}

				return i;
			}
		});

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的" + i);
			if (i == 20) {
				new Thread(task, "有返回值的线程").start();
			}
		}

		try {
			System.out.println("子线程的返回值: " + task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
