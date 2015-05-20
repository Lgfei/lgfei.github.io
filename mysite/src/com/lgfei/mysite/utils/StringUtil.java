package com.lgfei.mysite.utils;

public class StringUtil {

	public static boolean isNullOrEmpty(String paramStr){
		return (null == paramStr || paramStr.trim().length() == 0) ? true : false;
	}
}
