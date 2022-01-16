package com.lee.ems.business;

import com.lee.ems.Employee;

public class PermanentEmployeeSalaryCalculator extends SalaryCalculator {
	
	public void calculateNetSalary(Employee e, int actualSalary) {
		
		int grossSalary = getGrossSalary(e, actualSalary);
		int incomeTax = 1000;
		int pf = 800;
		int gratuity = 100;
		int netSalary = grossSalary - (incomeTax + pf + gratuity);
		
		System.out.println("Permanent Employee Salary Details");
		System.out.println("EmpID = " + e.getEmpid());
		System.out.println("EmpName = " + e.getEmpName());
		System.out.println("Designation = " + e.getDesignation());
		System.out.println("Gross Salary = " + grossSalary);
		System.out.println("Net Salary = " + netSalary);
		System.out.println("Deductions = " + (pf + incomeTax + gratuity));		
	}

}
