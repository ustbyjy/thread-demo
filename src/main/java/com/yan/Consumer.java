/**
 * 
 */
package com.yan;

import java.util.concurrent.BlockingQueue;

/**
 * @Description: Consumer
 * @author Yanjingyang
 * @date 2016年8月12日 上午10:22:58
 * @version 1.0
 */
public class Consumer extends Thread {
	private BlockingQueue<String> bq;

	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + "消费者准备消费集合元素！");
			try {
				Thread.sleep(200);
				bq.take();
				System.out.println(getName() + "消费完成：" + bq);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
