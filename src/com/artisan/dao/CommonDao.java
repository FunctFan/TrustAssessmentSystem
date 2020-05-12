package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Admin;
import com.artisan.model.Common;
import com.artisan.model.Network;
import com.artisan.util.StringUtil;
 

/**
 * ��ͨ����Ա���ݿ����
 * @author lex
 *
 */
public class CommonDao extends BaseDao {
	public boolean addCommon (Common common) {
		String sql = "insert into s_common values(null,?,?,?)"; //������
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, common.getName());
			preparedStatement.setString(2, common.getPassword());
			preparedStatement.setString(3, common.getSex()); //�ӽ����л�ȡ���֡����롢�Ա�
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//��¼����
	public Common login(Common common) {
		String sql = "select * from s_common where name=? and password=?";           //sql���
		Common Rst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);  //��sql��䴫�����ݿ��������
			prst.setString(1, common.getName());
			prst.setString(2, common.getPassword());
		    ResultSet executeQuery = prst.executeQuery();  //���ö���ִ��sql��䣬֮�󷵻�Result
			if(executeQuery.next()){                           //�ж�Result����һ��ֵ�Ƿ���ֵ����ֵ˵���û���������ȷ
				Rst = new Common();
				Rst.setId(executeQuery.getInt("id"));
				Rst.setName(executeQuery.getString("name"));
				Rst.setPassword(executeQuery.getString("password"));
				Rst.setSex(executeQuery.getString("sex"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Rst;
	}
	
	//����ͨ����Ա��Ϣ�����ݿ����ó���
	public List<Common> getCommonList(Common common){    //����һ�������ࡢ���ͷ���
		List<Common> retList = new ArrayList<Common>();   //���͵�ʹ��**�����������Ϣ
		String sqlString = "select * from s_common";      //�����ݿ��в���
		//�ж����ݿ����Ƿ�������
		if(!StringUtil.isEmpty(common.getName())){  
			sqlString += " where name like '%"+common.getName()+"%'"; 
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Common c = new Common();
				c.setId(executeQuery.getInt("id"));
				c.setName(executeQuery.getString("name"));
				c.setSex(executeQuery.getString("sex"));
				c.setPassword(executeQuery.getString("password"));
				retList.add(c);//�ó�����洢��retList��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return retList;
	}
	//�����ݿ��ж�Ӧ���û���Ϣɾ��
		public boolean delete(int id){
			String sql = "delete from s_common where id = ?";
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setInt(1, id);//���ò���ֵ
				if(preparedStatement.executeUpdate() > 0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//�����û���Ϣ���ݿ�
		public boolean update (Common c) {
			String sql = "update s_common set name = ?, sex = ?, password = ? where id = ?";
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, c.getName());
				preparedStatement.setString(2, c.getSex());
				preparedStatement.setString(3, c.getPassword());
				preparedStatement.setInt(4, c.getId());//���ò���ֵ
				if(preparedStatement.executeUpdate() > 0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//�����޸ķ���
		public String editPassword(Common common, String newPassword) {
			//�������ݿ��޸��û�����
			String sql = "select * from s_common where name=? and password=?";//���ݿ��ѯ
			PreparedStatement prst = null;
			int id = 0;
		    try {
		    	prst = con.prepareStatement(sql);  //��sql��ѯ��䴫�����ݿ��������
				prst.setString(1, common.getName()); 
				prst.setString(2, common.getPassword());
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
			String sqlString = "update s_common set password = ? where id = ?";
		
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
