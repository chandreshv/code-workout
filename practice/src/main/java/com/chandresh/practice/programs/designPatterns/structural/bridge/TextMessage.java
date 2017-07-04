package com.chandresh.practice.programs.designPatterns.structural.bridge;

public class TextMessage extends Message{

	public TextMessage(String message, IMessageSender messageSender) {
		super(message,messageSender);
	}

	@Override
	public void sendMessage() {
		this.messageSender.sendMessage(message);
	}

}
