package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.artisan.dao.AdminDao;
import com.artisan.dao.CommonDao;
import com.artisan.model.Admin;
import com.artisan.model.Common;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;

	private JLabel currentUserLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {   //不能单独打开，
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrm frame = new EditPasswordFrm();
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
	public EditPasswordFrm() {
		
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //这句让窗口无法关闭
		setBounds(100, 100, 434, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		setClosable(true); //设置可关闭
		setIconifiable(true);//可放大缩小
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/password.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		//按钮触发事件
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("New label");
		currentUserLabel.setForeground(Color.GREEN);
		currentUserLabel.setEnabled(false);
		currentUserLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(currentUserLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(newPasswordTextField, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(confirmPasswordTextField)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
		
		if("安全管理员".equals(MainFrm.userType.getName())){
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("[安全管理员]"+admin.getName()); //显示名字
		}else {
			Common common = (Common)MainFrm.userObject;
			currentUserLabel.setText("[普通操作员]"+common.getName()); //显示名字
		}
		
	}
	  //确认密码修改方法
      protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();//从窗口中获取用户输入的用户名
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmPasswordTextField.getText().toString();
		//判断窗口中是否有输入
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请写旧密码！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请写新密码！");
			return;
		}
		if(StringUtil.isEmpty(confirmPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if(!newPassword.equals(confirmPassword)){
			JOptionPane.showMessageDialog(this, "两次密码不一致！");
			return;
		}
		//判断输入的旧密码是否正确（与数据中的旧密码比较）,先判断用户类型是不是正确
		if("安全管理员".equals(MainFrm.userType.getName())){  
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setId(admin.getId()); 
			adminTmp.setPassword(oldPassword);//有点绕，可以直接用(Admin)MainFrm.userObject
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();//优化--释放数据库资源
			return;
		}
		if("普通操作员".equals(MainFrm.userType.getName())) {
			CommonDao commonDao = new CommonDao();
			Common commonTmp = new Common();
			Common common = (Common)MainFrm.userObject;
			commonTmp.setName(common.getName());
			commonTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, commonDao.editPassword(commonTmp, newPassword));
			commonDao.closeDao();
			return;
		}
		
	}
	//重置方法
	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
	    oldPasswordTextField.setText("");
	    newPasswordTextField.setText("");
	    confirmPasswordTextField.setText("");
	}

}
