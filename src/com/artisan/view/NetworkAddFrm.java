package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import com.artisan.dao.NetworkDao;
import com.artisan.model.Network;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NetworkAddFrm extends JInternalFrame {
	private JTextField networkNameTextField;
	private JTextArea networkInfoTextArea;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NetworkAddFrm frame = new NetworkAddFrm();
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
	public NetworkAddFrm() {
		setTitle("\u6DFB\u52A0\u7F51\u7EDC\u4FE1\u606F");
		setBounds(100, 100, 521, 338);
		setClosable(true); //设置可关闭
		setIconifiable(true);//可放大缩小
		
		JLabel label = new JLabel("\u7F51\u7EDC\u540D\u79F0");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u7F51\u7EDC\u4ECB\u7ECD");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		networkNameTextField = new JTextField();
		networkNameTextField.setColumns(10);
		
		networkInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitNetwork(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(NetworkAddFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(NetworkAddFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(submitButton))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(103)
									.addComponent(resetButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(networkNameTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
										.addComponent(networkInfoTextArea, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))))))
					.addGap(125))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(networkNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(networkInfoTextArea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitNetwork(ActionEvent ae) {
		// TODO Auto-generated method stub
		String networkName = networkNameTextField.getText().toString();
		String networkInfo = networkInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(networkName)){
			JOptionPane.showMessageDialog(this, "网络名称不能为空！");
			return;
		}
		Network n1 = new Network();
		n1.setName(networkName);
		n1.setInfo(networkInfo);
		NetworkDao networkDao = new NetworkDao();
		if(networkDao.addNetwork(n1)){
			JOptionPane.showMessageDialog(this, "网络添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "网络添加失败！");
		}
		networkDao.closeDao();//优化--释放数据库资源
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		networkNameTextField.setText("");
		networkInfoTextArea.setText("");
		
	}
}
