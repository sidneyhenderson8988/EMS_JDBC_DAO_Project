
package com.cognixia.jump.jdbcproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements EmployeeDAO {

	private Connection connection = ConnectionManager.getConnection();

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM employees");

			while (rs.next()) {
				int id = rs.getInt(1);
				String empFname = rs.getString("first_name");
				String empLname = rs.getString("last_name");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				int vacationDays = rs.getInt("vacation_days");

				Employee employee = new Employee(id, empFname, empLname, department, salary, vacationDays);
				employees.add(employee);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) throws CustomException {
		Employee employee = null;
		try {
			if (id < 0) {
				throw new CustomException("ID cannot be negative");
			}
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt(1);
				String empFname = rs.getString("first_name");
				String empLname = rs.getString("last_name");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				int vacationDays = rs.getInt("vacation_days");

				employee = new Employee(empId, empFname, empLname, department, salary, vacationDays);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (CustomException ce) {
			ce.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeByFirstName(String fName) throws CustomException {
		Employee employee = null;
		try {

			if (fName.isBlank()) {
				throw new CustomException("Name search field cannot be blank");
			}

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE first_name = ?");
			statement.setString(1, fName);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt(1);
				String empFname = rs.getString("first_name");
				String empLname = rs.getString("last_name");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				int vacationDays = rs.getInt("vacation_days");

				employee = new Employee(empId, empFname, empLname, department, salary, vacationDays);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeByLastName(String lName) {
		Employee employee = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE last_name = ?");
			statement.setString(1, lName);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt(1);
				String empFname = rs.getString("first_name");
				String empLname = rs.getString("last_name");
				String department = rs.getString("department");
				int salary = rs.getInt("salary");
				int vacationDays = rs.getInt("vacation_days");

				employee = new Employee(empId, empFname, empLname, department, salary, vacationDays);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		int count = 0;
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO employees (first_name,last_name,department,salary,vacation_days)"
							+ " VALUES (?,?,?,?,?);");

			statement.setString(1, employee.getEmpFname());
			statement.setString(2, employee.getEmpLname());
			statement.setString(3, employee.getDepartment());
			statement.setInt(4, employee.getSalary());
			statement.setInt(5, employee.getVacationDays());

			count = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 1)
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE employees "
					+ "SET first_name = ?,last_name = ?,department = ?,salary = ?,vacation_days = ? "
					+ "WHERE id = ?;");

			statement.setString(1, employee.getEmpFname());
			statement.setString(2, employee.getEmpLname());
			statement.setString(3, employee.getDepartment());
			statement.setInt(4, employee.getSalary());
			statement.setInt(5, employee.getVacationDays());
			statement.setInt(6, employee.getId());

			count = statement.executeUpdate();

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 1)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
			statement.setInt(1, employee.getId());
			count = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count == 1)
			return true;
		return false;
	}

}
