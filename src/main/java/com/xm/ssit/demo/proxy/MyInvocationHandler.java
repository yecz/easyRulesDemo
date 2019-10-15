package com.xm.ssit.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 10:50
 * Verion 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

	public Object target;

	public MyInvocationHandler(Object target){
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Call:" + method.getName());
		Object object = method.invoke(target,args);
		return object;
	}
}
