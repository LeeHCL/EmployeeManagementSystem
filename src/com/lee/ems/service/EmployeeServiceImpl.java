package com.lee.ems.service;

import java.util.List;

import com.lee.ems.Employee;
import com.lee.ems.dao.EmployeeDAOMySqlImpl;
import com.lee.ems.dao.IEmployeeDAO;
import com.lee.ems.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements IEmployeeService{
	
	private IEmployeeDAO empDao = new EmployeeDAOMySqlImpl();

	@Override
	public void addEmployee(Employee e) {
		empDao.addEmployee(e);
		
	}

	@Override
	public void deleteEmployee(int empid) {
		empDao.deleteEmployee(empid);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		empDao.updateEmployee(e);
		
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		return empDao.findEmployee(e);
	}

	@Override
	public List<Employee> showAllEmployees() {
		return empDao.showAllEmployees();
	}

}
