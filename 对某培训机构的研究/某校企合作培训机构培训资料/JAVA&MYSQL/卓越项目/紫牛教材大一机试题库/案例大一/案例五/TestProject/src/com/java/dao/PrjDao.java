package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.jdbc.DBConnection;
import com.java.model.Prj;

public class PrjDao {
//
	
//	查询
	public Vector<Vector<String>> chaxun() {
//		连接数据库
		Connection conn = DBConnection.getConn();
//		预编译sql语句
		String sql = "select * from tb_prj";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			执行sql语句实现添加功能
//			boolean res = ps.executeUpdate() > 0;
			ResultSet res = ps.executeQuery();//结果集合，想办法把数据显示到表格=》二维数组长度可变Vector
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			while(res.next()) {
				Vector<String> v = new Vector<String>();
				v.add(res.getString(1));
				v.add(res.getString(2));
				v.add(res.getString(3));
				v.add(res.getString(4));
				v.add(res.getString(5));
				list.add(v);
			}
			
			DBConnection.close(res, ps, conn);
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
//	添加
	public boolean add(Prj p) {
//		连接数据库
		Connection conn = DBConnection.getConn();
//		预编译sql语句
		String sql = "insert tb_prj values(null,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPrj_name());
			ps.setInt(2, p.getPrj_cycle());
			ps.setInt(3, p.getPrj_count());
			ps.setString(4, p.getPrj_manager());
//			执行sql语句实现添加功能
			boolean res = ps.executeUpdate() > 0;
			DBConnection.close(null, ps, conn);
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
//	删除
	public boolean shanchu(int id) {
//		连接数据库
		Connection conn = DBConnection.getConn();
//		预编译sql语句
		String sql = "delete from tb_prj where prj_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
//			执行sql语句实现删除功能
			boolean res = ps.executeUpdate() > 0;
			DBConnection.close(null, ps, conn);
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
