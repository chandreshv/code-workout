package com.chandresh.practice.programs.designPatterns.structural.adapter;

public class NewInterfaceImplementation implements NewInterface {


	private String user;
	
	public NewInterfaceImplementation(String user) {
		this.user = user;
	}
	
	@Override
	public void printMessage(String message) {
		System.out.println("New ## "+message);
	}

	@Override
	public String getCurrentUser() {
		return this.user;
	}

}
