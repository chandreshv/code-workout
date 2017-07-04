package com.chandresh.practice.programs.designPatterns.structural.adapter;

public class OldInterfaceImplementation implements OldInterface {

	private String user;
	
	public OldInterfaceImplementation(String user) {
		this.user = user;
	}
	
	@Override
	public void print(String message) {
		System.out.println(message);

	}

	@Override
	public String getUser() {
		return this.user;
	}

}
