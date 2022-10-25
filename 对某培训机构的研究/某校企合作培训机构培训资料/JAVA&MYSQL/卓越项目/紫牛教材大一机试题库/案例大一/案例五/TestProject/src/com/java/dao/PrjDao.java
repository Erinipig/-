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
	
//	��ѯ
	public Vector<Vector<String>> chaxun() {
//		�������ݿ�
		Connection conn = DBConnection.getConn();
//		Ԥ����sql���
		String sql = "select * from tb_prj";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			ִ��sql���ʵ����ӹ���
//			boolean res = ps.executeUpdate() > 0;
			ResultSet res = ps.executeQuery();//������ϣ���취��������ʾ�����=����ά���鳤�ȿɱ�Vector
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
	
//	���
	public boolean add(Prj p) {
//		�������ݿ�
		Connection conn = DBConnection.getConn();
//		Ԥ����sql���
		String sql = "insert tb_prj values(null,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPrj_name());
			ps.setInt(2, p.getPrj_cycle());
			ps.setInt(3, p.getPrj_count());
			ps.setString(4, p.getPrj_manager());
//			ִ��sql���ʵ����ӹ���
			boolean res = ps.executeUpdate() > 0;
			DBConnection.close(null, ps, conn);
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
//	ɾ��
	public boolean shanchu(int id) {
//		�������ݿ�
		Connection conn = DBConnection.getConn();
//		Ԥ����sql���
		String sql = "delete from tb_prj where prj_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
//			ִ��sql���ʵ��ɾ������
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
