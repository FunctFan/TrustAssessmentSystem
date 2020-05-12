package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.artisan.model.Network;
import com.artisan.model.UserType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URI;

import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import javax.swing.JTextField;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenu commonManageMenu;
	private JMenu egdeNodeManageMenu;
	private JMenuItem commonAddMenu;
	private JPanel viewPanel;
	private JLabel tittleLabel;
	private JPanel panel;
	private JPanel panel_1;
	public static UserType userType;  //定义成员变量,静态类型，为子框架提供变量
	public static Object userObject;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application. 
	 */
	
	
//	public static void main(String[] args) {        //不能直接进入主界面，从登录界面进入,可以用于测试
//		EventQueue.invokeLater(new Runnable() {     //更改loginFrm
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm(null, null);      //用于测试
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType, Object userObject) {
		this.userType = userType;          //+
		this.userObject = userObject;
		
		setTitle("\u4FE1\u4EFB\u8BC4\u4F30\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1298, 878);
		setLocationRelativeTo(null);  //让窗口居中
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//调用修改密码的方法
				editPassword(ae);
			}
		});
		
		commonManageMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		commonManageMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		menu.add(commonManageMenu);
		
		commonAddMenu = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		commonAddMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//用户添加功能
				clearPane();
				AddCommonFrm addCommonFrm = new AddCommonFrm();
				addCommonFrm.setVisible(true);//设置可见
				desktopPane.add(addCommonFrm);//添加到desktopPane
			}
		});
		commonManageMenu.add(commonAddMenu);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7528\u6237\u5217\u8868");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//用户添加、管理
				clearPane();
				CommonManageFrm commonManageFrm = new CommonManageFrm();
				commonManageFrm.setVisible(true);//设置可见
				desktopPane.add(commonManageFrm);//添加到desktopPane
			}
		});
		commonManageMenu.add(menuItem_8);
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出系统
				
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出吗？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(menuItem_1);
		
		egdeNodeManageMenu = new JMenu("\u8282\u70B9\u7BA1\u7406");
		menuBar.add(egdeNodeManageMenu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8282\u70B9\u6DFB\u52A0");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		egdeNodeManageMenu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u8282\u70B9\u5217\u8868");
		egdeNodeManageMenu.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("\u7F51\u7EDC\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7F51\u7EDC\u62D3\u6251");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//显示网络拓扑图
				clearPane();
				desktopPane.add(viewPanel);
				tittleLabel.setVisible(true);
				panel.setVisible(true);
				panel_1.setVisible(true);
				viewPanel.updateUI();
				viewPanel.repaint();
			}
		});
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_6 = new JMenuItem("\u7F51\u7EDC\u6DFB\u52A0");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addNetwork(ae);
			}
		});
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u7F51\u7EDC\u7BA1\u7406");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//网络管理按钮
				clearPane();
				NetworkManageFrm networkManageFrm = new NetworkManageFrm();
				networkManageFrm.setVisible(true);
				desktopPane.add(networkManageFrm);
				
			}
		});
		menu_2.add(menuItem_7);
		
		JMenu menu_1 = new JMenu("\u4FE1\u4EFB\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_11 = new JMenuItem("\u4FE1\u4EFB\u67E5\u770B");
		menu_1.add(menuItem_11);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u7CFB\u7EDF\u4ECB\u7ECD");
		menu_3.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u4F7F\u7528\u8BF4\u660E");
		menu_3.add(menuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setToolTipText("");
		desktopPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		viewPanel = new JPanel();
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8BBE\u7F6E\u53C2\u6570", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(255, 69, 0)));
		panel.setBackground(SystemColor.menu);
		
		JLabel label = new JLabel("\u66F4\u65B0\u95F4\u9694");
		
		JLabel label_1 = new JLabel("\u6570\u636E\u91CF");
		
		JLabel label_2 = new JLabel("\u9519\u8BEF\u7387");
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setText("0");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText("10");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("10");
		textField_2.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(label))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(245, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7F51\u7EDC\u62D3\u6251", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		panel_1.setBackground(SystemColor.menu);
		
		JLabel label_3 = new JLabel("\u65E0\u7EBF\u7F51\u7EDC1");
		label_3.setEnabled(false);
		
		JButton button = new JButton("\u8FB9\u7F18\u8282\u70B9A1");
		button.setEnabled(false);
		button.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8FB9\u7F18\u8282\u70B9.png")));
		button.setBackground(Color.LIGHT_GRAY);
		
		JButton button_1 = new JButton("\u8FB9\u7F18\u8282\u70B9A2");
		button_1.setEnabled(false);
		button_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_4 = new JLabel("\u65E0\u7EBF\u7F51\u7EDC2");
		label_4.setEnabled(false);
		
		JButton button_2 = new JButton("\u8FB9\u7F18\u8282\u70B9A3");
		button_2.setEnabled(false);
		button_2.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_5 = new JLabel("\u65E0\u7EBF\u7F51\u7EDC3");
		label_5.setEnabled(false);
		
		JLabel label_6 = new JLabel("\u8FB9\u7F18\u4EE3\u7406");
		label_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8FB9\u7F18\u4EE3\u7406.png")));
		
		JButton button_3 = new JButton("");
		button_3.setEnabled(false);
		button_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5DE5\u4E1A\u4E91.png")));
		button_3.setBackground(SystemColor.scrollbar);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 880, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(79))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addGap(56)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
							.addGap(68)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_2)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
							.addGap(67))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(332))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
							.addGap(176))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 659, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(label_6)
					.addGap(65)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(105)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		tittleLabel = new JLabel("\u5DE5\u4E1A\u8FB9\u7F18\u8282\u70B9\u4FE1\u4EFB\u8BC4\u4F30\u7CFB\u7EDF");
		tittleLabel.setIcon(new ImageIcon(MainFrm.class.getResource("/images/logo.png")));
		tittleLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));
		GroupLayout gl_viewPanel = new GroupLayout(viewPanel);
		gl_viewPanel.setHorizontalGroup(
			gl_viewPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_viewPanel.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(gl_viewPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_viewPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_viewPanel.createSequentialGroup()
							.addComponent(tittleLabel, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
							.addGap(330))))
		);
		gl_viewPanel.setVerticalGroup(
			gl_viewPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_viewPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tittleLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_viewPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_viewPanel.createSequentialGroup()
							.addGap(102)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		viewPanel.setLayout(gl_viewPanel);
		desktopPane.setLayout(gl_desktopPane);
		
		setAuthority();//初始化之后，调用权限分配
	}
	//添加网络，后期改成，检测到udp包就添加一个网络，不用手动添加，【之后这个菜单按钮不再需要】
	protected void addNetwork(ActionEvent ae) {
		// TODO Auto-generated method stub
		clearPane();
		NetworkAddFrm networkAddFrm = new NetworkAddFrm();
		networkAddFrm.setVisible(true);
		desktopPane.add(networkAddFrm);
	}
	//修改密码的按钮的方法
	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		clearPane();
        EditPasswordFrm editPasswordFrm = new EditPasswordFrm();  //局部变量
		editPasswordFrm.setVisible(true);//设置可见
		desktopPane.add(editPasswordFrm);//添加到desktopPane

		
		
	}
	//关于我们的按钮的方法
	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String info = "【重庆邮电大学】出品\n";
		info += "网址：http://www.cqupt.edu.cn/ \n";
		String[] buttons = {"去看看","取消"};		
		//JOptionPane.showMessageDialog(this, info);
		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/logo.png")), buttons, null);
		if(ret == 0){
			//采用Java 调用系统浏览器打开制定
			try {
				URI uri = new URI("http://www.cqupt.edu.cn/");
				Desktop.getDesktop().browse(uri);
				//Runtime.getRuntime().exec("explorer http://www.cqupt.edu.cn/");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//角色权限分配方法，（初始化之后调用）
	private void setAuthority() {
		if("普通操作员".equals(userType.getName())) {
			commonAddMenu.setEnabled(false);
			egdeNodeManageMenu.setEnabled(false);
		}
	}
	private void clearPane(){
		desktopPane.removeAll();
		desktopPane.updateUI();
		desktopPane.repaint();
	}
}
