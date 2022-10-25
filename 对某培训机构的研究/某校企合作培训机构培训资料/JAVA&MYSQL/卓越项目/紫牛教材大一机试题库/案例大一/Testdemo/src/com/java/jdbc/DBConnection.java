package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//	连接数据库和关闭数据
	
//	1.设置连接数据库需要的4个参数
	private static final String driver = "com.mysql.jdbc.Driver";//设置驱动位置
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf-8";//连接数据库的路径语法格式：jdbc:数据库类型://主机地址:端口号/数据库名称?characterEncoding=utf-8
	private static final String user = "root";//连接数据库的用户名
	private static final String pwd = "12345678";//密码
	
//	2.使用静态代码块加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	3.获取数据库连接对象：连接数据库使用
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);//连接数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//连接失败
	}
	
//	4.关闭连接数据库时占用的资源
	public static void close(ResultSet rs, PreparedStatement ps, Connection con ) {//ResultSet rs, PreparedStatement ps, Connection con
//		判断资源是否被占用，被占用则关闭
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
