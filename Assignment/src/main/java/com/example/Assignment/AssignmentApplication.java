package com.example.Assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
		
		//-----------------Demonstrating Equality by overriding hashmap and equals ------------------------------
		
		HashSet<EmployeeCheck> hashSet = new HashSet<EmployeeCheck>();
		EmployeeCheck emp1= new EmployeeCheck(1, "Ashwini", "Ghorude");
		EmployeeCheck emp2= new EmployeeCheck(1, "Ashwini", "Ghorude");
		hashSet.add(emp1);
		hashSet.add(emp2);
		System.out.println("emp1 hashcode = " + emp1.hashCode()+"  emp2 hashcode = " + emp2.hashCode());
        System.out.println("Checking equality between emp1 and emp2 = " + emp1.equals(emp2));
		System.out.println("hash code : "+hashSet);
		
		//overriding hashcode
		  System.out.println("HashSet size = " + hashSet.size());
	      System.out.println("HashSet contains Alex = " + hashSet.contains(new EmployeeCheck(1, "Ashwini", "Ghorude")));

	      
	      //-------------- Demonstrating Streams --------------------------------------------------------
	      
	    //List Of integers
			List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			 
			
			//Square of each number
			 List<Integer> numbers = list.stream()
	                .map(n -> n * n)
	                .collect(Collectors.toList());
	     
	        System.out.println("Square of each number : "+numbers);
			
			//Square of even
			 List<Integer> evenNumbers = list.stream()
	                 .filter(n -> n % 2 == 0)
	                 .map(n -> n * n)
	                 .collect(Collectors.toList());
	      
	         System.out.println("Square of even nos : "+evenNumbers);
	         
	    //-----------------Demonstrating multithreading ---------------------------
	         
	         Thread t1 = new Thread(()->
	 		{
	 			for(int i =1;i<3;i++){
	 				System.out.println("Thread 1 executing..");
	 				try {
	 					Thread.sleep(100);
	 				} catch (InterruptedException e) {
	 					e.printStackTrace();
	 				} 
	 			}
	 		});
	 		
	 		Thread t2 = new Thread(()->
	 		{
	 			for(int i =1;i<3;i++){
	 				System.out.println("Thread 2 executing..");
	 				try {
	 					Thread.sleep(100);
	 				} catch (InterruptedException e) {
	 					e.printStackTrace();
	 				}
	 			}
	 		});
	 		
	 		Thread t3 = new Thread(()->
	 		{
	 			for(int i =1;i<3;i++){
	 				System.out.println("Thread 3 executing..");
	 				try {
	 					Thread.sleep(100);
	 				} catch (InterruptedException e) {
	 					e.printStackTrace();
	 				}
	 			}
	 		});
	 		
	 		Thread t4 = new Thread(()->
	 		{
	 			for(int i =1;i<3;i++){
	 				System.out.println("Thread 4 executing..");
	 				try {
	 					Thread.sleep(100);
	 				} catch (InterruptedException e) {
	 					e.printStackTrace();
	 				}
	 			}
	 		});
	 		
	 		Thread t5 = new Thread(()->{
	 			System.out.println("Thread 5 executing now..");
	 		});
	 		
	 		t1.start();t2.start();t3.start();t4.start();
	 		try {
				t1.join();t2.join();t3.join();t4.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 		
	 		System.out.println("Main thread executing this ..");
	 		System.out.println("Alive status : T1 : "+t1.isAlive()+" T2 :"+t2.isAlive()+" T3 :"+t3.isAlive()+" T4 :"+t4.isAlive()+" T5 :"+t5.isAlive());
	 		t5.start();
	         
	 		
	 		//--------------- Demostrating treeset sorting -------------------------------------------------
	 		
	 		SortedSet<Employee> employeeSet = new TreeSet<>();
			employeeSet.add(new Employee(2, "Ashwini", "Ghorude"));
			employeeSet.add(new Employee(1, "Supriya", "Ghorude"));
			employeeSet.add(new Employee(3, "Mahadev", "Ghorude"));

			System.out.println("Default sorting  : " + employeeSet);

			employeeSet = new TreeSet<>(Comparator.comparing(Employee::getFirstname));
			employeeSet.add(new Employee(3, "Mahadev", "Ghorude"));
			employeeSet.add(new Employee(2, "Supriya", "Ghorude"));
			employeeSet.add(new Employee(1, "Ashwini", "Ghorude"));
			employeeSet.add(new Employee(4, "Amit", "Ghorude"));
			
			System.out.println("Sorted by  firstname"+employeeSet);
			
	}

}
