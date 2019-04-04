package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Element;
import javax.swing.text.TableView;
import javax.swing.text.TableView.TableCell;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import control.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import model.algorithm;
import model.tableModel;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

public class newGui extends JFrame 
{
	private JTable table,table1,table2;
	private JTextField textField_2,textField,textField_1,textField_3, textField_4,textField_5;
    private FileDialog openDia, saveDia;// 定义“打开、保存”对话框
    private jixieAction action;
    private JButton btnBrsowfe,button_1,button;
    private JPanel panel,panel_1;
    private JRbutton jrbutton;
    private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
    private myMouse MyMouse;
    private tableModel tabmodel1,tabmodel2,tabmodel3;
    private JButton btnNewButton;
    private JMenuItem mntmNewMenuItem_1,mntmNewMenuItem_2,mntmNewMenuItem_3,mntmNewMenuItem_4;
    private JLabel lblSxy,lblSxz,lblSyz;
    private JLabel lblNewLabel_1;
    private JLabel label_4;
    private JTextField textField_6;
    private JLabel label_5;
    private JTextField textField_7;
    private JLabel label_6;
    private JTextField textField_8;
    private JButton button_2;
    private Model excelMode;
    private double[][] outDatax,outDatay,outDataz;
	private List<double[]> result;
	private TextArea textArea;
	private JMenu menu;
	private JMenu menu_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGui frame = new newGui();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Model writeClass = new Model();
//					writeClass.read("C:\\Users\\yao\\Desktop\\都好\\计算结果\\计算结果.xlsx");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newGui() {
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Exception e1) {
		    e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		//设置窗口格式
		setBounds(100, 50, 1100,900);
		//设置窗口全屏显示
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//注册按钮监听器
		action = new jixieAction();
		//注册单选框监听
		jrbutton=new JRbutton();
		//定义鼠标监听器
		MyMouse = new myMouse();
		/**
		 * 创建菜单栏
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(238,241,250));
		setJMenuBar(menuBar);
		/**
		 * 往菜单栏添加菜单
		 */
		JMenu mnNewMenu = new JMenu("文件");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		/**
		 * 往菜单中添加相应的属性
		 */
		mntmNewMenuItem_1 = new JMenuItem("新建   ");
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 17));
		mntmNewMenuItem_1.addActionListener(action);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("打开");
		mntmNewMenuItem_2.addActionListener(action);
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("保存");
		mntmNewMenuItem_3.addActionListener(action);
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("另存为");
		mntmNewMenuItem_4.addActionListener(action);
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.PLAIN, 17));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		/**
		 * 第三个菜单，不添加选择，将菜单栏一直显示为选中
		 */
		JMenu mnNewMenu_2 = new JMenu("数据输入");
		mnNewMenu_2.setFont(new Font("宋体", Font.PLAIN, 17));
		mnNewMenu_2.setArmed(true);//菜单栏显示一直选中
		menuBar.add(mnNewMenu_2);
		
		menu = new JMenu("移动误差");
		menu.setFont(new Font("宋体", Font.PLAIN, 17));
		menu.setArmed(true);
		menuBar.add(menu);
		
		menu_1 = new JMenu("转角误差");
		menu_1.setFont(new Font("宋体", Font.PLAIN, 17));
		menu_1.setArmed(true);
		menuBar.add(menu_1);
		
		/**
		 * 在页面上部添加计算按钮以及三个数据的输入框
		 */
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(548, 817, 10, 10);
		panel_3.setBackground(new Color(209,224,239));
		getContentPane().add(panel_3,BorderLayout.NORTH);
		
		btnNewButton = new JButton("计算");
		btnNewButton.addMouseListener(MyMouse);
		panel_3.add(btnNewButton);
		
		lblSxy = new JLabel("Sxy:");
		lblSxy.setFont(new Font("宋体", Font.PLAIN, 19));
		lblSxy.setBounds(211, 705, 133, 32);
		panel_3.add(lblSxy);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		lblSxz = new JLabel("Sxz:");
		lblSxz.setFont(new Font("宋体", Font.PLAIN, 19));
		panel_3.add(lblSxz);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_3.add(textField_4);
		
		lblSyz = new JLabel("Syz:");
		lblSyz.setFont(new Font("宋体", Font.PLAIN, 19));
		panel_3.add(lblSyz);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_3.add(textField_5);
		
		/**
		 * 添加两个选择框，并将两个组合在一起形成单选框
		 */
		rdbtnNewRadioButton = new JRadioButton("文件输入");
		panel_3.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("手动输入");
		panel_3.add(rdbtnNewRadioButton_1);
		
		ButtonGroup dataIn=new ButtonGroup();
		dataIn.add(rdbtnNewRadioButton);
		dataIn.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton.addActionListener(jrbutton);
		rdbtnNewRadioButton_1.addActionListener(jrbutton);
		
		/**
		 * 定义一个分割窗口
		 */
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(200);
		splitPane.setDividerSize(7);//设置分割线大小
		splitPane.setOneTouchExpandable(true);//设置分割线上显示三角
		getContentPane().add(splitPane,BorderLayout.CENTER);
		
		/**
		 * 定义第二个分割窗口，并将该窗口放在上一个分割窗口的右侧
		 */
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);//设置窗口为上下模式
		splitPane.setRightComponent(splitPane_1);
		splitPane_1.setDividerSize(7);
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setDividerLocation(680);
		
		/**
		 * 定义滑动面板，将该面板放入第二个窗口的上方
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1 .setLeftComponent(scrollPane_1);
		
		/**
		 * 在窗口的中部添加一个空布局的面板
		 */
		panel = new JPanel(null);
		panel.setBackground(Color.white);//背景色
		panel.setPreferredSize(new Dimension(900,1000));
		scrollPane_1.setViewportView(panel);//将面板加入到滑动窗口中
		
		/**
		 * 定义一个滚动条，将该其放入第二个窗口的下方
		 */
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_1 .setRightComponent(scrollPane_2);
		
		JPanel panel_2 = new JPanel(null);
		panel_2.setPreferredSize(new Dimension(900,130));	//设置首选大小
		panel_2.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(panel_2);
		
		lblNewLabel_1 = new JLabel("结果查询：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(14, 13, 99, 27);
		panel_2.add(lblNewLabel_1);
		
		label_4 = new JLabel("x轴的值:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 19));
		label_4.setBounds(85, 49, 86, 22);
		panel_2.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(178, 50, 86, 24);
		panel_2.add(textField_6);
		
		label_5 = new JLabel("y轴的值:");
		label_5.setFont(new Font("宋体", Font.PLAIN, 19));
		label_5.setBounds(288, 49, 77, 22);
		panel_2.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(381, 50, 86, 24);
		panel_2.add(textField_7);
		
		label_6 = new JLabel("z轴的值:");
		label_6.setFont(new Font("宋体", Font.PLAIN, 19));
		label_6.setBounds(489, 50, 86, 22);
		panel_2.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(584, 50, 86, 24);
		panel_2.add(textField_8);
		
		button_2 = new JButton("查询");
		button_2.setBounds(698, 49, 63, 27);
		panel_2.add(button_2);
		
		textArea = new TextArea();
		textArea.setBounds(85, 98, 777, 190);
		panel_2.add(textArea);

		
		/**
		 * 定义面板并将其加入第一个分割窗口的左侧
		 */
		panel_1 = new JPanel(null);
		splitPane.setLeftComponent(panel_1);
		panel_1.setBackground(Color.white);
	}
	
	//创建单选框的事件监听器
	class JRbutton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//清空排版
			panel.removeAll();
			//选择文件输入时显示的组件
			if(e.getSource()==rdbtnNewRadioButton) 
			{
				/**
				 * 添加文件读写属性
				 */
				JLabel label = new JLabel("文件读取:");
				label.setFont(new Font("宋体", Font.PLAIN, 20));
				label.setBounds(79, 36, 118, 32);
				panel.add(label);
				
				/**
				 *x轴的标签提示、输入框以及文件选中按钮
				 */
				JLabel label_1 = new JLabel("x轴误差文件:");
				label_1.setFont(new Font("宋体", Font.PLAIN, 19));
				label_1.setBounds(211, 60, 133, 32);
				panel.add(label_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(334, 63, 475, 31);
				textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(textField_2);
				
				btnBrsowfe = new JButton("浏览");
				btnBrsowfe.setFont(new Font("宋体", Font.PLAIN, 19));
				btnBrsowfe.setBounds(823, 65, 80, 27);
				btnBrsowfe.addActionListener(action);
				panel.add(btnBrsowfe);
				
				/**
				 * y轴的选择组件
				 */
				JLabel label_2 = new JLabel("y轴误差文件:");
				label_2.setFont(new Font("宋体", Font.PLAIN, 19));
				label_2.setBounds(211, 101, 133, 32);
				panel.add(label_2);
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(334, 104, 475, 31);
				textField.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(textField);
				
				button = new JButton("浏览");
				button.setFont(new Font("宋体", Font.PLAIN, 19));
				button.setBounds(823, 106, 80, 27);
				button.addActionListener(action);
				panel.add(button);
				
				/**
				 * z轴文件选择组件
				 */
				JLabel label_3 = new JLabel("z轴误差文件:");
				label_3.setFont(new Font("宋体", Font.PLAIN, 19));
				label_3.setBounds(211, 142, 133, 32);
				panel.add(label_3);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(334, 145, 475, 31);
				textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(textField_1);
				
				button_1 = new JButton("浏览");
				button_1.setFont(new Font("宋体", Font.PLAIN, 19));
				button_1.setBounds(823, 147, 80, 27);
				button_1.addActionListener(action);
				panel.add(button_1);
			}else if(e.getSource()==rdbtnNewRadioButton_1) //手动输入时的文件
			{
				System.out.println("进来了");
				//往面板中添加标签
				JLabel lblNewLabel = new JLabel("手动输入：");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));//设置字体
				lblNewLabel.setBounds(79, 36, 118, 32);//位置
				panel.add(lblNewLabel);
				
				//创建x表格属性，并将模型设置为自定义模型
				table1 = new JTable();
				table1.setRowHeight(24);//设置行高
				table1.setFont(new Font("华文行楷",Font.PLAIN,15));
				tabmodel1 = new tableModel("x",null);
				table1.setModel(tabmodel1);//选择表格的模型
				table1.setRowSelectionAllowed(false);//设置不能选择行
				table1.setSelectionForeground(Color.blue);
				//添加滚动条，将表格加到滚动条中
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(79, 70, 1400, 201);
				scrollPane.setViewportView(table1);
				panel.add(scrollPane);
				
				// 添加y轴表格
				table = new JTable();
				table.setRowHeight(24);
				table.setFont(new Font("华文行楷",Font.PLAIN,15)); 
				tabmodel2 = new tableModel("y",null);
				table.setModel(tabmodel2);
				table.setRowSelectionAllowed(false);
				table.setSelectionForeground(Color.black);
				
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(79, 301, 1400, 201);
				scrollPane1.setViewportView(table);
				panel.add(scrollPane1);
				
				//添加z轴表格
				table2 = new JTable();
				table2.setRowHeight(24);
				table2.setFont(new Font("华文行楷",Font.PLAIN,15)); 
				tabmodel3 = new tableModel("z",null);
				table2.setModel(tabmodel3);
				table2.setRowSelectionAllowed(false);
				
				
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setBounds(79, 544,1400, 201);
				scrollPane2.setViewportView(table2);
				panel.add(scrollPane2);
			}
			panel.updateUI();	
		}
	}
	
	/**
	 * 动作监听器，实现组件
	 * @author yao
	 *
	 */
	class jixieAction implements ActionListener
	{
		private Object[][] data;
		private File myFile;
		private JFileChooser jf;

		@Override
		public void actionPerformed(ActionEvent e) 
		{
//			openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
			//新建事件
			if(e.getSource()==mntmNewMenuItem_1) 
			{
				newGui new1 = new newGui();
				new1.setVisible(true);
				//添加窗口的关闭事件，只关闭当前窗口
				new1.addWindowListener(new WindowAdapter() {
					public void	windowClosed(WindowEvent e) {
						new1.dispose();
					}
				});
			}
			//打开事件
			if(e.getSource()==mntmNewMenuItem_2)
			{
				panel.removeAll();
				jf = new JFileChooser();
				jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				System.out.println("第2响应");
				jf.showOpenDialog(newGui.this);
				jf.setMultiSelectionEnabled(true);
				//定义一个树状菜单
				myFile =jf.getSelectedFile();
				System.out.println(myFile);
				treeMeun(myFile);
				excelMode= new Model();
				result = excelMode.read(myFile+"\\计算结果\\计算结果.xlsx");
				xianshi("x",myFile+"\\误差数据\\x的误差数据.xlsx","xlsx","open");
				xianshi("y",myFile+"\\误差数据\\y的误差数据.xlsx","xlsx","open");
				xianshi("z",myFile+"\\误差数据\\z的误差数据.xlsx","xlsx","open");
				
			}
			if(e.getSource()==mntmNewMenuItem_3){
				if(myFile==null) {
					Save();
				}else {
					System.out.println(myFile);
					excelMode.write(outDatax, myFile+"\\误差数据\\x的误差数据.xlsx","x");
					excelMode.write(outDatay, myFile+"\\误差数据\\y的误差数据.xlsx","y");
					excelMode.write(outDataz, myFile+"\\误差数据\\z的误差数据.xlsx","z");
					excelMode.write(result,myFile+"\\计算结果\\计算结果.xlsx");
					treeMeun(myFile);
				}
			}
			if(e.getSource()==mntmNewMenuItem_4)
			{
				System.out.println("第4响应");
				Save();

			}
			//打开坐标轴文件按钮时产生的事件
			if(e.getSource()==btnBrsowfe){
				//定义FileDialog为选择文件
				openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
				//设置只可以读取的文件类型
				openDia.setFile("*.xls;*.xlsx");
				openDia.setVisible(true);
				excelMode = new Model();
				if(openDia.getFile()==null) {
					JOptionPane.showMessageDialog(newGui.this, "文件不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
				}else {
					String type = (String) openDia.getFile().subSequence(openDia.getFile().indexOf(".")+1, openDia.getFile().length());
					textField_2.setText(openDia.getDirectory()+openDia.getFile());
					xianshi("x", openDia.getDirectory()+openDia.getFile(),type,"create");
				}
			}
			if(e.getSource()==button){
				//定义FileDialog为选择文件
				openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
				//设置只可以读取的文件类型
				openDia.setFile("*.xls;*.xlsx");
				openDia.setVisible(true);
				excelMode = new Model();
				if(openDia.getFile()==null) {
					JOptionPane.showMessageDialog(newGui.this, "文件不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
				}else {
					String type = (String) openDia.getFile().subSequence(openDia.getFile().indexOf(".")+1, openDia.getFile().length());
					textField.setText(openDia.getDirectory()+openDia.getFile());
					xianshi("y",openDia.getDirectory()+openDia.getFile(),type,"create");
				}
			}
			if(e.getSource()==button_1){
				//定义FileDialog为选择文件
				openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
				//设置只可以读取的文件类型
				openDia.setFile("*.xls;*.xlsx");
				openDia.setVisible(true);
				excelMode = new Model();
				if(openDia.getFile()==null) {
					JOptionPane.showMessageDialog(newGui.this, "文件不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
				}else {
					String type = (String) openDia.getFile().subSequence(openDia.getFile().indexOf(".")+1, openDia.getFile().length());
					textField_1.setText(openDia.getDirectory()+openDia.getFile());
					xianshi("z",openDia.getDirectory()+openDia.getFile(),type,"create");
				}
			}
		}
		/**
		 * 另存为功能
		 */
		public void Save() {
			jf=new JFileChooser();
			jf.setMultiSelectionEnabled(false);
			jf.showSaveDialog(newGui.this);
			myFile = jf.getSelectedFile();
			File file1=new File(jf.getSelectedFile(),"误差数据");
			File file2=new File(jf.getSelectedFile(),"计算结果");
			System.out.println(jf.getSelectedFile());
			if (!file1.exists() && !file1.isDirectory()) {//文件不存在 则创建一个
				file1.mkdirs();
				file2.mkdirs();
			}
			excelMode.write(outDatax, jf.getSelectedFile()+"\\误差数据\\x的误差数据.xlsx","x");
			excelMode.write(outDatay, jf.getSelectedFile()+"\\误差数据\\y的误差数据.xlsx","y");
			excelMode.write(outDataz, jf.getSelectedFile()+"\\误差数据\\z的误差数据.xlsx","z");
			excelMode.write(result,jf.getSelectedFile()+"\\计算结果\\计算结果.xlsx");
			treeMeun(myFile);
		}
		
		/**
		 * 文件的树状菜单
		 */
		public void treeMeun(File path) {
			//创建根节点
			DefaultMutableTreeNode root=new DefaultMutableTreeNode(path.getName());
			for(File i :path.listFiles())
			{
				DefaultMutableTreeNode  oneUser=new DefaultMutableTreeNode(i.getName());
				root.add(oneUser);
				for(String j :i.list()) {
					DefaultMutableTreeNode two =new DefaultMutableTreeNode(j);
					oneUser.add(two);
				}
			}
			JTree tree = new JTree(root);
			tree.setBounds(14, 13, 350, 291);
			panel_1.removeAll();
			panel_1.add(tree);
			panel_1.updateUI();	
		}
		
		/**
		 * 显示文件输入时的表格显示
		 * @param xianshi
		 */
		public void xianshi(String tab,String path,String type,String way) 
		{
			switch (tab) 
			{
				case "x":
					//将目录显示出来
//					textField_2.setText(path);
					// 创建x表格属性，并将模型设置为自定义模型
					table1 = new JTable();
					table1.setRowHeight(24);//设置行高
					table1.setFont(new Font("华文行楷",Font.PLAIN,15));
					tabmodel1 = new tableModel(tab,excelMode.read(path,type));
					table1.setModel(tabmodel1);//选择表格的模型
					table1.setRowSelectionAllowed(false);
					//添加滚动条，将表格加到滚动条中
					JScrollPane scrollPane = new JScrollPane();
					if(way.equals("open")) {
						scrollPane.setBounds(79, 70, 1400, 201);
					}else {
						scrollPane.setBounds(79, 225, 1400, 201);
					}
					scrollPane.setViewportView(table1);
					panel.add(scrollPane);
					break;
				case "y":
//					textField.setText(path);
					// 添加y轴表格
					table = new JTable();
					table.setRowHeight(24);
					table.setFont(new Font("华文行楷",Font.PLAIN,15)); 
					tabmodel2 = new tableModel(tab,excelMode.read(path,type));
					table.setModel(tabmodel2);
					table.setRowSelectionAllowed(false);
					
					JScrollPane scrollPane1 = new JScrollPane();
					if(way.equals("open")) {
						scrollPane1.setBounds(79, 301, 1400, 201);
					}else {
						scrollPane1.setBounds(79, 466, 1400, 201);
					}
					scrollPane1.setViewportView(table);
					panel.add(scrollPane1);
					panel.updateUI();
					break;
				case "z":
//					textField_1.setText(path);
					//添加z轴表格
					table2 = new JTable();
					table2.setRowHeight(24);
					table2.setFont(new Font("华文行楷",Font.PLAIN,15));
					tabmodel3 = new tableModel(tab,excelMode.read(path,type));
					table2.setModel(tabmodel3);
					table2.setRowSelectionAllowed(false);
					
					JScrollPane scrollPane2 = new JScrollPane();
					if(way.equals("open")) {
						scrollPane2.setBounds(79, 544,1400, 201);
					}else {
						scrollPane2.setBounds(79, 709, 1400, 201);
					}
					scrollPane2.setViewportView(table2);
					panel.add(scrollPane2);
			}
			panel.updateUI();
		}
	}
	
	/**
	 * 定义一个鼠标监听类
	 * @author yao
	 *
	 */
	class myMouse extends MouseAdapter
	{
		double sxy,syz,sxz;
		int xleng,yleng,zleng;
		//当鼠标点击时产生对应的功能，该部分是对用户点击计算按钮时产生对应的功能。
		public void mouseClicked(MouseEvent e) 
		{
			try {
				sxy = Double.valueOf(textField_3.getText());
				sxz = Double.valueOf(textField_4.getText());
				syz = Double.valueOf(textField_5.getText());
				controller contr = new controller();
				outDatax =tabmodel1.zhuanhuan();
				outDatay =tabmodel2.zhuanhuan();
				outDataz =tabmodel3.zhuanhuan();
				for(double[] i:outDatax) {
					for(double j:i) {
						System.out.print(j+"  ");
					}
					System.out.println();
				}
				result = new algorithm().resultList(outDatax,outDatay,outDataz,sxy,syz,sxz);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(newGui.this, "输入数据不规范", "错误提示", JOptionPane.ERROR_MESSAGE);
				textField_3.setText(String.valueOf(sxy));
				textField_4.setText(String.valueOf(sxz));
				textField_5.setText(String.valueOf(syz));
			}
			catch (NullPointerException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(newGui.this, "数据没有导入完整", "错误提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
	
	
	
