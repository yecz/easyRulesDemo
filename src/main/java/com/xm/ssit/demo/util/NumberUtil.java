package com.xm.ssit.demo.util;


import com.xm.ssit.demo.exception.BusinessException;

import java.math.BigDecimal;

/**
 * @Auther: yechengzong
 * @Date: 2019/4/3 13:31
 * @Description:
 */
public class NumberUtil {

	public static int getIntegerFromObject(Object obj, Integer defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		if (obj instanceof Long) {
			return ((Long) obj).intValue();
		} else if (obj instanceof Integer) {
			return (Integer) obj;
		} else if (obj instanceof String) {
			return Integer.parseInt((String) obj);
		} else if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).intValue();
		} else {
			throw new BusinessException("类型转换异常");
		}

	}

	public static long getLongFromObject(Object obj, Long defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		if (obj instanceof Long) {
			return (Long) obj;
		} else if (obj instanceof Integer) {
			return (Long) obj;
		} else if (obj instanceof String) {
			return Long.parseLong((String) obj);
		} else if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).longValue();
		} else {
			throw new BusinessException("类型转换异常");
		}

	}

	public static BigDecimal getBigDecimalFromObject(Object obj, BigDecimal defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		if (obj instanceof Long) {
			return new BigDecimal((Long) obj);
		} else if (obj instanceof Integer) {
			return new BigDecimal((Integer) obj);
		} else if (obj instanceof String) {
			return new BigDecimal((String) obj);
		} else if (obj instanceof BigDecimal) {
			return (BigDecimal) obj;
		} else if (obj instanceof Double) {
			return new BigDecimal((Double) obj);
		} else if (obj instanceof Float) {
			return new BigDecimal((Float) obj);
		} else {
			throw new BusinessException("类型转换异常");
		}

	}

	public static Object getValueIfNullReturnDefault(Object value, Object defaultValue) {
		return value == null ? defaultValue : value;
	}
}
