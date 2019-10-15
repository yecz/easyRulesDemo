package com.xm.ssit.demo.product_consume;

/**
 * @ClassName ConsumeThread
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 15:52
 * Verion 1.0
 **/
public class ConsumeThread implements Runnable{
	private Store store;

	public ConsumeThread(Store store) {
		this.store = store;
	}

	public void run() {
		while (true){
			store.consume();
		}
	}
}
