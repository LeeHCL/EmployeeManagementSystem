package com.lee.ems.main;

import com.lee.ems.Employee;
import com.lee.ems.business.ContractEmployeeSalaryCalculator;
import com.lee.ems.business.PermanentEmployeeSalaryCalculator;

public class EmployeeSalaryMain {
	
	public static void main(String[] args) {
		
		PermanentEmployeeSalaryCalculator pe = new PermanentEmployeeSalaryCalculator();
		
		pe.calculateNetSalary(new Employee(1234, "A", "Clerk", 28), 30000);
		
		System.out.println("****");
		ContractEmployeeSalaryCalculator ce = new ContractEmployeeSalaryCalculator();
		pe.calculateNetSalary(new Employee(4321, "B", "Manager", 20), 50000);

	}

}
