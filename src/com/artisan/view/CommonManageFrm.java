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
		
		setClosable(true); //设置可关闭
		setIconifiable(true);//可放大缩小
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u666E\u901A\u64CD\u4F5C\u5458\u540D\u79F0");
		
		searchCommonNameTextField = new JTextField();
		searchCommonNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//查询普通操作员
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
		
		//从多个选择中只选一个
	    ButtonGroup sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(editCommonManRadioButton);
		sexButtonGroup.add(editCommonFamelRadioButton);
		sexButtonGroup.add(editCommonUnkownRadioButton);
		
		JButton submitEditButton = new JButton("\u4FEE\u6539\u7528\u6237");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//修改用户信息
				submitEditCommon(ae);
			}
		});
		
		deleteCommonButton = new JButton("\u5220\u9664\u7528\u6237");
		deleteCommonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//删除选中的用户
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
				//鼠标监听
				DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();
				//选中要修改的用户,并显示在修改框中
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

		setTable(new Common());//用户列表初始化，一打开列表按钮就显示所有用户
		setAuthority();//限制权限
	}

	protected void submitEditCommon(ActionEvent ae) {
		// TODO Auto-generated method stub
		String commonName = editCommonNameTextField.getText().toString();
		String commonPassword = editCommonPasswordTextField.getText().toString();
		int row = commonListTable.getSelectedRow();//获取选中的行号
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的信息！");
			return;
		}
		if(StringUtil.isEmpty(commonName)) {
			JOptionPane.showMessageDialog(this, "请输入名称！");
			return;
		}
		if(StringUtil.isEmpty(commonPassword)) {
			JOptionPane.showMessageDialog(this, "请输入密码！");
			return;
		}
		
		Common common = new Common();
		common.setId(Integer.parseInt(commonListTable.getValueAt(row, 0).toString()));//获取选中的信息的id，然后用id在数据库中查找其他信息！
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
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		commonDao.closeDao();
		setTable(new Common());
	}

	protected void deleteCommonAct() {
		// TODO Auto-generated method stub
		int index = commonListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的网络信息！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除吗？") != JOptionPane.OK_OPTION){
			return;
		}
		
		DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(commonListTable.getSelectedRow(), 0).toString());// Integer.parseInt()是把()里的内容转换成整数。
		CommonDao commonDao = new CommonDao();
		if(commonDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		commonDao.closeDao();
		setTable(new Common());//刷新列表信息
	}

	protected void searchCommon(ActionEvent ae) {
		// TODO Auto-generated method stub
		//用户查询
		Common common = new Common();
		common.setName(searchCommonNameTextField.getText().toString());
		setTable(common);
	}
	
	private void setTable(Common common){
	
		DefaultTableModel dft = (DefaultTableModel) commonListTable.getModel();//获取列表的模型
		dft.setRowCount(0);//先清空列表
		CommonDao commonDao = new CommonDao();
		List<Common> commonList = commonDao.getCommonList(common);
		//遍历列表
		for (Common c : commonList){
			Vector vector = new Vector();
			vector.add(c.getId());
			vector.add(c.getName());
			vector.add(c.getSex());
			vector.add(c.getPassword());
			dft.addRow(vector);//按顺序给列表模型填充数据
		}
		commonDao.closeDao();
	}
	//角色权限分配方法，（初始化之后调用）
	private void setAuthority() {
		if("普通操作员".equals(MainFrm.userType.getName())) {
			Common c = (Common)MainFrm.userObject;
			
			searchCommonNameTextField.setText(c.getName());
			searchCommonNameTextField.setEditable(false);
			deleteCommonButton.setEnabled(false);

			Common common = new Common();  //不够精确
			common.setId(c.getId());
			common.setName(c.getName());
			common.setPassword(c.getPassword());
			common.setSex(c.getSex());
			setTable(common);
			
		}
		
	}
}
