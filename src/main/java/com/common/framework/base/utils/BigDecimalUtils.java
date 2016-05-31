package com.common.framework.base.utils;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * ClassName: BigDecimalUtils <br/>
 * Function: BigDecimal 处理工具类. <br/>
 * date: 2015年7月24日 下午8:26:57 <br/>
 * 
 */
public class BigDecimalUtils {

	private static final int DEF_DIV_SCALE = 10;

	/**
	 * 判断是否为空或为0
	 * 
	 * @param v1
	 * @return
	 */
	public static boolean isNullOrZero(BigDecimal v1) {
		return v1 == null || v1.compareTo(BigDecimal.ZERO) == 0;
	}

	/**
	 * 加
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.add(v2);
	}

	/**
	 * 减
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.subtract(v2);
	}

	/**
	 * 乘
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.multiply(v2);
	}

	/**
	 * 除
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 除
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal div(BigDecimal v1, double v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		BigDecimal b2 = new BigDecimal(v2);
		return div(v1, b2, DEF_DIV_SCALE);
	}

	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}

		return v1.divide(v2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 四舍五入
	 * 
	 * @param v
	 * @param scale
	 * @return
	 */
	public static BigDecimal round(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		if (v == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	public static float convertsToFloat(BigDecimal v) {
		if (v == null) {
			return 0;
		}

		return v.floatValue();
	}

	public static int convertsToInt(BigDecimal v) {
		if (v == null) {
			return 0;
		}
		return v.intValue();
	}

	public static long convertsToLong(BigDecimal v) {
		if (v == null) {
			return 0;
		}
		return v.longValue();
	}

	public static BigDecimal returnMax(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.max(v2);
	}

	public static BigDecimal returnMin(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}
		return v1.min(v2);
	}

	/**
	 * 比较大小
	 * 
	 * @param v1
	 * @param v2
	 * @return 结果是-1 小于 0 等于 1 大于; v1小于v2返回-1,v1大于v2返回1,v1等于v2返回0
	 */
	public static int compareTo(BigDecimal v1, BigDecimal v2) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}

		if (v2 == null) {
			v2 = BigDecimal.ZERO;
		}

		return v1.compareTo(v2);
	}

	/**
	 * 转为string 类型
	 * 
	 * @param v1
	 *            保留两位小数
	 * @return
	 */
	public static String convertsToString(BigDecimal v1) {
		if (v1 == null) {
			return "0.00";
		}

		return v1.movePointLeft(2).toPlainString();
	}

	public static BigDecimal convertEmptytoZero(BigDecimal v) {
		if (v == null) {
			return BigDecimal.ZERO;
		}
		return v;
	}

	public static BigDecimal convertStringtBigDecimal(String v) {
		if (v == null) {
			return BigDecimal.ZERO;
		}
		return new BigDecimal(v);
	}

	public static BigDecimal converRate(Integer rate) {
		if (rate == null) {
			rate = 0;
		}
		double convertRate = Double.valueOf(rate) / 1000000;
		return new BigDecimal(convertRate);
	}

	public static BigDecimal converPercent(BigDecimal v1) {
		if (v1 == null) {
			v1 = BigDecimal.ZERO;
		}
		// 百分比乘以100
		BigDecimal rates = BigDecimalUtils.mul(v1, new BigDecimal("100"));
		BigDecimal result = BigDecimalUtils.converRate(BigDecimalUtils.convertsToInt(rates));
		return result;
	}

	public static BigDecimal moneyConvertYuan2Fen(BigDecimal bonusfee) {
		/*
		 * Integer fee = ObjectUtil.moneyConvertYuan2Fen(Double.valueOf(String
		 * .valueOf(bonusfee))); return new BigDecimal(fee);
		 */
		return mul(bonusfee, new BigDecimal("100"));
	}

	public static BigDecimal converRate(BigDecimal rate) {
		if (rate == null) {
			rate = BigDecimal.ZERO;
		}
		BigDecimal convertRate = rate.divide(new BigDecimal("1000000"));
		return convertRate;
	}

	/**
	 * 取反
	 * 
	 * @param value
	 * @return
	 */
	public static BigDecimal reverse(BigDecimal value) {
		return BigDecimalUtils.sub(BigDecimal.ZERO, value);
	}

	/**
	 * 将金额单位分转为元
	 * 
	 * @param amountFee
	 * @return
	 */
	public static BigDecimal moneyConvertFen2Yuan(BigDecimal amountFen) {
		if (amountFen == null || amountFen.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}
		return amountFen.divide(new BigDecimal(100));
	}

	/**
	 * 将金额单位分转为万元
	 * 
	 * @param amountFee
	 * @return
	 */
	public static BigDecimal moneyConvertFen2Wan(BigDecimal amountFen) {
		if (amountFen == null || amountFen.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}
		return amountFen.divide(new BigDecimal(1000000));
	}

	/**
	 * 取绝对值
	 * 
	 * @return
	 */
	public static BigDecimal countAbs(BigDecimal v) {
		return v == null ? BigDecimal.ZERO : v.abs();
	}

	/**
	 * 取反
	 * 
	 * @param v
	 * @return
	 */
	public static BigDecimal negate(BigDecimal v) {
		return v == null ? BigDecimal.ZERO : v.negate();
	}

	/**
	 * 格式化金额 以元为单位
	 * 
	 * @param amount
	 *            金额(必须能转成Number型的)
	 * @return 30格式成30.00返回
	 */
	public static String formartNumber(Object amount) {
		try {
			if (StringUtils.isBlank(amount.toString())) {
				return null;
			}
			BigDecimal b = new BigDecimal("" + amount);
			return String.format("%.2f", b.doubleValue());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 格式化金额 并将分转成元为单位
	 * 
	 * @param amount
	 *            金额(必须能转成Number型的)
	 * @return 30格式成30.00返回
	 */
	public static String formartNumberFen2Yuan(BigDecimal fen) {
		if (fen == null) {
			return "0.00";
		}
		return formartNumber(moneyConvertFen2Yuan(fen));
	}

	/**
	 * 格式化金额 并将元转成分为单位
	 * 
	 * @param amount
	 * @return
	 */
	public static BigDecimal formartNumberYuan2Fen(String amount) {
		if (StringUtils.isBlank(amount)) {
			return BigDecimal.ZERO;
		}
		return new BigDecimal(amount).multiply(new BigDecimal(100));
	}

	/**
	 * 乘法，最小值封底，最大值封顶
	 * 
	 * @param mult
	 *            [乘数]
	 * @param mulc
	 *            [被乘数]
	 * @param minv
	 *            [最小值]
	 * @param maxv
	 *            [最大值]
	 * @return
	 */
	public static BigDecimal mul(BigDecimal mult, BigDecimal mulc, BigDecimal minv, BigDecimal maxv) {
		BigDecimal v = mul(mult, mulc);
		v = v.compareTo(minv) < 0 ? minv : v.compareTo(maxv) > 0 ? maxv : v;
		return v;
	}
}
