package com.java.studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.java.jdbc.DBConnection;
import com.java.model.Student;

public class StudentDao {
//	ʵ�����ݿ����ɾ�Ĳ����
	
//	1.�������
	public boolean Insert(Student stu) {
//		�����������ݿ�
		Connection conn = DBConnection.getConn();//�������ݿ�
		//Ԥ����sql���
		String s = "insert into student values(null,?,?,?,?,?,Now())";//ʹ��ϵͳĬ������ʱ��
		try {
			PreparedStatement ps = conn.prepareStatement(s);//��sql���Ԥ���룺���sql����Ƿ���ȷ
//			���Ԥ����ͨ�����͸�sql���õ�ÿһ����?������ֵ��
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			ִ����Ӳ���
			boolean result = ps.executeUpdate() > 0;//�ж������Ƿ���ӳɹ�
//			�ر����ݿ����ӹ�����ռ����Դ
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//���ʧ��
	}
	
//	2.�޸ģ�����ѧ��id�����޸ģ�
	public boolean Update(Student stu) {
//		�����������ݿ�
		Connection conn = DBConnection.getConn();//�������ݿ�
		//Ԥ����sql���
		String s = "update student set name=?,age=?,gender=?,height=?,classID=? where stuid=? ";//ʹ��ϵͳĬ������ʱ��
		try {
			PreparedStatement ps = conn.prepareStatement(s);//��sql���Ԥ���룺���sql����Ƿ���ȷ
//			���Ԥ����ͨ�����͸�sql���õ�ÿһ����?������ֵ��
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getGender());
			ps.setDouble(4, stu.getHeight());
			ps.setInt(5, stu.getClassID());
//			���ѧ��idֵ������
			ps.setInt(6, stu.getStuid());
			
//			ִ���޸Ĳ���
			boolean result = ps.executeUpdate() > 0;//�ж������Ƿ��޸ĳɹ�
//			�ر����ݿ����ӹ�����ռ����Դ
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//�޸�ʧ��
	}
	
//	3.ɾ��������ѧ��id����ɾ����
	public boolean Delete(int stuid) {
//		�����������ݿ�
		Connection conn = DBConnection.getConn();//�������ݿ�
		//Ԥ����sql���
		String s = "delete from student where stuid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(s);//��sql���Ԥ���룺���sql����Ƿ���ȷ
//			���Ԥ����ͨ�����͸�sql���õ�ÿһ����?������ֵ��
//			���ѧ��idֵ������
			ps.setInt(1, stuid);
			
//			ִ���޸Ĳ���
			boolean result = ps.executeUpdate() > 0;//�ж������Ƿ�ɾ���ɹ�
//			�ر����ݿ����ӹ�����ռ����Դ
			DBConnection.close(null, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;//ɾ��ʧ��
	}
	
	
//	4.��ѯ��ȫ��ѯ/ģ����ѯ���������ݲ�ѯ��
	public Vector<Vector<String>> queryAll(String keyword) {
//		�����������ݿ�
		Connection conn = DBConnection.getConn();//�������ݿ�
		//Ԥ����sql���
		String s = "select * from student";//ȫ��ѯ
//		ģ����ѯ
		if(keyword!=null) {
			s += " where name like '%" + keyword + "%'";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(s);
//			ִ�в�ѯ����
			ResultSet rs = ps.executeQuery();//��ѯ���˱��е��������ݣ������ɱ䣩
//			System.out.println(rs);
//			ʹ��Vector�ɱ䳤�ȵ�����洢�����
//			��ά���飺[[],[],...]
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			while(rs.next()) {
//				�����ڲ�Vector<String>���ڴ洢��rs�����л�ȡ��ÿһ��Ԫ��
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				list.add(v);//���ڲ�Vector��ӵ��ⲿVector
			}
//			�ر����ݿ����ӹ�����ռ����Դ
			DBConnection.close(rs, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
//	�������ݲ�ѯ
	public Student queryOne(int stuid) {
//		�����������ݿ�
		Connection conn = DBConnection.getConn();//�������ݿ�
		//Ԥ����sql���
		String sql = "select * from student where stuid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stuid);
//			ִ�в�ѯ��������
			ResultSet rs = ps.executeQuery();//��ȡ���ģ�ĳһ������
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
//			�ر����ݿ����ӹ�����ռ����Դ
			DBConnection.close(rs, ps, conn);//ResultSet rs, PreparedStatement ps, Connection con
			return stu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
//	��֤�����Ƿ�ɹ�
	public static void main(String[] args) {
//		��֤����Ƿ�ɹ�
//		StudentDao sd = new StudentDao();
////		Ҫ����һ��ѧ���������Դ���ѧ������
//		Student s = new Student();
////		��ѧ����������ֵ��
//		s.setName("���");
//		s.setAge(99);
//		s.setGender("��");
//		s.setHeight(190.5);
//		s.setClassID(9);
//		if(sd.Insert(s)) {
//			System.out.println("��ӳɹ�");
//		}
//		else {
//			System.out.println("���ʧ��");
//		}
		
//		��֤�޸��Ƿ�ɹ�
//		StudentDao sd = new StudentDao();
//		Student s = new Student();
//		s.setStuid(30);
//		s.setName("������");
//		s.setAge(44);
//		s.setGender("Ů");
//		s.setHeight(140);
//		s.setClassID(3);
//		
//		if(sd.Update(s)) {
//			System.out.println("�޸ĳɹ�");
//		}
//		else {
//			System.out.println("�޸�ʧ��");
//		}
		
//		����ɾ���Ƿ�ɹ�
//		StudentDao sd = new StudentDao();
//		if(sd.Delete(28)) {
//			System.out.println("ɾ���ɹ�");
//		}
//		else {
//			System.out.println("ɾ��ʧ��");
//		}
		
//		����ȫ��ѯ��ģ����ѯ
//		StudentDao sd = new StudentDao();
//		System.out.println(sd.queryAll(null));//ȫ��ѯ
//		System.out.println(sd.queryAll("С"));//ģ����ѯ
		
//		���Ե�����ѯ
//		StudentDao sd = new StudentDao();
//		System.out.println(sd.queryOne(17).getName());
	}
}
