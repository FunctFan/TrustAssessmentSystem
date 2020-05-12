package com.artisan.view;

import java.awt.EventQueue;
import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.NetworkDao;
import com.artisan.model.Network;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NetworkManageFrm extends JInternalFrame {
	private JTextField searchNetworkNameTextField;
	private JTable networkListTable;
	private JTextField editNetworkNameTextField;
	private JTextArea editNetworkInfoTextArea;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NetworkManageFrm frame = new NetworkManageFrm();
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
	public NetworkManageFrm() {
		setTitle("\u7F51\u7EDC\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 888, 611);
		setClosable(true); //���ÿɹر�
		setIconifiable(true);//�ɷŴ���С
		
		JLabel label = new JLabel("\u7F51\u7EDC\u540D\u79F0");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		searchNetworkNameTextField = new JTextField();
		searchNetworkNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//��ѯ��ť
				Network n = new Network();
				n.setName(searchNetworkNameTextField.getText().toString());
				setTable(n);
			}
		});
		searchButton.setIcon(new ImageIcon(NetworkManageFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("\u7F51\u7EDC\u540D\u79F0");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u7F51\u7EDC\u4FE1\u606F");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editNetworkNameTextField = new JTextField();
		editNetworkNameTextField.setColumns(10);
		
		editNetworkInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u4FEE\u6539\u7F51\u7EDC");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//ȷ���޸İ�ť
				submitEditAct();
			}
		});
		submitEditButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664\u7F51\u7EDC");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//ɾ������
				deleteNetworkAct(ae);
			}
		});
		submitDeleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(113)
								.addComponent(label)
								.addGap(18)
								.addComponent(searchNetworkNameTextField, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
								.addGap(109)
								.addComponent(searchButton))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(127)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label_1)
									.addComponent(label_2))
								.addGap(26)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(editNetworkInfoTextArea)
									.addComponent(editNetworkNameTextField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(submitEditButton, Alignment.TRAILING)
									.addComponent(submitDeleteButton, Alignment.TRAILING))
								.addGap(32))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchNetworkNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editNetworkNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(submitDeleteButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(editNetworkInfoTextArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		networkListTable = new JTable();
		networkListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		networkListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F51\u7EDC\u7F16\u53F7", "\u7F51\u7EDC\u540D\u79F0", "\u7F51\u7EDC\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		networkListTable.getColumnModel().getColumn(2).setPreferredWidth(541);
		scrollPane.setViewportView(networkListTable);
		getContentPane().setLayout(groupLayout);
		
		setTable(new Network());//������Ϣ�б��ʼ��
	}

	//��ȡ���ݿ��е�����,�������б���
	private void setTable(Network network){
		DefaultTableModel dft = (DefaultTableModel) networkListTable.getModel();//��ȡ�б��ģ��
		dft.setRowCount(0);//������б�
		NetworkDao networkDao = new NetworkDao();
		List<Network> networkList = networkDao.getNetworkList(network);
		//�����б�
		for (Network n : networkList){
			Vector vector = new Vector();
			vector.add(n.getId());
			vector.add(n.getName());
			vector.add(n.getInfo());
			dft.addRow(vector);//��˳����б�ģ���������
		}
		networkDao.closeDao();
	}
	
	protected void deleteNetworkAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "ȷ��ɾ����") != JOptionPane.OK_OPTION){
			return;
		}
		int index = networkListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ����������Ϣ��");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) networkListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(networkListTable.getSelectedRow(), 0).toString());// Integer.parseInt()�ǰ�()�������ת����������
		NetworkDao networkDao = new NetworkDao();
		if(networkDao.delete(id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
		}
		networkDao.closeDao();
		setTable(new Network());//ˢ�������б���Ϣ
	}
	protected void submitEditAct() {
		// TODO Auto-generated method stub
		
		int index = networkListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�������Ϣ��");
			return;
		}		
		DefaultTableModel dft = (DefaultTableModel) networkListTable.getModel();
		String networkName = dft.getValueAt(networkListTable.getSelectedRow(), 1).toString();
		String networkInfo = dft.getValueAt(networkListTable.getSelectedRow(), 2).toString();
		String editNetworkName = editNetworkNameTextField.getText().toString();
		String editNetworkInfo = editNetworkInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editNetworkName)){
			JOptionPane.showMessageDialog(this, "����дҪ�޸ĵ����ƣ�");
			return;
		}
		if(networkName.equals(editNetworkName) && networkInfo.equals(editNetworkInfo)){
			JOptionPane.showMessageDialog(this, "û�����κ��޸ģ�");
			return;
		}
		NetworkDao networkDao = new NetworkDao();
		int id = Integer.parseInt(dft.getValueAt(networkListTable.getSelectedRow(), 0).toString());
		Network n = new Network();
		n.setId(id);
		n.setName(editNetworkName);
		n.setInfo(editNetworkInfo);
		if(networkDao.update(n)){
			JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
		}
		networkDao.closeDao();
		setTable(new Network());//ˢ�������б���Ϣ
		
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) networkListTable.getModel();
		//ѡ��Ҫ�޸ĵ�����,����ʾ���޸Ŀ���
		editNetworkNameTextField.setText(dft.getValueAt(networkListTable.getSelectedRow(), 1).toString());
		editNetworkInfoTextArea.setText(dft.getValueAt(networkListTable.getSelectedRow(), 2).toString());
	}
}
	
