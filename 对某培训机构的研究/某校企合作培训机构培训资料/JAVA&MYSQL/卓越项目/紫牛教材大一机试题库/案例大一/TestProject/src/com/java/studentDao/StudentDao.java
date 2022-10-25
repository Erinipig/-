package com.java.studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.jdbc.DBConnection;
import com.java.model.Student;

public class StudentDao {
//	实现数据库的增删改查操作
	
//	1.添加数据
	public boolean Insert(Student stu) {
//		首先连接数据库
		Connection conn = DBConnection.getConn();//连接数据库
		//预编译sql语句
		String s = "insert into student values(null,?,?,?,?,?,Now())";//使用系统默认日期时间
		try {
			PreparedStatement ps = conn.prepareStatement(s);//对sql语句预编译：检测sql语句是否正确
//			如果预编译通过，就给sql语句得到每一个“?”设置值。
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			执行添加操作
			boolean result = ps.executeUpdate() > 0;//判断数据是否添加成功
//			关闭数据库连接过程中占用资源
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//添加失败
	}
	
//	2.修改（根据学生id进行修改）
	public boolean Update(Student stu) {
//		首先连接数据库
		Connection conn = DBConnection.getConn();//连接数据库
		//预编译sql语句
		String s = "update student set name=?,age=?,gender=?,height=?,classID=? where stuid=? ";//使用系统默认日期时间
		try {
			PreparedStatement ps = conn.prepareStatement(s);//对sql语句预编译：检测sql语句是否正确
//			如果预编译通过，就给sql语句得到每一个“?”设置值。
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			添加学生id值的设置
			ps.setInt(6, stu.getStuid());
			
//			执行修改操作
			boolean result = ps.executeUpdate() > 0;//判断数据是否修改成功
//			关闭数据库连接过程中占用资源
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//修改失败
	}
	
//	3.删除（根据学生id进行删除）
	public boolean Delete(int stuid) {
//		首先连接数据库
		Connection conn = DBConnection.getConn();//连接数据库
		//预编译sql语句
		String s = "delete from student where stuid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(s);//对sql语句预编译：检测sql语句是否正确
//			如果预编译通过，就给sql语句得到每一个“?”设置值。
//			添加学生id值的设置
			ps.setInt(1, stuid);
			
//			执行修改操作
			boolean result = ps.executeUpdate() > 0;//判断数据是否删除成功
//			关闭数据库连接过程中占用资源
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//删除失败
	}
	
	
//	4.查询（全查询/模糊查询、单条数据查询）
	public Vector<Vector<String>> queryAll(String keyword) {
//		首先连接数据库
		Connection conn = DBConnection.getConn();//连接数据库
		//预编译sql语句
		String s = "select * from student";//全查询
//		模糊查询
		if(keyword!=null) {
			s += " where name like '%" + keyword + "%'";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(s);
//			执行查询操作
			ResultSet rs = ps.executeQuery();//查询到了表中的所有数据（条数可变）
//			System.out.println(rs);
//			使用Vector可变长度的数组存储结果集
//			二维数组：[[],[],...]
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			while(rs.next()) {
//				定义内部Vector<String>用于存储从rs集合中获取到每一个元素
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				list.add(v);//将内部Vector添加到外部Vector
			}
//			关闭数据库连接过程中占用资源
			DBConnection.close(rs, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
//	单条数据查询
	public Student queryOne(int stuid) {
//		首先连接数据库
		Connection conn = DBConnection.getConn();//连接数据库
		//预编译sql语句
		String sql = "select * from student where stuid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stuid);
//			执行查询单个操作
			ResultSet rs = ps.executeQuery();//获取到的，某一条数据
			Student stu = new Student();
			while(rs.next()) {
				stu.setStuid(rs.getInt(1));;
				stu.setName(rs.getString(2));
				stu.setAge(rs.getInt(3));
				stu.setGender(rs.getString(4));
				stu.setHeight(rs.getDouble(5));
				stu.setClassID(rs.getInt(6));
				stu.setCreatetime(rs.getDate(7));
			}
			System.out.println(stu);
//			关闭数据库连接过程中占用资源
			DBConnection.close(rs, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return stu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
//	验证操作是否成功
	public static void main(String[] args) {
//		验证添加是否成功
//		StudentDao sd = new StudentDao();
////		要传入一个学生对象，所以创建学生对象
//		Student s = new Student();
////		给学生对象设置值：
//		s.setName("李寒寒");
//		s.setAge(99);
//		s.setGender("男");
//		s.setHeight(190.5);
//		s.setClassID(9);
//		if(sd.Insert(s)) {
//			System.out.println("添加成功");
//		}
//		else {
//			System.out.println("添加失败");
//		}
		
//		验证修改是否成功
//		StudentDao sd = new StudentDao();
//		Student s = new Student();
//		s.setStuid(30);
//		s.setName("张晓晓");
//		s.setAge(44);
//		s.setGender("女");
//		s.setHeight(140);
//		s.setClassID(3);
//		
//		if(sd.Update(s)) {
//			System.out.println("修改成功");
//		}
//		else {
//			System.out.println("修改失败");
//		}
		
//		检验删除是否成功
//		StudentDao sd = new StudentDao();
//		if(sd.Delete(28)) {
//			System.out.println("删除成功");
//		}
//		else {
//			System.out.println("删除失败");
//		}
		
//		测试全查询和模糊查询
//		StudentDao sd = new StudentDao();
//		System.out.println(sd.queryAll(null));//全查询
//		System.out.println(sd.queryAll("小"));//模糊查询
		
//		测试单个查询
//		StudentDao sd = new StudentDao();
//		System.out.println(sd.queryOne(17).getName());
	}
}
