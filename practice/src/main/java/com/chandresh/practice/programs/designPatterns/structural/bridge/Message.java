package com.chandresh.practice.programs.designPatterns.structural.bridge;

public abstract class Message {

	protected String message;
	protected IMessageSender messageSender;
	public Message(String message, IMessageSender messageSender) {
		this.message = message;
		this.messageSender = messageSender;
	}
	
	public abstract void sendMessage();
}
