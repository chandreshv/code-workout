package com.chandresh.practice.programs.java;

import java.util.ArrayList;
import java.util.List;

class Employee {
	
	public Employee (String name, int id, String address, int age, int salary) {
		this.name = name;
		this.id = id;
		this.address = address;
		this.age = age;
		this.salary = salary;
	}
	
	private String name;
	private int id;
	private String address;
	private int age;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void printEmployee(){
		System.out.println(this.getName());
	}
	
	
	
	public static void printEmployeeOlderThan(List<Employee> employees, int olderThan ){
		for(Employee eachEmp: employees){
			if(eachEmp.getAge()>olderThan)
				eachEmp.printEmployee();
		}
	}
	
	public static void printPersons(List<Employee> employees, Tester testCriteria){
		for(Employee eachEmp: employees){
			if(testCriteria.test(eachEmp))
				eachEmp.printEmployee();
		}
	}

}

interface Tester{
	public boolean test(Employee e);
}

public class Lambda {
	public static void main(String args[]) {
		List<Employee> listEmp = new ArrayList<Employee>();
		Employee e1 = new Employee("Chandresh", 1, "Pune", 29, 1000);
		Employee e2 = new Employee("Vashistha", 2, "Pune", 35, 1000);
		listEmp.add(e1);
		listEmp.add(e2);
		//Employee.printEmployeeOlderThan(listEmp, 30);
		
		//Employee.printPersons(listEmp, (Employee e)->{e.getAge()<30});
		
	}
}
