package com.common.framework.base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
/**
 * 交易订单号生成工具类
 *
 */
public class OrderNumberUtil {

	public static Random random = new Random();

	/**
	 * 生成27位数的交易号
	 * @return
	 */
	public static synchronized String get27OrderNumber() {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String str = localSimpleDateFormat.format(Calendar.getInstance().getTime());
		return str + getRandomNumber(10);
	}
	
	
	/**
	 * 生成22位数的交易号
	 * @return
	 */
	public static synchronized String get22OrderNumber() {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String str = localSimpleDateFormat.format(Calendar.getInstance().getTime());
		return str + getRandomNumber(5);
	}

	public static String getRandomNumber(int paramInt) {
		String str = String.valueOf(Math.abs(random.nextLong()));
		while (str.length() < paramInt) {
			str = str + String.valueOf(Math.abs(random.nextLong()));
		}
		return str.substring(0, paramInt);
	}
	
	
}
