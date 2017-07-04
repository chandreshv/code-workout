package com.chandresh.practice.programs.designPatterns.structural.decorator;

public abstract class PizzaDecorator extends Pizza{

	protected String description;
	protected Pizza pizza;
	
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}
	public String getDescription(){
		return this.description;
	}
}
