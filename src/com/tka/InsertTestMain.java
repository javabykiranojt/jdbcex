package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class InsertTestMain {

	public static void main(String[] args) throws Exception {
		int rows = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement statement = con.createStatement();
		String sql = "insert into employees values (111 , 'DDD' , 'Rahul' , 'May-22')";
		rows = statement.executeUpdate(sql);
		System.out.println(rows + " are Inserted...");
	}

}
