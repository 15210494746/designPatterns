package com.qianxiaofeng.design.patterns.behavior.observer;

public class Subject extends AbstractSubject {

	public  Subject() {
		addOb(new ObserverA());
		addOb(new ObserverB());
	}
	
	@Override
	public void notifyObservers() {
		//super.observers.stream().forEach(ob -> ob.update());
	}

}
