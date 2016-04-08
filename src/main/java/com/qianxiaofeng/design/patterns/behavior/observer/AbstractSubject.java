package com.qianxiaofeng.design.patterns.behavior.observer;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSubject {

	protected List<Iobserver> observers = new LinkedList<Iobserver>();
	
	public abstract void notifyObservers();
	
	public void addOb(Iobserver ob){
		if(!observers.contains(ob)){
			observers.add(ob);
		}
	}
	
	public void removeOb(Iobserver ob){
		observers.remove(ob);
	}
}
