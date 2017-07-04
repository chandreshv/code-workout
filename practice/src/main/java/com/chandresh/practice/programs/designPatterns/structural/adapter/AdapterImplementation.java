package com.chandresh.practice.programs.designPatterns.structural.adapter;

public class AdapterImplementation implements OldInterface {

	private NewInterface newInterface;
	
	public AdapterImplementation(NewInterface newInterface) {
		this.newInterface = newInterface;
	}
	
	
	@Override
	public void print(String message) {
		this.newInterface.printMessage(message);
		
	}

	@Override
	public String getUser() {
		return this.newInterface.getCurrentUser();
	}


}
