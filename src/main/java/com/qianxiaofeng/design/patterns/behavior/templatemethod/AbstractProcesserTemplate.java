package com.qianxiaofeng.design.patterns.behavior.templatemethod;

public abstract class AbstractProcesserTemplate implements IProcesser{

	@Override
	public void process(){
		checkParams();
		verifyPermission();
		otherSameProcess();
	}
	
	
	private void checkParams(){}
	
	private void verifyPermission(){}
	
	private void otherSameProcess(){}
	
	protected abstract void innerProcess();
	
}
