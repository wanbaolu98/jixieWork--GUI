package jxWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Element;
import javax.swing.text.TableView;
import javax.swing.text.TableView.TableCell;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jxWork.mainGui.jixieAction;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.*;

public class newGui extends JFrame 
{
	private Color white;
	private JTable table,table1,table2;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
    private FileDialog openDia, saveDia;// 定义“打开、保存”对话框
    private jixieAction action;
    private JButton btnBrsowfe,button_1,button;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JPanel panel;
    private JRbutton jrbutton;
    private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
    private myMouse MyMouse;
    private tableModel tabmodel1,tabmodel2,tabmodel3;
    private JButton btnNewButton;
    private JMenuItem mntmNewMenuItem_1,mntmNewMenuItem_2,mntmNewMenuItem_3,mntmNewMenuItem_4;
    private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGui frame = new newGui();
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
	public newGui() {
		
		//设置窗口格式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1100,900);
		
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
		
		JLabel lblSxy = new JLabel("Sxy:");
		lblSxy.setFont(new Font("宋体", Font.PLAIN, 19));
		lblSxy.setBounds(211, 705, 133, 32);
		panel_3.add(lblSxy);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSxz = new JLabel("Sxz:");
		lblSxz.setFont(new Font("宋体", Font.PLAIN, 19));
		panel_3.add(lblSxz);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_3.add(textField_4);
		
		JLabel lblSyz = new JLabel("Syz:");
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
		splitPane_1.setResizeWeight(1);
		
		/**
		 * 定义滑动面板，将该面板放入第二个窗口的上方
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
//		splitPane_1 .setRightComponent(scrollPane_1);
		splitPane_1 .setLeftComponent(scrollPane_1);
		
		/**
		 * 在窗口的中部添加一个空布局的面板
		 */
		panel = new JPanel(null);
		panel.setBackground(Color.white);//背景色
//		panel.setBounds(548, 817, 10, 10);
		panel.setPreferredSize(new Dimension(900,1000));
		scrollPane_1.setViewportView(panel);//将面板加入到滑动窗口中
		
		/**
		 * 定义一个滚动条，将该其放入第二个窗口的下方
		 */
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_1 .setRightComponent(scrollPane_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(900,130));	//设置首选大小
		panel_2.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(panel_2);
		
		
		JLabel label_4 = new JLabel("结果:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 19));
		label_4.setBounds(211, 705, 133, 32);
		panel_2.add(label_4);
		
		
		/**
		 * 定义面板并将其加入第一个分割窗口的左侧
		 */
		panel_1 = new JPanel(null);
		splitPane.setLeftComponent(panel_1);
		panel_1.setBackground(Color.white);
		
		//定义一个树状菜单
//		DefaultMutableTreeNode root=new DefaultMutableTreeNode("所有好友");
//		JTree tree = new JTree(root);
//		tree.setBounds(14, 13, 171, 291);
//		panel_1.add(tree);
		
		
	}
	
	//创建单选框的事件监听器
	class JRbutton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//清空排版
			panel.removeAll();
//			System.out.println(e.getSource());
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
				Object[][] data= new Object[7][15];
				System.out.println("进来了");
				/**
				 * 往面板中添加标签
				 */
				JLabel lblNewLabel = new JLabel("手动输入：");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));//设置字体
				lblNewLabel.setBounds(79, 36, 118, 32);//位置
				panel.add(lblNewLabel);
				
				/**
				 * 创建x表格属性，并将模型设置为自定义模型
				 */
				table1 = new JTable();
				table1.setRowHeight(25);//设置行高
				table1.setFont(new Font("华文行楷",Font.PLAIN,15));
				table1.setModel(new tableModel(1,data));//选择表格的模型
				System.out.println("改变行数："+table1.getSelectedRow());
				
				/**
				 * 添加滚动条，将表格加到滚动条中
				 */
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(211, 60, 692, 200);
				scrollPane.setViewportView(table1);
				panel.add(scrollPane);
				
				/**
				 * 添加y轴表格
				 */
				table = new JTable();
				table.setRowHeight(25);
				table.setFont(new Font("华文行楷",Font.PLAIN,15)); 
				table.setModel(new tableModel(2,data));
				
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(211, 301, 692, 200);
				scrollPane1.setViewportView(table);
				panel.add(scrollPane1);
				
				/**
				 * 添加z轴表格
				 */
				table2 = new JTable();
				table2.setRowHeight(25);
				table2.setFont(new Font("华文行楷",Font.PLAIN,15)); 
				table2.setModel(new tableModel(3,data));
				
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setBounds(211, 544, 692, 200);
				scrollPane2.setViewportView(table2);
				panel.add(scrollPane2);
			}
			panel.updateUI();	
		}
	}
	
	/**
	 * 动作监听器
	 * @author yao
	 *
	 */
	class jixieAction implements ActionListener
	{
		
		private String mulu,name;
		private Object[][] data;

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
			JFileChooser jf = new JFileChooser();
			jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(e.getSource()==mntmNewMenuItem_1) 
			{
				System.out.println("第一响应");
				openDia.setFile("");
				openDia.setVisible(true);
				newGui new1 = new newGui();
				new1.setVisible(true);
			}else if(e.getSource()==mntmNewMenuItem_2)
			{
				System.out.println("第2响应");
				jf.showOpenDialog(newGui.this);
				//定义一个树状菜单
				DefaultMutableTreeNode root=new DefaultMutableTreeNode(jf.getName(jf.getSelectedFile()));
				JTree tree = new JTree(root);
				tree.setBounds(14, 13, 171, 291);
				panel_1.add(tree);
				panel_1.updateUI();	
				
			}else if(e.getSource()==mntmNewMenuItem_3)
			{
				System.out.println("第3响应");

			}else if(e.getSource()==mntmNewMenuItem_4)
			{
				System.out.println("第4响应");

			}else if(e.getSource()==btnBrsowfe)
			{
				xianshi(1);
			}else if(e.getSource()==button)
			{
				xianshi(2);
			}else if(e.getSource()==button_1)
			{
				xianshi(3);
			}
		}
		
		/**
		 * 显示文件输入时的表格显示
		 * @param xianshi
		 */
		public void xianshi(int xianshi) 
		{
			openDia = new FileDialog(newGui.this,"",FileDialog.LOAD);
			openDia.setFile("*.xls;*.xlsx");
			openDia.setVisible(true);
			Model model = new Model();
			if(openDia.getFile()==null) {
				JOptionPane.showMessageDialog(newGui.this, "文件不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			}else {
				mulu = openDia.getDirectory();
				name = openDia.getFile();
				if(xianshi==1) 
				{
					textField_2.setText(mulu+name);
					model.read(mulu,name);
					data=model.getX();
					
					/**
					 * 创建x表格属性，并将模型设置为自定义模型
					 */
					table1 = new JTable();
					table1.setRowHeight(25);//设置行高
					table1.setFont(new Font("华文行楷",Font.PLAIN,15));
					tabmodel1 = new tableModel(1,data);
					table1.setModel(tabmodel1);//选择表格的模型
					
					/**
					 * 添加滚动条，将表格加到滚动条中
					 */
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(211, 225, 692, 200);
					scrollPane.setViewportView(table1);
					panel.add(scrollPane);
				}else if(xianshi==2) 
				{
					textField.setText(mulu+name);
					model.read(mulu,name);
					data=model.getX();
					
					/**
					 * 添加y轴表格
					 */
					table = new JTable();
					table.setRowHeight(25);
					table.setFont(new Font("华文行楷",Font.PLAIN,15)); 
					tabmodel2 = new tableModel(3,data);
					table.setModel(tabmodel2);
					
					JScrollPane scrollPane1 = new JScrollPane();
					scrollPane1.setBounds(211, 466, 692, 200);
					scrollPane1.setViewportView(table);
					panel.add(scrollPane1);
					panel.updateUI();
				}
				else if(xianshi==3) 
				{
					textField_1.setText(mulu+name);
					model.read(mulu,name);
					data=model.getX();
					/**
					 * 添加z轴表格
					 */
					table2 = new JTable();
					table2.setRowHeight(25);
					table2.setFont(new Font("华文行楷",Font.PLAIN,15));
					tabmodel3 = new tableModel(3,data);
					table2.setModel(tabmodel3);
					
					JScrollPane scrollPane2 = new JScrollPane();
					scrollPane2.setBounds(211, 709, 692, 200);
					scrollPane2.setViewportView(table2);
					panel.add(scrollPane2);
				}
				panel.updateUI();
			}
			
		}
		
	}
	
	class myMouse extends MouseAdapter
	{
		Object[][] x,y,z;
		public void mouseClicked(MouseEvent e) 
		{
				x=tabmodel1.getData();
				y=tabmodel2.getData();
				z=tabmodel3.getData();
				new algorithm(x,y,z);
		}
	}
		
		
}
	
	
	
