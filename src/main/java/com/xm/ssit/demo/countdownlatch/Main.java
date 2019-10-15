package com.xm.ssit.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/10 9:57
 * Verion 1.0
 **/
public class Main {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		System.out.println("main thread starting !!!");
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "running!!!");
				countDownLatch.countDown();
			}
		},"sub-thread-1").start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "running!!!");
				countDownLatch.countDown();
			}
		},"sub-thread-2").start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "running!!!");
				countDownLatch.countDown();
			}
		},"sub-thread-3").start();

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread end !!!");
	}
}
