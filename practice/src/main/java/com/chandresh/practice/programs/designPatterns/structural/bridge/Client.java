package com.chandresh.practice.programs.designPatterns.structural.bridge;

public class Client {

	public static void main(String args[]){
		Message message = new TextMessage("Hello", new SMSSender());
		message.sendMessage();
	}
	
}
