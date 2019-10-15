package com.xm.ssit.demo.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/9 11:02
 * Verion 1.0
 **/
public class Main {

	public static void main(String[] args) {
//		User user = new User();
//		SoftReference<User> softReference = new SoftReference<User>(user);
//		WeakReference<User> weakReference = new WeakReference<User>(user);
		String a = new String("a");
		String b = new String("b");
		Map<String,String> map  = new HashMap<String, String>(2);
		Map<String,String> weakHashMap  = new WeakHashMap<String, String>(2);
		map.put(a,"aaa");
		map.put(b,"bbb");
		weakHashMap.put(a,"aaa");
		weakHashMap.put(b,"bbb");
		map.remove(a);
		a = null;
		System.gc();

		Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry en = iterator.next();
			System.out.println("map:" + en.getKey() + "=" + en.getValue());
		}
		Iterator<Map.Entry<String,String>> iterator2 = weakHashMap.entrySet().iterator();
		while (iterator2.hasNext()){
			Map.Entry en = iterator2.next();
			System.out.println("weakHashMap:" + en.getKey() + "=" + en.getValue());
		}

	}
}
