/**
 * 
 */
package com.yan;

/**
 * @Description: DrawThread
 * @author Yanjingyang
 * @date 2016年8月11日 下午5:11:49
 * @version 1.0
 */
public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		account.draw(drawAmount);
	}

	/**
	 * @Description: main
	 * @date 2016年8月11日 下午5:11:49
	 * @param args
	 */
	public static void main(String[] args) {
		Account acct = new Account("1234567", 1000);
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();
	}

}
