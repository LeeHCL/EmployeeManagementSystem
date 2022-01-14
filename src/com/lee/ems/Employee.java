package com.lee.ems;

public class Employee {
	private int empid;
	private String empName;
	private String designation;
	private int daysAttended;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empid, String empName, String designation, int daysAttended) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.designation = designation;
		this.daysAttended = daysAttended;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getDaysAttended() {
		return daysAttended;
	}

	public void setDaysAttended(int daysAttended) {
		this.daysAttended = daysAttended;
	}

}
