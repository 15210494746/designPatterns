package com.qianxiaofeng.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCompletionServiceTest {

	private static ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	private static ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(executors);
	
	public class Task implements Callable<String>{
		private int i;  
        public Task(int i){  
            this.i = i;  
        }  
		@Override
		public String call() throws Exception {
			 Thread.sleep(1000);  
	            return Thread.currentThread().getName() + "执行完任务：" + i;  
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		for(int i = 0 ; i < 10 ; i++){
			completionService.submit(new ExecutorCompletionServiceTest().new Task(i));
		}
		
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(completionService.take().get());
		}
	}
	
	
}
