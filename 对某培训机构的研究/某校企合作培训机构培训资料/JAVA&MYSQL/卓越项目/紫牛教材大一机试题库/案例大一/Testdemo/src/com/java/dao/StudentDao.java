package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.jdbc.DBConnection;
import com.java.model.Student;

public class StudentDao {
//	增删查改操作
	
//	1.添加
	public boolean insert(Student stu) {
//		先连接数据库
		Connection con = DBConnection.getConn();
//		预编译sql语句，默认使用系统日期时间
		String s = "insert into student values(null,?,?,?,?,?,Now())";
		try {
			PreparedStatement ps = con.prepareStatement(s);//检查sql是否正确
//			封装参数
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			执行添加操作
			boolean result = ps.executeUpdate() > 0;//判断是否有数据更新
//			关闭数据库连接过程中战占用的资源
			DBConnection.close(null, ps, con);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//操作失败
		
	}
	
//	2.修改
	public boolean update(Student stu) {
//		先连接数据库
		Connection con = DBConnection.getConn();
//		预编译sql语句，默认使用系统日期时间
		String s = "update student set name=?,age=?,gender=?,height=?,classID=? where stuid=?";
		try {
			PreparedStatement ps = con.prepareStatement(s);//检查sql是否正确
//			封装参数
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			添加stuid的封装
			ps.setInt(6, stu.getStuid());
			
//			执行修改操作
			boolean result = ps.executeUpdate() > 0;//判断是否有数据更新
//			关闭数据库连接过程中战占用的资源
			DBConnection.close(null, ps, con);
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//操作失败
	}
	
//	3.删除
	public boolean delete(int stuid) {
//		先连接数据库
		Connection con = DBConnection.getConn();
//		预编译sql语句，默认使用系统日期时间
		String s = "delete from student where stuid=?";
		try {
			PreparedStatement ps = con.prepareStatement(s);//检查sql是否正确
//			封装参数
			ps.setInt(1, stuid);
			
//			执行修改操作
			boolean result = ps.executeUpdate() > 0;//判断是否有数据更新
//			关闭数据库连接过程中战占用的资源
			DBConnection.close(null, ps, con);
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//操作失败
	}

//	4.查询（全查询/模糊查询）
	public Vector<Vector<String>> queryAll(String keyword) {
//		先连接数据库
		Connection con = DBConnection.getConn();
//		预编译sql语句，默认使用系统日期时间
		String s = "select * from student";
		if(keyword!=null) {
//			模糊查询
			s += " where name like '%" + keyword + "%'";
		}
		try {
			PreparedStatement ps = con.prepareStatement(s);//检查sql是否正确
//			执行查询操作
			ResultSet rs = ps.executeQuery();//结果集（查询的数据都在该集合中）
//			将结果集装换成二维长度可变数组：Vector
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			while(rs.next()) {//循环遍历获取结果集的每一条数据
				Vector<String> v = new Vector<String>();//内部数组
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				list.add(v);
			}
//			关闭数据库连接过程中战占用的资源
			DBConnection.close(rs, ps, con);
			return list;//返回列表数据
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//操作失败
	}
	
//	5.单个查询
	public Student queryAll(int stuid) {
//		先连接数据库
		Connection con = DBConnection.getConn();
//		预编译sql语句，默认使用系统日期时间
		String s = "select * from student where stuid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(s);//检查sql是否正确
//			封装参数
			ps.setInt(1, stuid);
//			执行查询操作
			ResultSet rs = ps.executeQuery();//结果集（查询的数据都在该集合中）
			
//			将结果集装换成二维长度可变数组：Vector
			Student stu = new Student();
					
			while(rs.next()) {//循环遍历获取结果集的每一条数据
				stu.setStuid(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setAge(rs.getInt(3));
				stu.setGender(rs.getString(4));
				stu.setHeight(rs.getDouble(5));
				stu.setClassID(rs.getInt(6));
				stu.setCreatetime(rs.getDate(7));
			}
//			关闭数据库连接过程中战占用的资源
			DBConnection.close(rs, ps, con);
			return stu;//返回列表数据
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//操作失败
	}
	
	
	//检验功能是否成功
	public static void main(String[] args) {
//		测试添加功能
//		StudentDao sd = new StudentDao();
//		Student stu = new Student();
////		给stu赋值
//		stu.setName("刘亦菲");
//		stu.setAge(18);
//		stu.setGender("女");
//		stu.setHeight(180);
//		stu.setClassID(5);
//		if(sd.insert(stu)) {
//			System.out.println("添加成功");
//		}
//		else {
//			System.out.println("添加失败");
//		}
		
//		测试修改功能
		StudentDao sd = new StudentDao();
//		Student stu = new Student();
////		给stu赋值
//		stu.setName("李彬彬");
//		stu.setAge(58);
//		stu.setGender("女");
//		stu.setHeight(160);
//		stu.setClassID(3);
//		stu.setStuid(40);
//		if(sd.update(stu)) {
//			System.out.println("修改成功");
//		}
//		else {
//			System.out.println("修改失败");
//		}
		
//		测试删除功能
//		if(sd.delete(34)) {
//			System.out.println("删除成功");
//		}
//		else {
//			System.out.println("删除失败");
//		}
		
//		测试查询功能
//		Vector<Vector<String>> v = sd.queryAll(null);//全查询
//		System.out.println(v);
//		System.out.println(sd.queryAll("飞"));
		
//		测试单个查询功能
		System.out.println(sd.queryAll(40).getName());
	}
}
