/*
 * EMS application that communicates with MySQL database using JDBC driver. CRUD functionality
 * is implemented using prepared statements and regular statements. User is prompted with a menu
 * where they can choose what option they want to execute.
 * 
 * This is the main/driver class.
 * 
 * Sidney Henderson
 * v1.0
 */

package com.cognixia.jump.jdbcproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws CustomException {

		EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
		Scanner input = new Scanner(System.in);
		int again = 0;

		do {
			System.out.println("** Welcome to Sidney's EMS; please enter a selection below. **");
			System.out.println("1. View all employees\n2. View employee by ID\n3. View employee by First Name\n"
					+ "4. View Employee by Last name\n5. Add a new employee\n6. Update existing employee\n7. Delete existing employee\n");

			int option = input.nextInt();

			switch (option) {
			case 1:
				System.out.println(runner.getAllEmployees());
				break;

			case 2:
				System.out.println("Please enter an ID: ");
				int inputId = input.nextInt();
				System.out.println(runner.getEmployeeById(inputId));
				break;

			case 3:
				System.out.println("Please enter a first name: ");
				String inputFname = input.next();
				System.out.println(runner.getEmployeeByFirstName(inputFname));
				break;

			case 4:
				System.out.println("Please enter a last name: ");
				String inputLname = input.next();
				System.out.println(runner.getEmployeeByLastName(inputLname));
				break;

			case 5:
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
				break;

			case 6:
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
				break;

			case 7:
				System.out.println("Please enter the ID of the employee you want to delete: ");
				int deleteId = input.nextInt();
				if (runner.deleteEmployee(runner.getEmployeeById(deleteId)) == true) {
					System.out.println("Employee delete successful!");
				} else
					System.out.println("Something went wrong with update...");
				break;

			default:
				System.out.println("Invalid selection, please try again.");
				break;
			}

			System.out.println("\nWould you like to do another query?\nEnter '1' for yes\nEnter '2' for no:\n");
			again = input.nextInt();
		} while (again != 2);

		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			System.out.println("Could not close connection");
			e.printStackTrace();
		}

		input.close();
		System.out.println("Program has ended.");

	}
}
