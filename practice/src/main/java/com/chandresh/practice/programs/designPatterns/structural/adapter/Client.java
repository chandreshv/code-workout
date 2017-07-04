package com.chandresh.practice.programs.designPatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

class A{}
class B extends A{}
class C extends A{}


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("without adapter");
		Client c = new Client();
		OldInterface old = new OldInterfaceImplementation("Chandresh");
		c.testMethods(old);
		
		System.out.println("\n \nWith adapter");
		NewInterface newInterface = new NewInterfaceImplementation("Chandresh");
		OldInterface adapter = new AdapterImplementation(newInterface);
		c.testMethods(adapter);
	}
	
	public void testMethods(OldInterface ref){
		String message = "Hello "+ ref.getUser();
		ref.print(message);
	}
	
}
