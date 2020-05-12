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
 * 普通操作员数据库操作
 * @author lex
 *
 */
public class CommonDao extends BaseDao {
	public boolean addCommon (Common common) {
		String sql = "insert into s_common values(null,?,?,?)"; //添加语句
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, common.getName());
			preparedStatement.setString(2, common.getPassword());
			preparedStatement.setString(3, common.getSex()); //从界面中获取名字、密码、性别
			if(preparedStatement.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//登录方法
	public Common login(Common common) {
		String sql = "select * from s_common where name=? and password=?";           //sql语句
		Common Rst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);  //把sql语句传给数据库操作对象
			prst.setString(1, common.getName());
			prst.setString(2, common.getPassword());
		    ResultSet executeQuery = prst.executeQuery();  //调用对象执行sql语句，之后返回Result
			if(executeQuery.next()){                           //判断Result的下一个值是否有值，有值说明用户、密码正确
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
	
	//将普通操作员信息从数据库中拿出来
	public List<Common> getCommonList(Common common){    //声明一个泛型类、泛型方法
		List<Common> retList = new ArrayList<Common>();   //泛型的使用**，存放网络信息
		String sqlString = "select * from s_common";      //在数据库中查找
		//判断数据库中是否有数据
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
				retList.add(c);//拿出来后存储在retList中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return retList;
	}
	//将数据库中对应的用户信息删除
		public boolean delete(int id){
			String sql = "delete from s_common where id = ?";
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
		//更新用户信息数据库
		public boolean update (Common c) {
			String sql = "update s_common set name = ?, sex = ?, password = ? where id = ?";
			try {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, c.getName());
				preparedStatement.setString(2, c.getSex());
				preparedStatement.setString(3, c.getPassword());
				preparedStatement.setInt(4, c.getId());//设置参数值
				if(preparedStatement.executeUpdate() > 0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//密码修改方法
		public String editPassword(Common common, String newPassword) {
			//操作数据库修改用户密码
			String sql = "select * from s_common where name=? and password=?";//数据库查询
			PreparedStatement prst = null;
			int id = 0;
		    try {
		    	prst = con.prepareStatement(sql);  //把sql查询语句传给数据库操作对象
				prst.setString(1, common.getName()); 
				prst.setString(2, common.getPassword());
			    ResultSet executeQuery = prst.executeQuery();
		    	if(!executeQuery.next()) {
					String retString = "旧密码错误!";
					return retString;
				}
		    	id = executeQuery.getInt("id");//将数据库中的id赋值给id变量
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String retString = "修改失败";
			String sqlString = "update s_common set password = ? where id = ?";
		
			try {
				prst = con.prepareStatement(sqlString);  //把sql语句传给数据库操作对象
				prst.setString(1, newPassword);
				prst.setInt(2, id);
				int rst = prst.executeUpdate();
				if(rst > 0){
					retString = "密码修改成功！";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return retString;
		}
}
