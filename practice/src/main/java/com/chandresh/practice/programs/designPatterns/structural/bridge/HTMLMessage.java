package com.chandresh.practice.programs.designPatterns.structural.bridge;

public class HTMLMessage extends Message{

	public HTMLMessage(String message, IMessageSender messageSender) {
		super(message, messageSender);
	}

	@Override
	public void sendMessage() {
		this.messageSender.sendMessage(this.message);
	}

}
