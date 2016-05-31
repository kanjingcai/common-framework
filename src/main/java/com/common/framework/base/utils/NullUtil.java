package com.common.framework.base.utils;

/**
 * 对null的公共方法
 * 
 * */
public class NullUtil {
	/**
	 * 判断参数obj是否为null，如果obj为null,返回false；不为null，返回true
	 * 
	 * */
	public static boolean isNotNull(Object obj) {
		if (null == obj) {
			return false;
		}
		return true;
	}

	/**
	 * 判断参数obj是否为null，如果obj为null,返回true；不为null，返回false
	 * 
	 * */
	public static boolean isNull(Object obj) {
		if (null == obj) {
			return true;
		}
		return false;
	}
}
