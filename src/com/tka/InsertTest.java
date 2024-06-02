package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class InsertTest {

	@Test
	public static int testInsertData() throws Exception {
		int rows =0 ;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement statement = con.createStatement();
		String sql = "insert into employees values (111 , 'Rahul' , 'DDD' )";
		 rows = statement.executeUpdate(sql);
		System.out.println("Inserted...");
		return rows; 
	}
	
	@Test
	public void testSum() throws Exception {
		// Actual result   --- runtime 
		// Expected result -- 1 or positive
		Assert.assertEquals(1, InsertTest.testInsertData());
	}

}
