package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.dao.PrjDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame frame = new ListFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListFrame() {
		setTitle("\u9879\u76EE\u7BA1\u7406\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		scrollPane.setBounds(10, 10, 643, 242);
		contentPane.add(scrollPane);
		
//		��ȡ��ѯ�����ݣ����󶨵������
		getDates();
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDates();
			}
		});
		btnNewButton.setBounds(166, 262, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ɾ�����ݲ���
				int row = table.getSelectedRow();//��ȡ��ѡ�е���
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������Ŀ��");
					return;
				}
				else {
					int n = JOptionPane.showConfirmDialog(null, "ȥ��ɾ������ƽ̨ϵͳ��Ŀ��", "ȷ����Ϣ", JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
						int id = Integer.valueOf((String)table.getValueAt(row, 0));
	//					����ɾ���ķ���
						PrjDao pd = new PrjDao();
						if(pd.shanchu(id)) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}
						else {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}
					}
					else {
						return;
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(274, 262, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u65B0\u589E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				���ش���
				AddDialog frame = new AddDialog();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(379, 262, 93, 23);
		contentPane.add(btnNewButton_2);
	}
	public void getDates() {
		PrjDao pd = new PrjDao();
		Vector<Vector<String>> list = pd.chaxun();
		Vector<String> colName = new Vector<String>();
		colName.add("���");
		colName.add("��Ŀ����");
		colName.add("��Ŀ����");
		colName.add("��������");
		colName.add("��Ŀ������");
		table = new JTable(list,colName);
		scrollPane.setViewportView(table);
	}
}
