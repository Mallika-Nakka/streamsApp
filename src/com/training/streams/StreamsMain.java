
//Author @Mallika;
//created on 29-10-2021


package com.training.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.Iterator;

class NameSort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}

class CitySort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.city.compareTo(o2.city);
	}

}

class EmpIdSort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.empId.compareTo(o2.empId);
	}

}

public class StreamsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Neelima", "Hyderabad", 1));
		empList.add(new Employee("Meena", "Pune", 2));
		empList.add(new Employee("Ravi", "Hyderabad", 3));
		empList.add(new Employee("Sreekanth", "Pune", 4));
		empList.add(new Employee("Mohan", "Chennai", 5));

		// printing employees using for-each method
		System.out.println("All employees details...");
		System.out.println();
		List<String> totalNames = new ArrayList<>();
		List<String> totalCities = new ArrayList<>();
		List<Integer> totalIds = new ArrayList<>();

		for (Employee emp : empList) {
			System.out.println(emp);
			totalNames.add(emp.name);
			totalCities.add(emp.city);
			totalIds.add(emp.empId);

		}

		// converting list of employees into stream
		Stream<Employee> employeeStream = empList.stream();
		System.out.println();
		System.out.println("Which city employees you want Enter that city in Hyderabad/Chennai/Pune");
		Scanner sc = new Scanner(System.in);
		String empCity = sc.next();
		// filtering the stream by city
		Stream<Employee> empBasedOnCities = employeeStream.filter((employee) -> employee.city.equals(empCity));

		// Iterating over the filtered stream
		Iterator<Employee> ite = empBasedOnCities.iterator();

		while (ite.hasNext()) {
			Employee emp = ite.next();
			System.out.println(emp);
		}
		System.out.println();
		System.out.println("choose in which sorted way you want the list of employees like name/city/empId");

		String userValue = sc.next();

		switch (userValue) {
		case ("name"):
			NameSort name = new NameSort();
			Collections.sort(empList, name);

			Iterator<Employee> nameIterator = empList.iterator();
			while (nameIterator.hasNext()) {
				Employee emp = nameIterator.next();
				System.out.println(emp);

			}

			break;
		case ("city"):

			CitySort city = new CitySort();
			Collections.sort(empList, city);

			Iterator<Employee> cityIterator = empList.iterator();
			while (cityIterator.hasNext()) {
				Employee emp = cityIterator.next();
				System.out.println(emp);

			}

			break;
		case ("empId"):

			EmpIdSort empId = new EmpIdSort();
			Collections.sort(empList, empId);

			Iterator<Employee> empIdIterator = empList.iterator();
			while (empIdIterator.hasNext()) {
				Employee emp = empIdIterator.next();
				System.out.println(emp);

			}

			break;
		default:
			System.out.println("Exited");
			System.exit(10);

		}

		// get employee by Id
		System.out.println();

		System.out.println("Enter employee id to know the details of the employee");

		int id = sc.nextInt();

		try {
			Employee empDetails = empList.stream().filter(employee -> employee .empId == id).findFirst()
					.orElseThrow(() -> new Exception("Employee not found"));
			System.out.println( empDetails);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println();

		// print all employee names that starts with K

		System.out.println("Employee whose name starts with k");
		System.out.println();
		try {
			Employee empid = empList.stream().filter(empl -> empl.name.startsWith("K")).findFirst()
					.orElseThrow(() -> new Exception("Not found"));
			System.out.println("Emp : " + empid);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
