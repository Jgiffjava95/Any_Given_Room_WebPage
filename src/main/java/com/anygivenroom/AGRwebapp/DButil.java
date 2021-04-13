package com.anygivenroom.AGRwebapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {

	private static String connectionURL = "jdbc:mysql://agrdb.co4g0adjdiph.us-east-1.rds.amazonaws.com/AgrWebAppData?user=admin&password=AnyGivenR00m";

	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DButil.getConnection();

		if (null != conn) {
			System.out.println("A Complete Connection.");

			DatabaseMetaData metaData = conn.getMetaData();
			ResultSet rs = metaData.getTables(null, null, "%", null);

			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
		} else {
			System.out.println("Error, No Connection.");

		}

	}
}
