package com.cognixia.jump.jdbcproject;

public class Employee {

	private int id;
	private String empFname;
	private String empLname;
	private String department;
	private int salary;
	private int vacationDays;
	private String address;
	private String city;
	private String zipcode;

	public Employee() {

	}

	public Employee(int id, String empFname, String empLname, String department, int salary, int vacationDays) {
		super();
		this.id = id;
		this.empFname = empFname;
		this.empLname = empLname;
		this.department = department;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}

	public Employee(String empFname, String empLname, String department, int salary, int vacationDays) {
		super();
		this.empFname = empFname;
		this.empLname = empLname;
		this.department = department;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}

	public Employee(int id, String empFname, String empLname, String department, int salary, int vacationDays,
			String address, String city, String zipcode) {
		super();
		this.id = id;
		this.empFname = empFname;
		this.empLname = empLname;
		this.department = department;
		this.salary = salary;
		this.vacationDays = vacationDays;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpFname() {
		return empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpLname() {
		return empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname = empLname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", First Name=" + empFname + ", Last Name=" + empLname + ", Department="
				+ department + ", Salary=" + salary + ", Vacation Days=" + vacationDays + "]";
	}

	public String toStringWithAddress() {
		return "\nEmployee [id=" + id + ", First Name=" + empFname + ", Last Name=" + empLname + ", Department="
				+ department + ", Salary=" + salary + ", Vacation Days=" + vacationDays + ", Address=" + address
				+ ", City=" + city + ", Zipcode=" + zipcode + "]";
	}
}
