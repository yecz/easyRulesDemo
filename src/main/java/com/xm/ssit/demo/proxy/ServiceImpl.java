package com.xm.ssit.demo.proxy;

/**
 * @ClassName ServiceImpl
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 10:49
 * Verion 1.0
 **/
public class ServiceImpl implements Service {
	public String sellCar(String carName) {
		return  carName + " is ready!";
	}
}
