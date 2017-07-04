package com.chandresh.practice.programs.designPatterns.structural.decorator;

public class ExtraVegetables extends PizzaDecorator{
	
	public ExtraVegetables(Pizza pizza) {
		super(pizza);
	}

	@Override
	public int cost() {
		return 3 + this.pizza.cost();
	}
	
	

}
