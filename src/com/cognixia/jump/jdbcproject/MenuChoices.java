package com.cognixia.jump.jdbcproject;

import java.util.Scanner;

public class MenuChoices {

	static EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
	static Scanner input = new Scanner(System.in);
	int again = 0;

	public static void getAll() { // Menu choice for getting all employees.
		System.out.println(runner.getAllEmployees());
	}

	public static void getEmpId() throws CustomException { // Menu choice for getting an employee with matching ID.
		System.out.println("Please enter an ID: ");
		int inputId = input.nextInt();
		System.out.println(runner.getEmployeeById(inputId));
	}

	public static void getEmpFname() throws CustomException { // Menu choice for getting an employee with matching first
																// name.
		System.out.println("Please enter a first name: ");
		String inputFname = input.next();
		System.out.println(runner.getEmployeeByFirstName(inputFname));
	}

	public static void getEmpLname() throws CustomException { // Menu choice for getting an employee with matching last
																// name.
		System.out.println("Please enter a last name: ");
		String inputLname = input.next();
		System.out.println(runner.getEmployeeByLastName(inputLname));
	}

	public static void addNewEmp() { // Menu choice for adding a new employee.
		System.out.println("Please enter a first name: ");
		String newFname = input.next();
		System.out.println("Please enter a last name: ");
		String newLname = input.next();
		System.out.println("Please enter a department name: ");
		String newDept = input.next();
		System.out.println("Please enter a salary: ");
		int newSal = input.nextInt();
		System.out.println("Please enter remaining vacation days: ");
		int newVac = input.nextInt();

		Employee addNew = new Employee(newFname, newLname, newDept, newSal, newVac);
		if (runner.addEmployee(addNew) == true) {
			System.out.println("New employee added successfully!");
		} else
			System.out.println("Something went wrong...");
	}

	public static void updateEmp() { // Menu choice for updating an employee with matching ID.
		System.out.println("Please enter the ID of the employee you want to update: ");
		int updateId = input.nextInt();
		System.out.println("Please enter a first name: ");
		String updateFname = input.next();
		System.out.println("Please enter a last name: ");
		String updateLname = input.next();
		System.out.println("Please enter a department name: ");
		String updateDept = input.next();
		System.out.println("Please enter a salary: ");
		int updateSal = input.nextInt();
		System.out.println("Please enter remaining vacation days: ");
		int updateVac = input.nextInt();

		Employee addUpdate = new Employee(updateId, updateFname, updateLname, updateDept, updateSal, updateVac);
		if (runner.updateEmployee(addUpdate) == true) {
			System.out.println("Employee updated successfully!");
		} else
			System.out.println("Something went wrong...");
	}

	public static void deleteEmp() throws CustomException { // Menu choice for deleting an employee with matching ID.
		System.out.println("Please enter the ID of the employee you want to delete: ");
		int deleteId = input.nextInt();
		if (runner.deleteEmployee(runner.getEmployeeById(deleteId)) == true) {
			System.out.println("Employee delete successful!");
		} else
			System.out.println("Something went wrong with update...");
	}

	public static void getEmpAddress() throws CustomException { // Menu choice for getting an employee's information
																// along with their address information.
		System.out.println("Please enter an ID: ");
		int inputIdAddress = input.nextInt();
		System.out.println(runner.getEmployeeAddressById(inputIdAddress).toStringWithAddress());
	}

}
