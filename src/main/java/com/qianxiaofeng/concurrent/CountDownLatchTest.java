package com.qianxiaofeng.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class CountDownLatchTest {
	
	private CountDownLatch latch;
	
	private List<Work> workList =  new ArrayList<Work>();
	
	private int workSize = 10;
	
	private Executor workers;
	
	
	public CountDownLatchTest(int workSize, int workerSize){
		this.latch = new CountDownLatch(workSize);
		this.workers = Executors.newFixedThreadPool(workerSize);
	}
	
	class Work implements Runnable {
		
		private CountDownLatch workLatch;
		
		private int cost;
		
		public Work(CountDownLatch latch, int cost){
			this.workLatch = latch;
			this.cost = cost;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(cost * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			workLatch.countDown();
			System.out.println(Thread.currentThread().getName() + "finish work!");
		}
	}
	
	public void initWorks(){
		for(int i = 0; i < workSize ; i++){
			workList.add(this.new Work(latch, i));
		}
	}
	
	public void finishWorks(){
		for(Work work : workList){
			workers.execute(work);
		}
	}
	
	class WorkObserver{
		
		private CountDownLatch workObLatch;
		
		public WorkObserver(CountDownLatch latch){
			this.workObLatch = latch;
		}
		
		private void ob(){
			try {
				workObLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("all work has been finished~");
		}
		
	}
	
	public static void main(String[] args) {
		CountDownLatchTest test = new CountDownLatchTest(10,5);
		test.initWorks();
		test.finishWorks();
		test.new WorkObserver(test.latch).ob();;
	}
}
