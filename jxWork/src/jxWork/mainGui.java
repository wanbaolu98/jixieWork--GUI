package jxWork;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class mainGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnX,btnY,btnZ,button,button_1;
	private JTextArea textArea,textArea_1,textArea_2;
	
	private jixieAction action;
    private FileDialog openDia, saveDia;// 定义“打开、保存”对话框

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGui frame = new mainGui();
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
	public mainGui() {
		//注册按钮监听器
		action = new jixieAction();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 635);
		contentPane = new JPanel(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblMachineTravelError = new JLabel("Machine  Travel  Error");
		lblMachineTravelError.setForeground(Color.BLUE);
		lblMachineTravelError.setHorizontalAlignment(SwingConstants.CENTER);
		lblMachineTravelError.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPane.add(lblMachineTravelError, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6570\u636E\u5F55\u5165");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(14, 13, 95, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5782\u76F4\u8BEF\u5DEE\u8F93\u5165\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(14, 55, 122, 18);
		panel.add(label_1);
		
		JLabel lblSxy = new JLabel("Sxy\uFF1A");
		lblSxy.setFont(new Font("宋体", Font.PLAIN, 15));
		lblSxy.setBounds(36, 91, 39, 18);
		panel.add(lblSxy);
		
		textField = new JTextField();
		textField.setBounds(70, 88, 39, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSxz = new JLabel("Sxz\uFF1A");
		lblSxz.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblSxz.setBounds(118, 91, 39, 18);
		panel.add(lblSxz);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 88, 39, 24);
		panel.add(textField_1);
		
		JLabel lblSyz = new JLabel("Syz\uFF1A");
		lblSyz.setFont(new Font("宋体", Font.PLAIN, 15));
		lblSyz.setBounds(196, 91, 39, 18);
		panel.add(lblSyz);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 88, 39, 24);
		panel.add(textField_2);
		
		JLabel label_2 = new JLabel("\u6587\u4EF6\u5BFC\u5165");
		label_2.setBounds(14, 122, 72, 18);
		panel.add(label_2);
		
		//定义三个打开文件的按钮
		btnX = new JButton("X\u6587\u4EF6");
		btnX.setBounds(36, 141, 73, 27);
		btnX.addActionListener(action);
		panel.add(btnX);
		
		btnY = new JButton("Y\u6587\u4EF6");
		btnY.setBounds(36, 174, 73, 27);
		btnY.addActionListener(action);
		panel.add(btnY);
		
		btnZ = new JButton("Z\u6587\u4EF6");
		btnZ.setBounds(36, 208, 73, 27);
		btnZ.addActionListener(action);
		panel.add(btnZ);
		
		JLabel label_3 = new JLabel("\u8BA1\u7B97\u7ED3\u679C");
		label_3.setBounds(14, 258, 72, 18);
		panel.add(label_3);
		
		button = new JButton("\u8BA1\u7B97");
		button.setBounds(70, 289, 66, 27);
		button.addActionListener(action);
		panel.add(button);
		
		button_1 = new JButton("\u5173\u95ED");
		button_1.setBounds(151, 289, 66, 27);
		panel.add(button_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		textArea.setBounds(118, 141, 150, 27);
		panel.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textArea_1.setEditable(false);
		textArea_1.setBounds(118, 174, 150, 27);
		panel.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textArea_2.setEditable(false);
		textArea_2.setBounds(118, 208, 150, 27);
		panel.add(textArea_2);
		
		openDia = new FileDialog(mainGui.this, "打开");
	}
	
	class jixieAction implements ActionListener
	{
		private String mulu,name;
		private double[][] x;
		public void readExcle(JTextArea text,int pand) 
		{
			openDia.setVisible(true);
			mulu = openDia.getDirectory();
			name = openDia.getFile();
			System.out.println(mulu+name);
			text.append(name);
			if(pand==1) 
			{
				Model.read(mulu,name,1);
			}else if(pand==2) 
			{
				Model.read(mulu,name,2);
			}else 
			{
				Model.read(mulu,name,3);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnX) 
			{
				readExcle(textArea,1);
			}else if(e.getSource()==btnY) 
			{
				readExcle(textArea_1,2);
			}else if(e.getSource()==btnZ) 
			{
				readExcle(textArea_2,3);
			}else if(e.getSource()==button) 
			{
				Model.jisuan();
			}
		}
		
	}
}
