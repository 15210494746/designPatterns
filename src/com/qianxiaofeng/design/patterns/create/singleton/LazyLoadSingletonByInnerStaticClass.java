package com.qianxiaofeng.design.patterns.create.singleton;

public class LazyLoadSingletonByInnerStaticClass {

	private LazyLoadSingletonByInnerStaticClass(){}
	
	private static class LazyHolder{
		private static final LazyLoadSingletonByInnerStaticClass singleton = new LazyLoadSingletonByInnerStaticClass();
	}
	
	public static LazyLoadSingletonByInnerStaticClass getInstance(){
		return LazyHolder.singleton;
	}
	
	public Object readResolve() {
		return getInstance();
	}
}
