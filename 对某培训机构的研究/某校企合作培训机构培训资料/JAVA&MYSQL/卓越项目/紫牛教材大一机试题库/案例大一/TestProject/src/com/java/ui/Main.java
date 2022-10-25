package com.java.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.studentDao.StudentDao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406");
		lblNewLabel.setFont(new Font("锟斤拷锟斤拷", Font.BOLD, 24));
		lblNewLabel.setBounds(329, 30, 114, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(10, 77, 73, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(93, 74, 195, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				模糊查询
//				获取文本框的搜索关键字
				String keyword = textField.getText();
				getAll(keyword);
			}
		});
		btnNewButton.setBounds(298, 73, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u5B66\u751F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				加载窗体
				Insert frame = new Insert();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(398, 73, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u5B66\u751F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取被选中的数据
//				获取被选中行号
				int rows = table.getSelectedRow();
				if(rows == -1) {
					JOptionPane.showMessageDialog(null, "请选择行");
					return;//阻止继续往下执行
				}
//				根据被选中的行获取对应学生id
				int cols = Integer.valueOf((String)table.getValueAt(rows, 0));//转两次
				
//				StudentDao sd = new StudentDao();
//				sd.queryOne(cols);//获取到了被选中的数据
//				将获取到的数据显示到修改窗体
//				加载窗体
				Update frame = new Update(cols);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(502, 73, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664\u5B66\u751F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取被选中行的学生id
				int rows = table.getSelectedRow();
				if(rows==-1) {
					JOptionPane.showMessageDialog(null, "请选择行");
					return;//终止往下执行
				}
				int cols = Integer.valueOf((String)table.getValueAt(rows, 0));
				//删除操作
				StudentDao sd = new StudentDao();
				boolean res = sd.Delete(cols);//根据学生id进行删除
				if(res) {
					JOptionPane.showMessageDialog(null, "删除成功");
					getAll(null);//重新查询所有数据（刷新表数据）
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}
		});
		btnNewButton_3.setBounds(605, 73, 93, 23);
		contentPane.add(btnNewButton_3);
		
		
		scrollPane.setBounds(10, 122, 708, 241);
		contentPane.add(scrollPane);
		
		getAll(null);

	}
	public void getAll(String keyword) {
//		1.从后台获取返回的数据，并显示到当前table中
		StudentDao sd =new StudentDao();
		Vector<Vector<String>> dates = sd.queryAll(keyword);
//		System.out.println(dates);
//		2.定义列名
		Vector<String> colsName = new Vector<String>();
		colsName.add("学生id");
		colsName.add("姓名");
		colsName.add("年龄");
		colsName.add("性别");
		colsName.add("身高");
		colsName.add("班级ID");
		colsName.add("创建时间");
		table = new JTable(dates,colsName);//dates表数据,colName列名
		scrollPane.setViewportView(table);
	}
}
