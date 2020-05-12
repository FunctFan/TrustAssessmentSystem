package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.artisan.model.Admin;


/**
 * 
 * @author lex
 * ���ݿ����
 *
 */
public class AdminDao extends BaseDao { 
	/**
	 * ����Ա��¼
	 */
	//��¼����
	public Admin login(Admin admin) {
		String sql = "select * from s_admin where id=? and password=?";           //sql���
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);  //��sql��䴫�����ݿ��������
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
		    ResultSet executeQuery = prst.executeQuery();  //���ö���ִ��sql��䣬֮�󷵻�Result
			if(executeQuery.next()){                           //�ж�Result����һ��ֵ�Ƿ���ֵ����ֵ˵���û���������ȷ
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adminRst;
	}
	//�����޸ķ���
	public String editPassword(Admin admin, String newPassword) {
		//�������ݿ��޸��û�����
		String sql = "select * from s_admin where id=? and password=?";//���ݿ��ѯ
		PreparedStatement prst = null;
		int id = 0;
	    try {
	    	prst = con.prepareStatement(sql);  //��sql��ѯ��䴫�����ݿ��������
			prst.setInt(1, admin.getId()); 
			prst.setString(2, admin.getPassword());
		    ResultSet executeQuery = prst.executeQuery();
	    	if(!executeQuery.next()) {
				String retString = "���������!";
				return retString;
			}
	    	id = executeQuery.getInt("id");//�����ݿ��е�id��ֵ��id����
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String retString = "�޸�ʧ��";
		String sqlString = "update s_admin set password = ? where id = ?";
	
		try {
			prst = con.prepareStatement(sqlString);  //��sql��䴫�����ݿ��������
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "�����޸ĳɹ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retString;
	}
}
