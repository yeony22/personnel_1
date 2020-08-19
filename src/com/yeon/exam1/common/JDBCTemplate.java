package com.yeon.exam1.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() {

		Connection conn = null; // DB ������ ��ü ����

		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); // �ش� Ŭ������ �޸𸮿� �ε� �� ����

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		}

		try { // drive Ŭ������ �̿��� Ŀ�ؼ� ��ü�� localhost:3306/practice1 �� ���� �� ����ó��
			String url = "jdbc:mysql://localhost:3306/student_data?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			conn = DriverManager.getConnection(url, "root", "Weak"); // DB �α��� ������ ����
			conn.setAutoCommit(false); // commit ���� ����

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		
		return conn;
	}

	// �����ε� ��� ����!
	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
