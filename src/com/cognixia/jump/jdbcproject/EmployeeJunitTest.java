package com.cognixia.jump.jdbcproject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeJunitTest {

	private static EmployeeDAOImplementation runner;
	private static Employee sidney;
	private static Employee sidneyWithAddress;

	@BeforeAll
	public static void setup() {
		runner = new EmployeeDAOImplementation();
		sidney = new Employee(1, "Sidney", "Henderson", "IT", 60000, 14);
		sidneyWithAddress = new Employee(1, "Sidney", "Henderson", "IT", 60000, 14, "898 Hyrule Lane", "Termina",
				"12345");
	}

	@Test
	void testGetAllEmployees() {

		List<Employee> actual = runner.getAllEmployees();

		assertTrue(!actual.isEmpty());
	}

	@Test
	void testGetEmpById() throws CustomException {

		Employee actual = runner.getEmployeeById(1);
		Employee expected = sidney;
		assertEquals(actual.getId(), expected.getId());
	}

	@Test
	void testGetEmpByFirstName() throws CustomException {

		Employee actual = runner.getEmployeeByFirstName("Sidney");
		Employee expected = sidney;
		assertEquals(actual.getEmpFname(), expected.getEmpFname());
	}

	@Test
	void testGetEmpByLastName() throws CustomException {

		Employee actual = runner.getEmployeeByLastName("Henderson");
		Employee expected = sidney;
		assertEquals(actual.getEmpLname(), expected.getEmpLname());
	}

	@Test
	void testAddEmployee() throws CustomException {

		Employee addNew = new Employee("Junit", "Test", "Data", 55555, 1);
		Boolean actual = runner.addEmployee(addNew);
		assertTrue(actual);
	}

	@Test
	void testUpdateEmployee() throws CustomException {

		Employee update = new Employee(28, "Junit", "Test", "Data", 55555, 1);
		Boolean actual = runner.updateEmployee(update);
		assertTrue(actual);
	}

	@Test
	void testDeleteEmployee() throws CustomException {

		Employee delete = new Employee(33, "Junit", "Test", "Data", 55555, 1);
		Boolean actual = runner.deleteEmployee(delete);
		assertTrue(actual);
	}

	@Test
	void testGetEmpAddressById() throws CustomException {

		Employee actual = runner.getEmployeeAddressById(1);
		Employee expected = sidneyWithAddress;
		assertEquals(actual.getAddress(), expected.getAddress());
	}

	@Test
	void testException() {
		assertThrows(CustomException.class, () -> {
			runner.getEmployeeByFirstName("");
		});
	}
}
