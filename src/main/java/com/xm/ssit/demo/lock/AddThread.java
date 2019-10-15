package com.xm.ssit.demo.lock;

/**
 * @ClassName AddThread
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 11:16
 * Verion 1.0
 **/
public class AddThread extends  Thread {
	String person;
	AccountWithLock account;

	public AddThread(String person, AccountWithLock account){
		this.person = person;
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0;i<3;i++){
			account.lockAccount();
			System.out.println(person + " add money," + i + "cnt");
			account.login(person);
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.add();
			account.logout(person);
			account.unLockAccount();
		}
	}
}
