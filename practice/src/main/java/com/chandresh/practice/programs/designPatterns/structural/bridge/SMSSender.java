package com.chandresh.practice.programs.designPatterns.structural.bridge;

public class SMSSender implements IMessageSender {

	@Override
	public void sendMessage(String message) {
		System.out.println("SMS sent with message:  "+ message);
	}

}
