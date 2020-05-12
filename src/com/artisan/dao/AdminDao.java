package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.artisan.model.Admin;


/**
 * 
 * @author lex
 * 数据库操作
 *
 */
public class AdminDao extends BaseDao { 
	/**
	 * 管理员登录
	 */
	//登录方法
	public Admin login(Admin admin) {
		String sql = "select * from s_admin where id=? and password=?";           //sql语句
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);  //把sql语句传给数据库操作对象
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
		    ResultSet executeQuery = prst.executeQuery();  //调用对象执行sql语句，之后返回Result
			if(executeQuery.next()){                           //判断Result的下一个值是否有值，有值说明用户、密码正确
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
	//密码修改方法
	public String editPassword(Admin admin, String newPassword) {
		//操作数据库修改用户密码
		String sql = "select * from s_admin where id=? and password=?";//数据库查询
		PreparedStatement prst = null;
		int id = 0;
	    try {
	    	prst = con.prepareStatement(sql);  //把sql查询语句传给数据库操作对象
			prst.setInt(1, admin.getId()); 
			prst.setString(2, admin.getPassword());
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
		String sqlString = "update s_admin set password = ? where id = ?";
	
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
