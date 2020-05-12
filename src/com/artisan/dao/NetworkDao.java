package com.artisan.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Network;
import com.artisan.util.StringUtil;


/**
 * 
 * @author lex
 *	������Ϣ�����ݿ�Ĳ���
 */
public class NetworkDao extends BaseDao {
	//�������
	public boolean addNetwork(Network n1){
		String sql = "insert into s_network values(null,?,?)"; //������
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, n1.getName());
			preparedStatement.setString(2, n1.getInfo());
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	} 
	//��������Ϣ�����ݿ����ó���
	public List<Network> getNetworkList(Network network){    //����һ�������ࡢ���ͷ���
		List<Network> retList = new ArrayList<Network>();   //���͵�ʹ��**�����������Ϣ
		String sqlString = "select * from s_network";      //�����ݿ��в���
		//�ж����ݿ����Ƿ�������
		if(!StringUtil.isEmpty(network.getName())){  
			sqlString += " where name like '%"+network.getName()+"%'"; 
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Network n = new Network();
				n.setId(executeQuery.getInt("id"));
				n.setName(executeQuery.getString("name"));
				n.setInfo(executeQuery.getString("info"));
				retList.add(n);//�ó�����洢��retList��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return retList;
	}
	//�����ݿ��ж�Ӧ��������Ϣɾ��
	public boolean delete(int id){
		String sql = "delete from s_network where id = ?";
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
	//����������Ϣ���ݿ�
	public boolean update (Network n) {
		String sql = "update s_network set name = ?, info = ? where id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, n.getName());
			preparedStatement.setString(2, n.getInfo());
			preparedStatement.setInt(3, n.getId());//���ò���ֵ
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
