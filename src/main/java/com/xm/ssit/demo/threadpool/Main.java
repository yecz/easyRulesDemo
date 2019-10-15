package com.xm.ssit.demo.threadpool;

import java.util.concurrent.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/9 9:48
 * Verion 1.0
 **/
public class Main {

	public static void main(String args[]){
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
		try {
			Future<String> future = threadPoolExecutor.submit(new MyTask("1"));
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	static class MyTask implements Callable<String>{
		private String taskId;

		public MyTask(String taskId) {
			this.taskId = taskId;
		}

		public String call() throws Exception {
			return taskId + " call !!!";
		}
	}
}
