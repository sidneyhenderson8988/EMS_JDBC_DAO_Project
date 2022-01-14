package com.cognixia.jump.jdbcproject;

import java.util.List;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id) throws CustomException;

	public Employee getEmployeeAddressById(int id) throws CustomException;

	public Employee getEmployeeByFirstName(String name) throws CustomException;

	public Employee getEmployeeByLastName(String name);

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(Employee employee);
}
