package com.xm.ssit.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Account
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 11:12
 * Verion 1.0
 **/
public class AccountWithLock {
	int balance;
	Lock lock;
	public AccountWithLock(){
		balance = 0;
		lock = new ReentrantLock();
	}

	public void lockAccount(){
		lock.lock();
	}
	public void unLockAccount(){
		lock.unlock();
	}

	public   void login(String name){
		System.out.println(name + " is login");
	}
	public   void logout(String name){
		System.out.println(name + " is logout");
	}
	public synchronized  void add(){
		balance += 800;
		System.out.println("After add balance is :" + balance);
	}

	public synchronized  void minus(){
		balance -= 800;
		System.out.println("After minus balance is :" + balance);
	}

}
