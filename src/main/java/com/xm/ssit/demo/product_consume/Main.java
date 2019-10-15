package com.xm.ssit.demo.product_consume;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 15:54
 * Verion 1.0
 **/
public class Main {

	public static  void main(String args[]){
		Store store = new Store(3);
		ProductThread productThread = new ProductThread(store);
		ConsumeThread consumeThread = new ConsumeThread(store);
		for (int i =0 ;i<2;i++){
			new Thread(productThread,"product-" + i).start();
		}
		for (int i =0 ;i<2;i++){
			new Thread(consumeThread,"consume-" + i).start();
		}
	}
}
