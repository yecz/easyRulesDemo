package com.xm.ssit.demo.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MakeDump
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/18 17:17
 * Verion 1.0
 **/
public class MakeDump {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(5);
		int count =0;
		while (true){
			String val = new String("123456");
			list.add(val);
			if(count%100000==0){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
		}
	}
}
