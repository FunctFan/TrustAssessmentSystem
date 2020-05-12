package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

import com.artisan.dao.CommonDao;
import com.artisan.model.Common;
import com.artisan.model.Network;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCommonFrm extends JInternalFrame {
	private JTextField commonNameTextField;
	private JTextField commonPasswordTextField;
	private JRadioButton commonManRadioButton;
	private JRadioButton commonFemalRadioButton;
	private JRadioButton commonUnkonwRadioButton;
	private ButtonGroup sexButtonGroup;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCommonFrm frame = new AddCommonFrm();
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
	public AddCommonFrm() {
		setTitle("\u6DFB\u52A0\u666E\u901A\u64CD\u4F5C\u5458");
		setBounds(100, 100, 450, 300);
		
		setClosable(true); //设置可关闭
		setIconifiable(true);//可放大缩小
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\u79F0");
		
		JLabel label = new JLabel("\u5BC6\u7801");
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		
		commonNameTextField = new JTextField();
		commonNameTextField.setColumns(10);
		
		commonPasswordTextField = new JTextField();
		commonPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//用户添加
				commonAddAct(ae);
			}
		});
		
		JButton resetBbutton = new JButton("\u91CD\u7F6E");
		resetBbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		
		commonManRadioButton = new JRadioButton("\u7537");
		commonManRadioButton.setSelected(true);
		
		commonFemalRadioButton = new JRadioButton("\u5973");
		
		commonUnkonwRadioButton = new JRadioButton("\u4FDD\u5BC6");
		
		//从多个选择中只选一个
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(commonManRadioButton);
		sexButtonGroup.add(commonFemalRadioButton);
		sexButtonGroup.add(commonUnkonwRadioButton);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(74)
									.addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(85)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(commonPasswordTextField)
										.addComponent(commonNameTextField, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addComponent(commonManRadioButton)
									.addGap(18)
									.addComponent(commonFemalRadioButton)
									.addGap(18)
									.addComponent(commonUnkonwRadioButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(submitButton)
							.addGap(105)
							.addComponent(resetBbutton)))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(commonNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(commonPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(commonUnkonwRadioButton)
						.addComponent(commonFemalRadioButton)
						.addComponent(commonManRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetBbutton))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void commonAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String commonName = commonNameTextField.getText().toString();
		String commonPassword = commonPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(commonName)) {
			JOptionPane.showMessageDialog(this, "请填写用户名！");
			return;
		}
		if(StringUtil.isEmpty(commonPassword)) {
			JOptionPane.showMessageDialog(this, "请填写密码！");
			return;
		}
		String sex = commonManRadioButton.isSelected() ? commonManRadioButton.getText() : (commonFemalRadioButton.isSelected() ? commonFemalRadioButton.getText() : commonUnkonwRadioButton.getText());
		Common common = new Common();
		common.setName(commonName);
		common.setPassword(commonPassword);
		common.setSex(sex);
		CommonDao commonDao = new CommonDao();
		if(commonDao.addCommon(common)){
			JOptionPane.showMessageDialog(this, "添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "添加失败！");
		}
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		commonNameTextField.setText("");
		commonPasswordTextField.setText("");
		sexButtonGroup.clearSelection();//按钮组清空
		commonManRadioButton.setSelected(true);
		
	}
}
