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
 *	网络信息与数据库的操作
 */
public class NetworkDao extends BaseDao {
	//添加网络
	public boolean addNetwork(Network n1){
		String sql = "insert into s_network values(null,?,?)"; //添加语句
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
	//将网络信息从数据库中拿出来
	public List<Network> getNetworkList(Network network){    //声明一个泛型类、泛型方法
		List<Network> retList = new ArrayList<Network>();   //泛型的使用**，存放网络信息
		String sqlString = "select * from s_network";      //在数据库中查找
		//判断数据库中是否有数据
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
				retList.add(n);//拿出来后存储在retList中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return retList;
	}
	//将数据库中对应的网络信息删除
	public boolean delete(int id){
		String sql = "delete from s_network where id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);//设置参数值
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//更新网络信息数据库
	public boolean update (Network n) {
		String sql = "update s_network set name = ?, info = ? where id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, n.getName());
			preparedStatement.setString(2, n.getInfo());
			preparedStatement.setInt(3, n.getId());//设置参数值
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
