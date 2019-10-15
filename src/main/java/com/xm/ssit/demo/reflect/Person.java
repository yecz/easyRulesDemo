package com.xm.ssit.demo.reflect;

/**
 * @ClassName Person
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/8 9:33
 * Verion 1.0
 **/
public class Person {

	private String name;


	public Person(String name){
		this.name = name;
	}

	public void pringName(){
		System.out.println("my name is " + name);
	}
}
