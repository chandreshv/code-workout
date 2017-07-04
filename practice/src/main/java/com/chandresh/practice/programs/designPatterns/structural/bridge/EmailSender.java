package com.chandresh.practice.programs.designPatterns.structural.bridge;

public class EmailSender implements IMessageSender{

	@Override
	public void sendMessage(String message) {
		System.out.println("Message has been emailed");
	}

}
