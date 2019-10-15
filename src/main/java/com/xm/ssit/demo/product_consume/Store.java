package com.xm.ssit.demo.product_consume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Store
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 15:38
 * Verion 1.0
 **/
public class Store {
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	private int maxSize;
	private LinkedList<String> storage;

	public Store(int maxSize) {
		this.maxSize = maxSize;
		this.lock = new ReentrantLock();
		this.notFull = lock.newCondition();
		this.notEmpty = lock.newCondition();
		storage = new LinkedList<String>();
	}

	public void product(){
		lock.lock();
		try {
			while (storage.size()==maxSize){
				System.out.println(Thread.currentThread().getName() + ": wait");
				notFull.await();//阻塞生产线程
			}
			storage.add("Java book");
			System.out.println(Thread.currentThread().getName() + ": put :" + storage.size());
			Thread.sleep(1000);
			notEmpty.signalAll();//唤醒消费线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void consume(){
		lock.lock();
		try {
			while (storage.size()==0){
				System.out.println(Thread.currentThread().getName() + ": wait");
				notEmpty.await();//阻塞消费线程
			}
			System.out.println(storage.poll());
			System.out.println(Thread.currentThread().getName() + ": left :" + storage.size());
			Thread.sleep(1000);
			notFull.signalAll();//唤醒生产线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
