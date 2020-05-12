package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.artisan.dao.AdminDao;
import com.artisan.dao.CommonDao;
import com.artisan.model.Admin;
import com.artisan.model.Common;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);  //让窗口居中
		
		JLabel label = new JLabel("\u4FE1\u4EFB\u8BC4\u4F30\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/logo.png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6   \u7801");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801.png")));
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.COMMON}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(172)
							.addComponent(label_1)
							.addGap(27)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(label_2)
							.addGap(27)
							.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(label_3)
							.addGap(12)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(loginButton)
							.addGap(86)
							.addComponent(resetButton)))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(label_2)
							.addGap(31)
							.addComponent(label_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(loginButton)
							.addGap(24))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(resetButton)
							.addGap(25))))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//登录事件
		String userName = userNameTextField.getText().toString(); //获取用户输入的值
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//判断是否有输入
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
	
		if("安全管理员".equals(selectedItem.getName())){
			//安全管理员登录
			AdminDao adminDao = new AdminDao();    //配合数据库
			Admin adminTmp = new Admin();           //数据库中的表
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();//优化--释放数据库资源
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			//JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】:"+admin.getName()+"登录本系统！");
			this.dispose();//登录成功后将登录界面隐藏
			
			new MainFrm(selectedItem, admin).setVisible(true); //登录成功后进入主界面
		}else{
			//普通操作员登录
			Common common = null;
			CommonDao commonDao = new CommonDao();    //配合数据库
			Common commonTmp = new Common();           //数据库中的表
			commonTmp.setName(userName);
			commonTmp.setPassword(password);
			common = commonDao.login(commonTmp);
			commonDao.closeDao();//优化--释放数据库资源
			if(common == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			//JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】:"+common.getName()+"登录本系统！");
			this.dispose();//登录成功后将登录界面隐藏
			
			new MainFrm(selectedItem, common).setVisible(true); //登录成功后进入主界面
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		//清空输入
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
