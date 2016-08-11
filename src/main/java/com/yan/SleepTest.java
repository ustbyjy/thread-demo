/**
 * 
 */
package com.yan;

import java.util.Date;

/**
 * @Description: Sleep测试类
 * @author Yanjingyang
 * @date 2016年8月11日 下午3:17:07
 * @version 1.0
 */
public class SleepTest extends Thread {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前时间: " + new Date());

			Thread.sleep(1000);
		}
	}
}
