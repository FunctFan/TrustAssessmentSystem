package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;

public class AddEdgeNodeFrm extends JInternalFrame {
	private JTextField edgeNodeNameTextField;
	private JTextField edgeNodeTrustValueTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddEdgeNodeFrm frame = new AddEdgeNodeFrm();
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
	public AddEdgeNodeFrm() {
		setTitle("\u6DFB\u52A0\u8FB9\u7F18\u8282\u70B9");
		setBounds(100, 100, 450, 365);
		
		JLabel label = new JLabel("\u8FB9\u7F18\u8282\u70B9");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u7F51\u7EDC");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u4FE1\u4EFB\u503C");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u4FE1\u4EFB\u7B49\u7EA7");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		edgeNodeNameTextField = new JTextField();
		edgeNodeNameTextField.setColumns(10);
		
		edgeNodeTrustValueTextField = new JTextField();
		edgeNodeTrustValueTextField.setColumns(10);
		
		JComboBox edgeNodeNetworkComboBox = new JComboBox();
		
		JRadioButton edgeNodeTypeRadioButton = new JRadioButton("\u4E0D\u53EF\u4FE1");
		edgeNodeTypeRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JRadioButton edgeNodeTypeRadioButton_1 = new JRadioButton("\u4E0D\u786E\u5B9A");
		edgeNodeTypeRadioButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JRadioButton edgeNodeTypeRadioButton_2 = new JRadioButton("\u53EF\u4FE1");
		edgeNodeTypeRadioButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton button = new JButton("\u786E\u8BA4");
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(67)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(edgeNodeNameTextField)
										.addComponent(edgeNodeTrustValueTextField)
										.addComponent(edgeNodeNetworkComboBox, 0, 194, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(22)
									.addComponent(edgeNodeTypeRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(edgeNodeTypeRadioButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(edgeNodeTypeRadioButton_2))))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(edgeNodeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(edgeNodeNetworkComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(edgeNodeTrustValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(edgeNodeTypeRadioButton)
						.addComponent(edgeNodeTypeRadioButton_1)
						.addComponent(edgeNodeTypeRadioButton_2))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
