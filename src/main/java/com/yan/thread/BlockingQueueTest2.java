/**
 * 
 */
package com.yan.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description: BlockingQueueTest2
 * @author Yanjingyang
 * @date 2016年8月12日 上午10:36:17
 * @version 1.0
 */
public class BlockingQueueTest2 {

	/**
	 * @Description: main
	 * @date 2016年8月12日 上午10:36:17
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);

		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();

		new Consumer(bq).start();
	}

}
