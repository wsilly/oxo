package com.horets.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author 19777
 *
 */
public class DateUtil {
	private static SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private DateUtil() {}
	public static String getCurrentMills() {
		return sdf.format(new Date());
	}
}
