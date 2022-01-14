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

		Scanner input = new Scanner(System.in);
		int again = 0;

		do {
			System.out.println("** Welcome to Sidney's EMS; please enter a selection below. **\n");
			System.out.println("1. View all employees\n2. View employee by ID\n3. View employee by First Name\n"
					+ "4. View employee by Last name\n5. Add a new employee\n6. Update existing employee\n7. Delete existing employee"
					+ "\n8. Get employee with address by ID\n");

			int option = input.nextInt();

			switch (option) {
			case 1:
				MenuChoices.getAll();
				break;

			case 2:
				MenuChoices.getEmpId();
				break;

			case 3:
				MenuChoices.getEmpFname();
				break;

			case 4:
				MenuChoices.getEmpLname();
				break;

			case 5:
				MenuChoices.addNewEmp();
				break;

			case 6:
				MenuChoices.updateEmp();
				break;

			case 7:
				MenuChoices.deleteEmp();
				break;

			case 8:
				MenuChoices.getEmpAddress();
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
