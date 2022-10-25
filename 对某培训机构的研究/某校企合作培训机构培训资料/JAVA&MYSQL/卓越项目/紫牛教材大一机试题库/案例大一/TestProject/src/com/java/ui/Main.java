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
		lblNewLabel.setFont(new Font("����", Font.BOLD, 24));
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
//				ģ����ѯ
//				��ȡ�ı���������ؼ���
				String keyword = textField.getText();
				getAll(keyword);
			}
		});
		btnNewButton.setBounds(298, 73, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u5B66\u751F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				���ش���
				Insert frame = new Insert();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(398, 73, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u5B66\u751F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				��ȡ��ѡ�е�����
//				��ȡ��ѡ���к�
				int rows = table.getSelectedRow();
				if(rows == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ����");
					return;//��ֹ��������ִ��
				}
//				���ݱ�ѡ�е��л�ȡ��Ӧѧ��id
				int cols = Integer.valueOf((String)table.getValueAt(rows, 0));//ת����
				
//				StudentDao sd = new StudentDao();
//				sd.queryOne(cols);//��ȡ���˱�ѡ�е�����
//				����ȡ����������ʾ���޸Ĵ���
//				���ش���
				Update frame = new Update(cols);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(502, 73, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664\u5B66\u751F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				��ȡ��ѡ���е�ѧ��id
				int rows = table.getSelectedRow();
				if(rows==-1) {
					JOptionPane.showMessageDialog(null, "��ѡ����");
					return;//��ֹ����ִ��
				}
				int cols = Integer.valueOf((String)table.getValueAt(rows, 0));
				//ɾ������
				StudentDao sd = new StudentDao();
				boolean res = sd.Delete(cols);//����ѧ��id����ɾ��
				if(res) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					getAll(null);//���²�ѯ�������ݣ�ˢ�±����ݣ�
				}
				else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
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
//		1.�Ӻ�̨��ȡ���ص����ݣ�����ʾ����ǰtable��
		StudentDao sd =new StudentDao();
		Vector<Vector<String>> dates = sd.queryAll(keyword);
//		System.out.println(dates);
//		2.��������
		Vector<String> colsName = new Vector<String>();
		colsName.add("ѧ��id");
		colsName.add("����");
		colsName.add("����");
		colsName.add("�Ա�");
		colsName.add("���");
		colsName.add("�༶ID");
		colsName.add("����ʱ��");
		table = new JTable(dates,colsName);//dates������,colName����
		scrollPane.setViewportView(table);
	}
}
