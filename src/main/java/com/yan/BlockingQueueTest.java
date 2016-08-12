/**
 * 
 */
package com.yan;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description: BlockingQueueTest
 * @author Yanjingyang
 * @date 2016年8月12日 上午10:09:03
 * @version 1.0
 */
public class BlockingQueueTest {

	/**
	 * @Description: main
	 * @date 2016年8月12日 上午10:09:03
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
		bq.put("Java");
		bq.put("Java");
		// 添加第3个
		// offer方法会返回false
		System.out.println(bq.offer("Java"));
		// add方法会抛出异常
		bq.add("Java");
		// put方法会阻塞线程
		bq.put("Java");
	}

}
