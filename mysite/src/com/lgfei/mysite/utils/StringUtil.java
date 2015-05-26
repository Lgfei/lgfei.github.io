package com.lgfei.mysite.utils;

public class StringUtil {

	public static boolean isNullOrEmpty(String paramStr){
		return (null == paramStr || paramStr.trim().length() == 0) ? true : false;
	}
	
	public static String upperFirstWord(String paramStr){
		if(isNullOrEmpty(paramStr)){
			return paramStr;
		}
		
		String firstWord = paramStr.substring(0, 1);
		return paramStr.replaceFirst(firstWord, firstWord.toUpperCase());
	}
}
