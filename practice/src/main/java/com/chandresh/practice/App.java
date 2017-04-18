package com.chandresh.practice;

import java.util.LinkedList;
import java.util.Queue;


class Employee{
	public Employee(int id) {
		this.id=id;
	}
	int id;
}


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(4);
    	q.add(1);
    	q.add(66);
    	
    	System.out.println(q.poll());
    }
    
    public void calculator(int a, int b, int c, int d){
    	
    }
}
