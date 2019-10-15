package com.xm.ssit.demo.lock;


/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 10:53
 * Verion 1.0
 **/
public class Main {

	public static void main(String args[]){
		AccountWithLock account = new AccountWithLock();
		Thread add = new AddThread("Tom",account);
		Thread minus = new MinusThread("Peter",account);
		add.start();
		minus.start();
	}
}
