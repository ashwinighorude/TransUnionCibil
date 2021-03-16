
  package com.example.Junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.Junit.example.Employee;
import com.example.Junit.example.EmployeeWithEquals;
import com.example.Junit.example.EmployeeWithHashcode;
import com.example.Junit.example.EmployeeWithHashcodeEquals;

public class JunitApplicationTests {
	
	
	@Test
	public void StreamOperations() {
		
		List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertNotNull(list);
		 Integer[] expectedSquares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
		 List<Integer> numbers = list.stream()
	                .map(n -> n * n)
	                .collect(Collectors.toList());
		 assertArrayEquals(expectedSquares, numbers.toArray());
		 
		 //Even number squares
		 Integer[] expectedEvnSquares = {4,16,36,64,100};
		 List<Integer> evenNumbers = list.stream()
                 .filter(n -> n % 2 == 0)
                 .map(n -> n * n)
                 .collect(Collectors.toList());
		 
		 assertArrayEquals(expectedEvnSquares, evenNumbers.toArray());
	}
	
	
	@Test
	public void treesetSorting() {
		SortedSet<Employee> employeeSet = new TreeSet<>();
		employeeSet.add(new Employee(2, "Ashwini", "Ghorude"));
		employeeSet.add(new Employee(1, "Supriya", "Ghorude"));
		employeeSet.add(new Employee(3, "Mahadev", "Ghorude"));
		assertNotNull(employeeSet);
		//create another employeeSet
		SortedSet<Employee> employeeSample = new TreeSet<>();
		employeeSample.add(new Employee(3, "Mahadev", "Ghorude"));
		employeeSample.add(new Employee(1, "Supriya", "Ghorude"));
		employeeSample.add(new Employee(2, "Ashwini", "Ghorude"));
		assertNotNull(employeeSample);
		assertEquals(employeeSet, employeeSample);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void tryWithResources() throws FileNotFoundException, IOException {
		  try(FileInputStream input = new FileInputStream("G:\\ash.txt")) {
			  assertNotNull(input);  
			  int data = input.read();
			  assertNotNull(data);  
		        while(data != -1){
		            System.out.print((char) data);
		            data = input.read();
		        }
		    }
	}
	
	
	@Test
	public void withoutHashcodeAndEquals() {

		Employee emp1 = new Employee(1, "Ashwini", "Ghorude");
		Employee emp2 = new Employee(1, "Ashwini", "Ghorude");
		boolean status = hashcodeEquals(emp1.hashCode(), emp2.hashCode());
		assertEquals(false, status);
		assertEquals(false, emp1.equals(emp2));
	}

	@Test
	public void onlyWithEquals() {
		EmployeeWithEquals emp1 = new EmployeeWithEquals(1, "Ashwini", "Ghorude");
		EmployeeWithEquals emp2 = new EmployeeWithEquals(1, "Ashwini", "Ghorude");
		assertEquals(true, emp1.equals(emp2));
		boolean status = hashcodeEquals(emp1.hashCode(), emp2.hashCode());
		assertEquals(false, status);
	}

	@Test
	public void onlyWithHashcode() {
		EmployeeWithHashcode emp1 = new EmployeeWithHashcode(1, "Ashwini", "Ghorude");
		EmployeeWithHashcode emp2 = new EmployeeWithHashcode(1, "Ashwini", "Ghorude");
		HashSet<EmployeeWithHashcode> students = new HashSet<EmployeeWithHashcode>();
		students.add(emp1);
		students.add(emp2);
		assertEquals(2, students.size());
		assertEquals(false, students.contains(new EmployeeWithHashcode(1, "Ashwini", "Ghorude")));
	}

	@Test
	public void implementingBoth() {
		HashSet<EmployeeWithHashcodeEquals> Employee = new HashSet<EmployeeWithHashcodeEquals>();
		EmployeeWithHashcodeEquals emp1 = new EmployeeWithHashcodeEquals(1, "Ashwini", "Ghorude");
		EmployeeWithHashcodeEquals emp2 = new EmployeeWithHashcodeEquals(1, "Ashwini", "Ghorude");
		Employee.add(emp1);
		Employee.add(emp2);
		assertEquals(1, Employee.size());
		boolean status = hashcodeEquals(emp1.hashCode(), emp2.hashCode());
		assertEquals(true, status);
		assertEquals(true, emp1.equals(emp2));
		

	}

	public boolean hashcodeEquals(int hashcode1, int hashcode2) {
		if (hashcode1 == hashcode2)
			return true;
		else
			return false;
	}

	@Test
	public void testStream() {
		
	}
  
  }
 
