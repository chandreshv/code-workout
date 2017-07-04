package com.chandresh.practice.programs.designPatterns.structural.decorator;

public abstract class Pizza {

	protected String description;
	
	public String getDescription(){
		return this.description;
	}
	public abstract int cost();
	
}
