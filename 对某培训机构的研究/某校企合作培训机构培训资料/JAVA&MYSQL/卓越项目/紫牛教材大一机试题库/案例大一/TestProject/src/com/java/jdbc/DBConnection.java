
package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//	完成数据库的连接和关闭
	
//	1.设置连接数据库需要的4个参数
	private static final String driver = "com.mysql.jdbc.Driver";//驱动位置
	private static final String url = "jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf-8";//访问数据库的路径：jdbc:数据库类型://主机地址:端口号/数据库名称?characterEncoding=utf-8
	private static final String user = "root";
	private static final String pwd = "12345678";
	
//	2.使用静态代码块加载驱动:Class.forName(驱动位置);
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	3.获取数据库连接对象（用于连接数据库）：记方法怎么写，使用return返回DriverManager.getConnection(url, user, pwd)
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);//根据参数连接对应数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//连接失败
	}
	
//	4.关闭数据库被占用的资源（3个形式参数）：ResultSet rs, PreparedStatement ps, Connection con
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		if(rs!=null) {//被占用
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {//被占用
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {//被占用
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
