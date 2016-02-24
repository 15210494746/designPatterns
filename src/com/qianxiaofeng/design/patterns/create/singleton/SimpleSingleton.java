package com.qianxiaofeng.design.patterns.create.singleton;

import java.io.Serializable;

public class SimpleSingleton implements Serializable{

	private static final long serialVersionUID = 3909805456879444387L;
	
	private static SimpleSingleton singleton = new SimpleSingleton();
	
	private SimpleSingleton(){}
	
	public static SimpleSingleton getInstance(){
		return singleton;
	}
	
	/**
	 * 防止序列化、反序列化后 产生新的对象
	 * @return
	 */
	public Object readResolve() {
		return getInstance();
	}
	
}
