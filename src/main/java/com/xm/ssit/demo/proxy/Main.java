package com.xm.ssit.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 10:53
 * Verion 1.0
 **/
public class Main {

	public static void main(String args[]){
		Service service = new ServiceImpl();
		InvocationHandler invocationHandler = new MyInvocationHandler(service);
		Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),invocationHandler);
		System.out.println(serviceProxy.sellCar("Aston Martin"));
	}
}
