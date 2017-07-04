package com.chandresh.practice.programs.designPatterns.structural.decorator;

public class Client {

	public static void main(String[] args) {
		Pizza pizza = new MexicanPizza();
		pizza = new CheeseBurst(pizza);
		pizza = new ExtraVegetables(pizza);
		
		System.out.println(pizza.cost());
	}

}
