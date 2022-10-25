package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField inputBox;
	private JTable table;

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
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel.setBounds(392, 34, 178, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(45, 102, 72, 15);
		contentPane.add(lblNewLabel_1);
		
		inputBox = new JTextField();
		inputBox.setBounds(126, 99, 260, 21);
		contentPane.add(inputBox);
		inputBox.setColumns(10);
		
		JButton queryBtn = new JButton("\u67E5\u8BE2");
		queryBtn.setBounds(402, 98, 93, 23);
		contentPane.add(queryBtn);
		
		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addBtn.setBounds(513, 98, 93, 23);
		contentPane.add(addBtn);
		
		JButton updateBtn = new JButton("\u4FEE\u6539");
		updateBtn.setBounds(629, 98, 93, 23);
		contentPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.setBounds(732, 98, 93, 23);
		contentPane.add(deleteBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 142, 780, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {//表数据---二维数组[[],[],...]，所以从后台获取到的数据也要转换成二维数组传递过来
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {//列名
				"id", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
