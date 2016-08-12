/**
 * 
 */
package com.yan;

import java.util.concurrent.BlockingQueue;

/**
 * @Description: Producer
 * @author Yanjingyang
 * @date 2016年8月12日 上午10:22:58
 * @version 1.0
 */
public class Producer extends Thread {
	private BlockingQueue<String> bq;

	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		String[] strArr = new String[] { "Java", "Struts", "Spring" };
		for (int i = 0; i < 999999999; i++) {
			System.out.println(getName() + "生产者准备生产集合元素！");
			try {
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "生产完成：" + bq);
		}
	}

}
