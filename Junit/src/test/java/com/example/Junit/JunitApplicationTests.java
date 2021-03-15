
  package com.example.Junit;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

import com.example.Junit.example.Employee;
import com.example.Junit.example.EmployeeWithEquals;
import com.example.Junit.example.EmployeeWithHashcode;
import com.example.Junit.example.EmployeeWithHashcodeEquals;

public class JunitApplicationTests {
	
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


  
  }
 