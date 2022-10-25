package com.java.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.PrjDao;
import com.java.model.Prj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDialog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDialog frame = new AddDialog();
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
	public AddDialog() {
		setTitle("\u65B0\u589E\u9879\u76EE\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setBounds(52, 24, 75, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(137, 27, 201, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u5468\u671F\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_1.setBounds(52, 70, 75, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u53C2\u4E0E\u4EBA\u6570\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_2.setBounds(52, 114, 75, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u9879\u76EE\u8D1F\u8D23\u4EBA\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_3.setBounds(52, 154, 75, 26);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 73, 84, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 117, 84, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 157, 145, 21);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(331, 228, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取四个输入框内容进行非空验证
//				textField.getText()
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入完整信息！");
					return;
				}
				else {
//					调用添加方法
					PrjDao pd = new PrjDao();
					Prj p = new Prj();
					p.setPrj_name(textField.getText());
					p.setPrj_cycle(Integer.valueOf(textField_1.getText()));
					p.setPrj_count(Integer.valueOf(textField_2.getText()));
					p.setPrj_manager(textField_3.getText());
					if(pd.add(p)) {
						JOptionPane.showMessageDialog(null, "添加成功！");
						dispose();//关闭当前窗体
					}
					else {
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				}
			}
		});
		btnNewButton_1.setBounds(228, 228, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
