/**
 * 
 */
package com.yan.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.RecursiveAction;

/**
 * @Description: TODO
 * @author Yanjingyang
 * @date 2016年8月12日 下午3:30:46
 * @version 1.0
 */
public class PrintTask extends RecursiveAction {
	private static final long serialVersionUID = -5242821214115689271L;

	private final static int THRESHOLD = 50;
	private static FileWriter fw;
	private int start;
	private int end;

	static {
		try {
			fw = new FileWriter("hello.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if ((end - start) < THRESHOLD) {
			for (int i = start; i < end; i++) {
				try {
					fw.write(Thread.currentThread().getName() + "的i值：" + i + "\n");
					fw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			int middle = (end - start) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			left.fork();
			right.fork();
		}
	}
}
