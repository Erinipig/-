package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u767B\u5F55\u754C\u9762");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 24));
		lblNewLabel.setBounds(338, 47, 146, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(160, 121, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(234, 118, 332, 21);
		contentPane.add(userName);
		userName.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(234, 178, 332, 21);
		contentPane.add(pwd);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1_1.setBounds(160, 181, 54, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JButton loginBtn = new JButton("\u767B\u5F55");
		loginBtn.setBounds(338, 279, 93, 23);
		contentPane.add(loginBtn);
	}
}
