package com.artisan.util;
//��װ�Ĺ�����:�ж��ַ����Ƿ�Ϊ�յķ���
public class StringUtil {
	public static boolean isEmpty(String str){
		if("".equals(str) || str == null){    //str.equals("")  //����д�������쳣
			return true;
		}
		return false;
	}
}
