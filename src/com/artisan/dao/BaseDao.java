package com.artisan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.artisan.util.DbUtil;

/**
 * 
 * @author lex
 * 创建数据库对象
 * 获取DbUtil建立的与数据库的连接，然后传给需要与数据库打交道的model
 * 创建对数据库连接对象，整个项目与数据库打交道都用这一个对象。
 * 方便属性与数据库直接交互
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	
	//优化--释放资源
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
