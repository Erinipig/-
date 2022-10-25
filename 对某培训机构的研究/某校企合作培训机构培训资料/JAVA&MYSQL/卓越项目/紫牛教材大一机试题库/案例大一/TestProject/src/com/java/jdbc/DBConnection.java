
package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//	������ݿ�����Ӻ͹ر�
	
//	1.�����������ݿ���Ҫ��4������
	private static final String driver = "com.mysql.jdbc.Driver";//����λ��
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf-8";//�������ݿ��·����jdbc:���ݿ�����://������ַ:�˿ں�/���ݿ�����?characterEncoding=utf-8
	private static final String user = "root";
	private static final String pwd = "12345678";
	
//	2.ʹ�þ�̬������������:Class.forName(����λ��);
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	3.��ȡ���ݿ����Ӷ��������������ݿ⣩���Ƿ�����ôд��ʹ��return����DriverManager.getConnection(url, user, pwd)
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);//���ݲ������Ӷ�Ӧ���ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//����ʧ��
	}
	
//	4.�ر����ݿⱻռ�õ���Դ��3����ʽ��������ResultSet rs, PreparedStatement ps, Connection con
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		if(rs!=null) {//��ռ��
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {//��ռ��
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {//��ռ��
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
