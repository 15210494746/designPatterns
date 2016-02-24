package com.qianxiaofeng.design.patterns.create.singleton;

public class LazyLoadSingleton {

	private static LazyLoadSingleton lazySingleton = null;
	
	private LazyLoadSingleton(){}
	
	public static LazyLoadSingleton getInstance(){
		if(lazySingleton==null){
			synchronized (LazyLoadSingleton.class) {
				if(lazySingleton==null){
					lazySingleton = new LazyLoadSingleton();
				}
			}
		}
		return lazySingleton;
	}
	
}
