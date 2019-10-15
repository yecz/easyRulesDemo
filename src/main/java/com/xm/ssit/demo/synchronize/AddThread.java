package com.xm.ssit.demo.synchronize;

/**
 * @ClassName AddThread
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 11:16
 * Verion 1.0
 **/
public class AddThread extends  Thread {
	String person;
	Account account;

	public AddThread(String person,Account account){
		this.person = person;
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0;i<3;i++){
			System.out.println(person + " add money," + i + "cnt");
			account.login(person);
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.add();
			account.logout(person);
		}
	}
}
