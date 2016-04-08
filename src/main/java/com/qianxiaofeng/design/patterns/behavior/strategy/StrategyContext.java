package com.qianxiaofeng.design.patterns.behavior.strategy;

public class StrategyContext{
	
	private IStrategy strategy;

	public StrategyContext(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void doSomeThing() {
		System.out.println("do some thing by " + strategy.getPolicy());
	}
	
	public static void main(String[] args) {
		StrategyContext context = new StrategyContext(new StrategyB());
		context.doSomeThing();
	}

}
