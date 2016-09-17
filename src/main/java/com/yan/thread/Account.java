/**
 * 
 */
package com.yan.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Account
 * @author Yanjingyang
 * @date 2016年8月11日 下午4:11:49
 * @version 1.0
 */
public class Account {
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;

	public Account() {

	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}

				balance -= drawAmount;

				System.out.println("\n余额为：" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == Account.class) {
			Account account = (Account) obj;
			return account.getAccountNo().equals(this.accountNo);
		}
		return false;
	}
}
