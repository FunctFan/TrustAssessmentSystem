package com.artisan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.artisan.util.DbUtil;

/**
 * 
 * @author lex
 * �������ݿ����
 * ��ȡDbUtil�����������ݿ�����ӣ�Ȼ�󴫸���Ҫ�����ݿ�򽻵���model
 * ���������ݿ����Ӷ���������Ŀ�����ݿ�򽻵�������һ������
 * �������������ݿ�ֱ�ӽ���
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	
	//�Ż�--�ͷ���Դ
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
