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

public class Update extends JFrame {

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
				try {//加载窗体
					Update frame = new Update(4);
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
	public Update(int stuid) {
//		获取被选中行的数据
		StudentDao sd = new StudentDao();
		Student stu = sd.queryOne(stuid);
		

		setTitle("\u4FEE\u6539\u5B66\u751F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5B66\u751F");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel.setBounds(167, 33, 134, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(42, 79, 70, 20);
		contentPane.add(lblNewLabel_1);
		
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
		
//		将查询到单个数据的每项数据显示到对应文本框 ---------->
		userName = new JTextField(stu.getName());
		userName.setBounds(122, 80, 248, 21);
		contentPane.add(userName);
		userName.setColumns(10);
		
		String a = String.valueOf(stu.getAge());
		age = new JTextField(a);
		age.setColumns(10);
		age.setBounds(122, 109, 248, 21);
		contentPane.add(age);
		
		gender = new JTextField(stu.getGender());
		gender.setColumns(10);
		gender.setBounds(122, 139, 248, 21);
		contentPane.add(gender);
		
		String h = String.valueOf(stu.getHeight());
		height = new JTextField(h);
		height.setColumns(10);
		height.setBounds(122, 173, 248, 21);
		contentPane.add(height);
		
		String c = String.valueOf(stu.getClassID());
		classid = new JTextField(c);
		classid.setColumns(10);
		classid.setBounds(122, 206, 248, 21);
		contentPane.add(classid);
		
//		-----------------------------------------<
		
		JButton updateBtn = new JButton("\u4FEE\u6539\u5B66\u751F");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				重新获取修改后的数据，把修改后的数据调用update方法传值
//				System.out.println(userName.getText());
//				System.out.println(Integer.valueOf(age.getText()));
//				System.out.println(gender.getText());
//				System.out.println(Double.valueOf(height.getText()));
//				System.out.println(Integer.valueOf(classid.getText()));
//				调用修改的方法完成修改
				StudentDao s =new StudentDao();
				Student stu = new Student();
				stu.setStuid(stuid);//根据学生id进行修改，所有要设置学生id
				stu.setName(userName.getText());
				stu.setAge(Integer.valueOf(age.getText()));
				stu.setGender(gender.getText());
				stu.setHeight(Double.valueOf(height.getText()));
				stu.setClassID(Integer.valueOf(classid.getText()));
				boolean res = s.Update(stu);
//				判断是否修改成功，并关闭窗口
				if(res) {
					JOptionPane.showMessageDialog(null, "修改成功");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
				
			}
		});
		updateBtn.setBounds(122, 252, 93, 23);
		contentPane.add(updateBtn);
		
		JButton closeBtn = new JButton("\u5173\u95ED");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeBtn.setBounds(253, 252, 93, 23);
		contentPane.add(closeBtn);
	}
}
