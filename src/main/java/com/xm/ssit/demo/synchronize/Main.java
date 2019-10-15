package com.xm.ssit.demo.synchronize;



/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 10:53
 * Verion 1.0
 **/
public class Main {

	public static void main(String args[]){
		Account account = new Account();
		Thread add = new AddThread("Tom",account);
		Thread minus = new MinusThread("Peter",account);
		add.start();
		minus.start();
	}
}
