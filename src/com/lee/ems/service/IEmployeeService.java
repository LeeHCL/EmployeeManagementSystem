package com.lee.ems.service;

import java.util.List;

import com.lee.ems.Employee;
import com.lee.ems.exceptions.EmployeeNotFoundException;

public interface IEmployeeService {
	public abstract void addEmployee(Employee e); 
	public abstract void deleteEmployee(int empid); 
	public abstract void updateEmployee(Employee e); 
	public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException; 
	public List<Employee> showAllEmployees();

}
