package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import java.util.List;
import java.util.Vector;

import com.artisan.dao.CommonDao;
import com.artisan.model.Common;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

public class CommonManageFrm extends JInternalFrame {
	private JTextField searchCommonNameTextField;
	private JTable commonListTable;
	private JTextField editCommonNameTextField;
	private JRadioButton editCommonManRadioButton;
	private JRadioButton editCommonFamelRadioButton;
	private JRadioButton editCommonUnkownRadioButton;
	private ButtonGroup sexButtonGroup;
	private JPasswordField editCommonPasswordTextField;
	private JButton deleteCommonButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CommonManageFrm frame = new CommonManageFrm();
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
	public CommonManageFrm() {
		setTitle("\u666E\u901A\u64CD\u4F5C\u5458\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 789, 550);
		
		setClosable(true); //���ÿɹر�
		setIconifiable(true);//�ɷŴ���С
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u666E\u901A\u64CD\u4F5C\u5458\u540D\u79F0");
		
		searchCommonNameTextField = new JTextField();
		searchCommonNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//��ѯ��ͨ����Ա
				searchCommon(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(CommonManageFrm.class.getResource("/images/\u641C\u7D22.png")));
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		
		editCommonNameTextField = new JTextField();
		editCommonNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		
		editCommonManRadioButton = new JRadioButton("\u7537");
		editCommonManRadioButton.setSelected(true);
		
		editCommonFamelRadioButton = new JRadioButton("\u5973");
		
	    editCommonUnkownRadioButton = new JRadioButton("\u4FDD\u5BC6");
		
		//�Ӷ��ѡ����ֻѡһ��
	    ButtonGroup sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(editCommonManRadioButton);
		sexButtonGroup.add(editCommonFamelRadioButton);
		sexButtonGroup.add(editCommonUnkownRadioButton);
		
		JButton submitEditButton = new JButton("\u4FEE\u6539\u7528\u6237");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//�޸��û���Ϣ
				submitEditCommon(ae);
			}
		});
		
		deleteCommonButton = new JButton("\u5220\u9664\u7528\u6237");
		deleteCommonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//ɾ��ѡ�е��û�
				deleteCommonAct();
			}
		});
		
		editCommonPasswordTextField = new JPasswordField();

		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(label)
							.addGap(35)
							.addComponent(searchCommonNameTextField, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(92)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(editCommonNameTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(58)
									.addComponent(label_3))
								.addComponent(editCommonPasswordTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editCommonManRadioButton)
								.addComponent(editCommonUnkownRadioButton)
								.addComponent(editCommonFamelRadioButton))
							.addGap(67)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteCommonButton)
								.addComponent(submitEditButton))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchCommonNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editCommonNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editCommonManRadioButton)
						.addComponent(submitEditButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(editCommonFamelRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editCommonUnkownRadioButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(deleteCommonButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(editCommonPasswordTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		commonListTable = new JTable();
		commonListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				//������
				DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();
				//ѡ��Ҫ�޸ĵ��û�,����ʾ���޸Ŀ���
				editCommonNameTextField.setText(dft.getValueAt(commonListTable.getSelectedRow(), 1).toString());
				editCommonPasswordTextField.setText(dft.getValueAt(commonListTable.getSelectedRow(), 3).toString());
				String sex = dft.getValueAt(commonListTable.getSelectedRow(), 2).toString();
				if(sex.equals(editCommonManRadioButton.getText())) editCommonManRadioButton.setSelected(true);
				if(sex.equals(editCommonFamelRadioButton.getText())) editCommonFamelRadioButton.setSelected(true);
				if(sex.equals(editCommonUnkownRadioButton.getText())) editCommonUnkownRadioButton.setSelected(true);

			}
		});
		commonListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u6027\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		commonListTable.getColumnModel().getColumn(0).setPreferredWidth(113);
		commonListTable.getColumnModel().getColumn(1).setPreferredWidth(123);
		commonListTable.getColumnModel().getColumn(2).setPreferredWidth(119);
		commonListTable.getColumnModel().getColumn(3).setPreferredWidth(229);
		scrollPane.setViewportView(commonListTable);
		getContentPane().setLayout(groupLayout);

		setTable(new Common());//�û��б��ʼ����һ���б�ť����ʾ�����û�
		setAuthority();//����Ȩ��
	}

	protected void submitEditCommon(ActionEvent ae) {
		// TODO Auto-generated method stub
		String commonName = editCommonNameTextField.getText().toString();
		String commonPassword = editCommonPasswordTextField.getText().toString();
		int row = commonListTable.getSelectedRow();//��ȡѡ�е��к�
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ���Ϣ��");
			return;
		}
		if(StringUtil.isEmpty(commonName)) {
			JOptionPane.showMessageDialog(this, "���������ƣ�");
			return;
		}
		if(StringUtil.isEmpty(commonPassword)) {
			JOptionPane.showMessageDialog(this, "���������룡");
			return;
		}
		
		Common common = new Common();
		common.setId(Integer.parseInt(commonListTable.getValueAt(row, 0).toString()));//��ȡѡ�е���Ϣ��id��Ȼ����id�����ݿ��в���������Ϣ��
		common.setName(commonName);
		common.setPassword(commonPassword);
		
		if(editCommonManRadioButton.isSelected()) {
			common.setSex(editCommonManRadioButton.getText().toString());
		}
		if(editCommonFamelRadioButton.isSelected()) {
			common.setSex(editCommonFamelRadioButton.getText().toString());
		}
		if(editCommonUnkownRadioButton.isSelected()) {
			common.setSex(editCommonUnkownRadioButton.getText().toString());
		}
		CommonDao commonDao = new CommonDao();
		if(commonDao.update(common)) {
			JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
		}
		commonDao.closeDao();
		setTable(new Common());
	}

	protected void deleteCommonAct() {
		// TODO Auto-generated method stub
		int index = commonListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ����������Ϣ��");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "ȷ��ɾ����") != JOptionPane.OK_OPTION){
			return;
		}
		
		DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(commonListTable.getSelectedRow(), 0).toString());// Integer.parseInt()�ǰ�()�������ת����������
		CommonDao commonDao = new CommonDao();
		if(commonDao.delete(id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
		}
		commonDao.closeDao();
		setTable(new Common());//ˢ���б���Ϣ
	}

	protected void searchCommon(ActionEvent ae) {
		// TODO Auto-generated method stub
		//�û���ѯ
		Common common = new Common();
		common.setName(searchCommonNameTextField.getText().toString());
		setTable(common);
	}
	
	private void setTable(Common common){
	
		DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();//��ȡ�б��ģ��
		dft.setRowCount(0);//������б�
		CommonDao commonDao = new CommonDao();
		List<Common> commonList = commonDao.getCommonList(common);
		//�����б�
		for (Common c : commonList){
			Vector vector = new Vector();
			vector.add(c.getId());
			vector.add(c.getName());
			vector.add(c.getSex());
			vector.add(c.getPassword());
			dft.addRow(vector);//��˳����б�ģ���������
		}
		commonDao.closeDao();
	}
	//��ɫȨ�޷��䷽��������ʼ��֮����ã�
	private void setAuthority() {
		if("��ͨ����Ա".equals(MainFrm.userType.getName())) {
			Common c = (Common)MainFrm.userObject;
			
			searchCommonNameTextField.setText(c.getName());
			searchCommonNameTextField.setEditable(false);
			deleteCommonButton.setEnabled(false);

			Common common = new Common();  //������ȷ
			common.setId(c.getId());
			common.setName(c.getName());
			common.setPassword(c.getPassword());
			common.setSex(c.getSex());
			setTable(common);
			
		}
		
	}
}
