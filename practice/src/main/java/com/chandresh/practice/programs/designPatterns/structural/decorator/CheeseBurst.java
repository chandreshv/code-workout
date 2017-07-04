package com.chandresh.practice.programs.designPatterns.structural.decorator;

public class CheeseBurst extends PizzaDecorator{

	public CheeseBurst(Pizza pizza) {
		super(pizza);
		this.description = "Cheese Burst";
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 2 + this.pizza.cost();
	}

}
