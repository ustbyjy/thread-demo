/**
 * 
 */
package com.yan;

/**
 * @Description: join线程
 * @author Yanjingyang
 * @date 2016年8月11日 下午2:39:24
 * @version 1.0
 */
public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	/**
	 * @Description: main
	 * @date 2016年8月11日 下午2:39:24
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new JoinThread("新线程").start();
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				jt.join();
			}

			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
