/**
 * 
 */
package com.yan;

class MyAccount {
	private ThreadLocal<String> name = new ThreadLocal<String>();

	public MyAccount(String str) {
		this.name.set(str);
		System.out.println("---" + this.name.get());
	}

	public String getName() {
		return name.get();
	}

	public void setName(String str) {
		this.name.set(str);
	}

}

class MyTest extends Thread {
	private MyAccount account;

	public MyTest(MyAccount account, String name) {
		super(name);
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(getName());
			}
			System.out.println(account.getName() + " 账户的i值：" + i);
		}
	}
}

/**
 * @Description: ThreadLocalTest
 * @author Yanjingyang
 * @date 2016年8月12日 下午4:14:09
 * @version 1.0
 */
public class ThreadLocalTest {

	/**
	 * @Description: main
	 * @date 2016年8月12日 下午4:14:09
	 * @param args
	 */
	public static void main(String[] args) {
		MyAccount account = new MyAccount("初始名");
		new MyTest(account, "线程甲").start();
		new MyTest(account, "线程乙").start();
	}

}
