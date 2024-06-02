package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeEx {
	public static void main(String[] args) throws Exception {
		System.out.println(1);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println(2);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		con.setAutoCommit(false);
		Connection conInsert = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		conInsert.setAutoCommit(false);
		System.out.println(3);
		Statement statement = con.createStatement();
		Statement statementInsert = conInsert.createStatement();
		String sql = "select * from employees";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String eid = resultSet.getString(1);
			String deptName = resultSet.getString(2);
			String ename = resultSet.getString(3);
			String hiredate = resultSet.getString(4);
			System.out.println(eid);
			System.out.println(deptName);
			System.out.println(ename);
			System.out.println(hiredate);
			String sqlInsert = "insert into employeescopy (dept,ename,hiredate) " + "values('" + deptName + "','"
					+ ename + "','" + hiredate + "')";
			int updatedcount = statementInsert.executeUpdate(sqlInsert);
			System.out.println("data inserted >" + updatedcount);
			if (updatedcount == 1) {
				conInsert.commit();
			} else {
				conInsert.rollback();
			}
		}

	}

}
