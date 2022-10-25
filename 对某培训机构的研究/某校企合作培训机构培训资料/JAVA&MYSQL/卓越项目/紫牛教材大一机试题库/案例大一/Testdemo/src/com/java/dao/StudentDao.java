package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.jdbc.DBConnection;
import com.java.model.Student;

public class StudentDao {
//	��ɾ��Ĳ���
	
//	1.���
	public boolean insert(Student stu) {
//		���������ݿ�
		Connection con = DBConnection.getConn();
//		Ԥ����sql��䣬Ĭ��ʹ��ϵͳ����ʱ��
		String s = "insert into student values(null,?,?,?,?,?,Now())";
		try {
			PreparedStatement ps = con.prepareStatement(s);//���sql�Ƿ���ȷ
//			��װ����
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			ִ����Ӳ���
			boolean result = ps.executeUpdate() > 0;//�ж��Ƿ������ݸ���
//			�ر����ݿ����ӹ�����սռ�õ���Դ
			DBConnection.close(null, ps, con);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//����ʧ��
		
	}
	
//	2.�޸�
	public boolean update(Student stu) {
//		���������ݿ�
		Connection con = DBConnection.getConn();
//		Ԥ����sql��䣬Ĭ��ʹ��ϵͳ����ʱ��
		String s = "update student set name=?,age=?,gender=?,height=?,classID=? where stuid=?";
		try {
			PreparedStatement ps = con.prepareStatement(s);//���sql�Ƿ���ȷ
//			��װ����
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			���stuid�ķ�װ
			ps.setInt(6, stu.getStuid());
			
//			ִ���޸Ĳ���
			boolean result = ps.executeUpdate() > 0;//�ж��Ƿ������ݸ���
//			�ر����ݿ����ӹ�����սռ�õ���Դ
			DBConnection.close(null, ps, con);
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//����ʧ��
	}
	
//	3.ɾ��
	public boolean delete(int stuid) {
//		���������ݿ�
		Connection con = DBConnection.getConn();
//		Ԥ����sql��䣬Ĭ��ʹ��ϵͳ����ʱ��
		String s = "delete from student where stuid=?";
		try {
			PreparedStatement ps = con.prepareStatement(s);//���sql�Ƿ���ȷ
//			��װ����
			ps.setInt(1, stuid);
			
//			ִ���޸Ĳ���
			boolean result = ps.executeUpdate() > 0;//�ж��Ƿ������ݸ���
//			�ر����ݿ����ӹ�����սռ�õ���Դ
			DBConnection.close(null, ps, con);
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//����ʧ��
	}

//	4.��ѯ��ȫ��ѯ/ģ����ѯ��
	public Vector<Vector<String>> queryAll(String keyword) {
//		���������ݿ�
		Connection con = DBConnection.getConn();
//		Ԥ����sql��䣬Ĭ��ʹ��ϵͳ����ʱ��
		String s = "select * from student";
		if(keyword!=null) {
//			ģ����ѯ
			s += " where name like '%" + keyword + "%'";
		}
		try {
			PreparedStatement ps = con.prepareStatement(s);//���sql�Ƿ���ȷ
//			ִ�в�ѯ����
			ResultSet rs = ps.executeQuery();//���������ѯ�����ݶ��ڸü����У�
//			�������װ���ɶ�ά���ȿɱ����飺Vector
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			while(rs.next()) {//ѭ��������ȡ�������ÿһ������
				Vector<String> v = new Vector<String>();//�ڲ�����
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				list.add(v);
			}
//			�ر����ݿ����ӹ�����սռ�õ���Դ
			DBConnection.close(rs, ps, con);
			return list;//�����б�����
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//����ʧ��
	}
	
//	5.������ѯ
	public Student queryAll(int stuid) {
//		���������ݿ�
		Connection con = DBConnection.getConn();
//		Ԥ����sql��䣬Ĭ��ʹ��ϵͳ����ʱ��
		String s = "select * from student where stuid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(s);//���sql�Ƿ���ȷ
//			��װ����
			ps.setInt(1, stuid);
//			ִ�в�ѯ����
			ResultSet rs = ps.executeQuery();//���������ѯ�����ݶ��ڸü����У�
			
//			�������װ���ɶ�ά���ȿɱ����飺Vector
			Student stu = new Student();
					
			while(rs.next()) {//ѭ��������ȡ�������ÿһ������
				stu.setStuid(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setAge(rs.getInt(3));
				stu.setGender(rs.getString(4));
				stu.setHeight(rs.getDouble(5));
				stu.setClassID(rs.getInt(6));
				stu.setCreatetime(rs.getDate(7));
			}
//			�ر����ݿ����ӹ�����սռ�õ���Դ
			DBConnection.close(rs, ps, con);
			return stu;//�����б�����
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//����ʧ��
	}
	
	
	//���鹦���Ƿ�ɹ�
	public static void main(String[] args) {
//		������ӹ���
//		StudentDao sd = new StudentDao();
//		Student stu = new Student();
////		��stu��ֵ
//		stu.setName("�����");
//		stu.setAge(18);
//		stu.setGender("Ů");
//		stu.setHeight(180);
//		stu.setClassID(5);
//		if(sd.insert(stu)) {
//			System.out.println("��ӳɹ�");
//		}
//		else {
//			System.out.println("���ʧ��");
//		}
		
//		�����޸Ĺ���
		StudentDao sd = new StudentDao();
//		Student stu = new Student();
////		��stu��ֵ
//		stu.setName("����");
//		stu.setAge(58);
//		stu.setGender("Ů");
//		stu.setHeight(160);
//		stu.setClassID(3);
//		stu.setStuid(40);
//		if(sd.update(stu)) {
//			System.out.println("�޸ĳɹ�");
//		}
//		else {
//			System.out.println("�޸�ʧ��");
//		}
		
//		����ɾ������
//		if(sd.delete(34)) {
//			System.out.println("ɾ���ɹ�");
//		}
//		else {
//			System.out.println("ɾ��ʧ��");
//		}
		
//		���Բ�ѯ����
//		Vector<Vector<String>> v = sd.queryAll(null);//ȫ��ѯ
//		System.out.println(v);
//		System.out.println(sd.queryAll("��"));
		
//		���Ե�����ѯ����
		System.out.println(sd.queryAll(40).getName());
	}
}
