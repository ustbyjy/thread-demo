/**
 * 
 */
package com.yan.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: ForkJoinPoolTest
 * @author Yanjingyang
 * @date 2016年8月12日 下午3:38:46
 * @version 1.0
 */
public class ForkJoinPoolTest {

	/**
	 * @Description: setUp
	 * @date 2016年8月12日 下午3:38:46
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @Description: tearDown
	 * @date 2016年8月12日 下午3:38:46
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new PrintTask(0, 300));
		pool.awaitQuiescence(2, TimeUnit.SECONDS);
		pool.shutdown();
	}

}
