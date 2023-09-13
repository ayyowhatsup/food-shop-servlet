 package com.group3.TienIch;

import java.sql.*;

public class KetNoiCSDL {

	public static Connection ketNoiPostgreSQL() {
		Connection conn = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
