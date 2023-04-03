package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtils {
	static Connection getconnectionTodatabase() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");

		return DriverManager.getConnection(rb.getString("url"),rb.getString("user"), rb.getString("pass"));

	}

	static void CloseConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if (!rs.isBeforeFirst() && rs.getRow() == 0)
			return true;
		return false;
	}

}
