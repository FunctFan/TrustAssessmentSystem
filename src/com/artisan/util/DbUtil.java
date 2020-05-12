package com.artisan.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author lex
 * 	数据库工具类
 *	与数据库建立连接
 *创建数据库连接类
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_trust?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	private String dbUserName="root"; // 用户名
	private String dbPassword="123456"; // 密码
	private String jdbcName="com.mysql.jdbc.Driver"; // 驱动名称
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);    //找到导入的jar包
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);  //调用该jar包的getConnection方法，传入连接、用户名、密码
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;     //返回数据库连接对象
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	// 创建测试对象，测试数据库连接是否成功
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
