package com.xm.ssit.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 9:35
 * Verion 1.0
 **/
public class Main {

	public static final void main(String args[]){

		try {
			Class clazz = Class.forName("com.xm.ssit.demo.reflect.Person");
			Constructor c =  clazz.getDeclaredConstructor(String.class);
			Person person = (Person) c.newInstance("roles");
			Method method = clazz.getMethod("pringName");
			method.invoke(person);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}


//		try {
//			Class clazz = Class.forName("com.xm.ssit.demo.reflect.Person");
//			Constructor c = clazz.getDeclaredConstructor(String.class);
//			Person person = (Person) c.newInstance("jack");
//			person.pringName();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
	}
}
