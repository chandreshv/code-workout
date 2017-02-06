package com.chandresh.practice.programs.designPatterns.creational;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		new Test().add();
	}

	private void add() {
		Scanner scannerInput;

		System.out.println("Enter first number ");
		scannerInput = new Scanner(System.in);
		int num1 = Integer.parseInt(scannerInput.nextLine());

		System.out.println("Enter second number ");
		scannerInput = new Scanner(System.in);
		int num2 = Integer.parseInt(scannerInput.nextLine());

		System.out.println("Sum is : " + (num1 + num2));
		scannerInput.close();
		
	}
}
