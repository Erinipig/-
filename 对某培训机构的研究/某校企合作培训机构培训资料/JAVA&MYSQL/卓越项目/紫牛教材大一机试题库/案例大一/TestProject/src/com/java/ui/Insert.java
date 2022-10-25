package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.model.Student;
import com.java.studentDao.StudentDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField age;
	private JTextField gender;
	private JTextField height;
	private JTextField classid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					加载窗体
					Insert frame = new Insert();
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
	public Insert() {
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u5B66\u751F");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel.setBounds(167, 33, 134, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(42, 79, 70, 20);
		contentPane.add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(122, 80, 248, 21);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		lblNewLabel_1_1.setBounds(42, 109, 70, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_1_2.setBounds(42, 139, 70, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5B66\u751F\u8EAB\u9AD8\uFF1A");
		lblNewLabel_1_3.setBounds(42, 173, 70, 20);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u73ED\u7EA7ID\uFF1A");
		lblNewLabel_1_4.setBounds(42, 206, 70, 20);
		contentPane.add(lblNewLabel_1_4);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(122, 109, 248, 21);
		contentPane.add(age);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(122, 139, 248, 21);
		contentPane.add(gender);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(122, 173, 248, 21);
		contentPane.add(height);
		
		classid = new JTextField();
		classid.setColumns(10);
		classid.setBounds(122, 206, 248, 21);
		contentPane.add(classid);
		
		JButton addBtn = new JButton("\u6DFB\u52A0\u5B66\u751F");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取所有的文本框内容
//				userName.getText();
//				age.getText();
//				gender.getText();
//				height.getText();
//				classid.getText();
				
//				调用添加数据的方法
				StudentDao sd = new StudentDao();
				Student stu = new Student();
				stu.setName(userName.getText());
				int a = Integer.valueOf(age.getText());
				stu.setAge(a);
				stu.setGender(gender.getText());
				double h = Double.valueOf(height.getText());
				stu.setHeight(h);
				int c = Integer.valueOf(classid.getText());
				stu.setClassID(c);
//				调用方法传入学生类对象
//				sd.Insert(stu);
				if(sd.Insert(stu)){
					JOptionPane.showMessageDialog(null, "添加成功");
					dispose();
//					刷新列表数据
					Main m = new Main();
					m.getAll(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "添加失败");
				}
				
			}
		});
		addBtn.setBounds(122, 252, 93, 23);
		contentPane.add(addBtn);
		
		JButton closeBtn = new JButton("\u5173\u95ED");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				关闭窗体
				dispose();
			}
		});
		closeBtn.setBounds(253, 252, 93, 23);
		contentPane.add(closeBtn);
	}
}
