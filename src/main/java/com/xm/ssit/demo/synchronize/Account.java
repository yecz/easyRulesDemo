package com.xm.ssit.demo.synchronize;

/**
 * @ClassName Account
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 11:12
 * Verion 1.0
 **/
public class Account {
	int balance;
	public Account(){
		balance = 0;
	}

	public synchronized  void login(String name){
		System.out.println(name + " is login");
	}
	public synchronized  void logout(String name){
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
