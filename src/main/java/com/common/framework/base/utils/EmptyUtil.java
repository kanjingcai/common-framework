package com.common.framework.base.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * 对"空"的判断公共方法
 * 
 * */
public class EmptyUtil {

	/**
	 * 判断Object是否不为空,先判断是否不为null，为null返回false;不为null 继续判断toString()是否不为空
	 * 
	 * */
	public static <T> boolean isNotEmpty(Object value) {
		if (NullUtil.isNotNull(value)) {
			if (EmptyUtil.isEmpty(value.toString())) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断List是否不为空
	 * 
	 * */
	public static <T> boolean isNotEmpty(List<T> lists) {
		if (NullUtil.isNotNull(lists)) {
			if (lists.isEmpty()) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断Set是否不为空
	 * 
	 * */
	public static <T> boolean isNotEmpty(Set<T> sets) {
		if (NullUtil.isNotNull(sets)) {
			if (sets.isEmpty()) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断数组是否不为空
	 * */
	public static <T> boolean isNotEmpty(T[] datas) {
		if (NullUtil.isNotNull(datas)) {
			if (datas.length == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否不为空
	 * 
	 * */
	public static boolean isNotEmpty(String datas) {
		if (NullUtil.isNotNull(datas)) {
			if ("".equals(datas.trim())) {
				return false;
			} else if (StringUtils.isBlank(datas)) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断Map是否不为空
	 * 
	 * */
	public static boolean isNotEmpty(Map<?, ?> datas) {
		return !isEmpty(datas);
	}

	/**
	 * 判断字符串不能为空，且不能为“undefined”，主要是在js选择后验证，可以调用此方法
	 * 
	 * */
	public static boolean isNotUndefinedChars(String value) {
		if (isNotEmpty(value)) {
			if ("undefined".equals(value.trim().toLowerCase())) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串不能为空，且不能为“null”，主要是在js选择后验证，可以调用此方法
	 * 
	 * */
	public static boolean isNotNullChars(String value) {
		if (isNotEmpty(value)) {
			if ("null".equals(value.trim().toLowerCase())) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串不能为空，且不能为“null”和“undefined”，主要是在js选择后验证，可以调用此方法
	 * 
	 * */
	public static boolean isNotEmptyChars(String value) {
		if (isNotUndefinedChars(value) && isNotNullChars(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断List是否为空
	 * 
	 * */
	public static <T> boolean isEmpty(List<T> lists) {
		if (NullUtil.isNull(lists)) {
			return true;
		} else if (lists.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断Set是否为空
	 * 
	 * */
	public static <T> boolean isEmpty(Set<T> sets) {
		if (NullUtil.isNull(sets)) {
			return true;
		} else if (sets.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断数组是否为空
	 * 
	 * */
	public static <T> boolean isEmpty(T[] datas) {
		if (NullUtil.isNull(datas)) {
			return true;
		} else if (datas.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * */
	public static boolean isEmpty(String datas) {
		if (NullUtil.isNull(datas)) {
			return true;
		} else if ("".equals(datas.trim())) {
			return true;
		} else if (StringUtils.isBlank(datas)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断Map是否为空
	 * 
	 * */
	public static boolean isEmpty(Map<?, ?> datas) {
		return ((datas == null) || (datas.isEmpty()));
	}

	/**
	 * 判断字符串为空，或为“undefined”，主要是在js选择后验证，可以调用此方法
	 * 
	 * @author LiuJun
	 * */
	public static boolean isUndefinedChars(String value) {
		if (isEmpty(value)) {
			return true;
		} else if ("undefined".equals(value.trim().toLowerCase())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串为空，或为“null”，主要是在js选择后验证，可以调用此方法
	 * 
	 * */
	public static boolean isNullChars(String value) {
		if (isEmpty(value)) {
			return true;
		} else if ("null".equals(value.trim().toLowerCase())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串为空，或为“null”和“undefined”，主要是在js选择后验证，可以调用此方法
	 * 
	 * */
	public static boolean isEmptyChars(String value) {
		if (isNullChars(value) || isUndefinedChars(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断Object是否不为空,先判断是否不为null，为null返回false;不为null 继续判断toString()是否不为空
	 * 
	 * */
	public static <T> boolean isEmpty(Object value) {
		if (NullUtil.isNull(value)) {
			return true;
		} else if (EmptyUtil.isEmpty(value.toString())) {
			return true;
		}
		return false;
	}
}
