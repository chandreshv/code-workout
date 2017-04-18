package com.chandresh.practice.programs.designPatterns.creational;

import java.io.IOException;
import java.util.Collections;


class A{
	public void show() throws IOException{
		System.out.println("A's method");
	}
}

class B extends A{
	public  void show(){
		System.out.println("B's method");
		this.show1();
		
	}
	
	public void show1(){
		System.out.println("Show1 called");
		B b = (B) new A();
	}
}


public class Test{
		   public static void main(String[] xargs) {
		         String str = "ABC";
		         String[] arr = new String[1];
		         arr[0] = str;
		         System.out.println(str + "    " + arr[0]);   
		         concatenate(str, arr);
		         System.out.println(str + "    " + arr[0]);
		     }
		    static void concatenate(String str, String[] arr) {
		        str = str + arr[0];
		        arr[0] = str;
		        arr = new String[1];	
		        arr[0] = "";
		    }
	
}
