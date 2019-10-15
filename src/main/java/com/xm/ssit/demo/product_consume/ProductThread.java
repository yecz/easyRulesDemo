package com.xm.ssit.demo.product_consume;

/**
 * @ClassName ProductThread
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 15:52
 * Verion 1.0
 **/
public class ProductThread implements Runnable{

	private Store store;

	public ProductThread(Store store) {
		this.store = store;
	}

	public void run() {
		while(true){
			store.product();
		}
	}
}
