package com.artisan.util;
//封装的工具类:判断字符串是否为空的方法
public class StringUtil {
	public static boolean isEmpty(String str){
		if("".equals(str) || str == null){    //str.equals("")  //这样写容易抛异常
			return true;
		}
		return false;
	}
}
