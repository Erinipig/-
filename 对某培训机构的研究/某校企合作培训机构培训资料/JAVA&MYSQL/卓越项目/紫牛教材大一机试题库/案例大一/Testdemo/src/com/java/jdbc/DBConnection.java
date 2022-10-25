package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//	�������ݿ�͹ر�����
	
//	1.�����������ݿ���Ҫ��4������
	private static final String driver = "com.mysql.jdbc.Driver";//��������λ��
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf-8";//�������ݿ��·���﷨��ʽ��jdbc:���ݿ�����://������ַ:�˿ں�/���ݿ�����?characterEncoding=utf-8
	private static final String user = "root";//�������ݿ���û���
	private static final String pwd = "12345678";//����
	
//	2.ʹ�þ�̬������������
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	3.��ȡ���ݿ����Ӷ����������ݿ�ʹ��
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//����ʧ��
	}
	
//	4.�ر��������ݿ�ʱռ�õ���Դ
	public static void close(ResultSet rs, PreparedStatement ps, Connection con ) {//ResultSet rs, PreparedStatement ps, Connection con
//		�ж���Դ�Ƿ�ռ�ã���ռ����ر�
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
}
