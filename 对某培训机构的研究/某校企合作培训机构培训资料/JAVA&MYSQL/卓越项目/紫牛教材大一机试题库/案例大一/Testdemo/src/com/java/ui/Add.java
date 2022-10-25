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

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u5B66\u751F");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 24));
		lblNewLabel.setBounds(198, 29, 139, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(57, 90, 67, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(134, 87, 246, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 131, 246, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 179, 246, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 217, 246, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(134, 258, 246, 21);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		lblNewLabel_1_1.setBounds(57, 134, 67, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_1_2.setBounds(57, 182, 67, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5B66\u751F\u8EAB\u9AD8\uFF1A");
		lblNewLabel_1_3.setBounds(57, 220, 67, 15);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u73ED\u7EA7ID\uFF1A");
		lblNewLabel_1_4.setBounds(70, 261, 54, 15);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBounds(134, 303, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5173\u95ED");
		btnNewButton_1.setBounds(287, 303, 93, 23);
		contentPane.add(btnNewButton_1);
	}

}
