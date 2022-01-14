package com.lee.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.lee.ems.Employee;
import com.lee.ems.exceptions.EmployeeNotFoundException;

public class EmployeeDAOMySqlImpl implements IEmployeeDAO{
	
	private Connection cn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	public static final String INS_COMMAND="INSERT INTO employee VALUES(?,?,?,?)";
	public static final String UPDATE_COMMAND="UPDATE employee SET empname=?, designation=? daysattend=?,WHERE empid=?";
	public static final String DELETE_COMMAND="DELETE FROM employee WHERE empid=?";
	public static final String FIND_COMMAND="SELECT * FROM employee WHERE empid=?";
	public static final String SELECT_ALL="SELECT * FROM employee";
	
	public EmployeeDAOMySqlImpl() {
		try {
		cn = DriverManager.getConnection(IEmployeeDAO.URL, IEmployeeDAO.USERNAME, IEmployeeDAO.PASSWORD);
		} catch (SQLException e) {
			System.out.println("Unable to establish the connection with Database");
			e.printStackTrace();
		}
	}
	@Override
	public void addEmployee(Employee e) {
		int i = 0;
		
		try {
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setInt(1, e.getEmpid());
			pst.setString(2, e.getEmpName());
			pst.setString(3, e.getDesignation());
			pst.setInt(4, e.getDaysAttended());
			i = pst.executeUpdate();
			pst.close();
		} catch (SQLException e1) {
			System.out.println("Adding record failed..Unable to execite INSERT command");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (i>1) {
			System.out.println("Record added...");
		}
	}

	@Override
	public void deleteEmployee(int empid) {
		int i = 0;
		try {
			pst = cn.prepareStatement(DELETE_COMMAND);
			pst.setInt(1, empid);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete operations failed.. unable to execute DELETE commmand");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i>0) {
			System.out.println("Record deleted successfully");
		}
	}

	@Override
	public void updateEmployee(Employee e) {
		int i = 0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setInt(4, e.getEmpid());
			pst.setString(1, e.getEmpName());
			pst.setString(2, e.getDesignation());
			pst.setInt(3, e.getDaysAttended());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Update operation failed.. Unable to execute UPDATE command");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (i>0) {
			System.out.println("Record deleted successfully");
		}

	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		Employee findTemp = null;
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, e.getEmpid());
			rs = pst.executeQuery();
			if (!rs.next()) {
				throw new EmployeeNotFoundException(e.getEmpid());
			} else {
				findTemp = new Employee();
				findTemp.setEmpName(rs.getString("empname"));
				findTemp.setDesignation(rs.getString("designation"));
				findTemp.setDaysAttended(rs.getInt("daysattended"));
				findTemp.setEmpid(e.getEmpid());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EmployeeNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return findTemp;
	}

	@Override
	public List<Employee> showAllEmployees() {
		Employee selectAllTemp = null;
		List<Employee> eList = new LinkedList<>();
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				selectAllTemp = new Employee();
				selectAllTemp.setEmpid(rs.getInt("empid"));
				selectAllTemp.setEmpName(rs.getNString("empname"));
				selectAllTemp.setDesignation(rs.getString("designation"));
				selectAllTemp.setDaysAttended(rs.getInt("daysattended"));
				eList.add(selectAllTemp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return eList;
	}

}
