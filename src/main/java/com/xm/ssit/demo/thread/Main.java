package com.xm.ssit.demo.thread;

import java.util.concurrent.Callable;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/9 9:48
 * Verion 1.0
 **/
public class Main {

	public static void main(String args[]){
		System.out.println("main thread start");
		try {
			Thread thread = new Thread(new MyThread(),"sub-thread-1");
			Thread thread2 = new Thread(new MyThread(),"sub-thread-2");
			thread2.start();
			thread.start();
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread  end");
	}

	static class MyThread implements Runnable{


		public void run() {
			System.out.println(Thread.currentThread().getName() + "start!");
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "running!!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "end!");
		}
	}
}
