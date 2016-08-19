package com.zj.book.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 
	 * @param h	小时
	 * @param m	分钟
	 * @param s	秒钟
	 * @return 返回指定日期时间的long值
	 */
	public static long getDate(int h,int m,int s){
		Calendar c = Calendar.getInstance();
		return getDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), h, m, s);
	}
	
	/**
	 * 
	 * @param y
	 * @param m
	 * @param d
	 * @param h
	 * @param mm
	 * @param s
	 * @return 获得指定时间的long值
	 */
	public static long getDate(int y,int m, int d, int h, int mm,int s){
		
		Calendar c = Calendar.getInstance();
		
		c.set(y, m-1, d, h, mm, s);
		
		return c.getTimeInMillis();
	}
	
	//获得当前时间的long值
	public static long getDate(){
		Calendar c = Calendar.getInstance();
		return getDate(c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND));
	}
	
	public static String formatByDate(Date date, String format){
		SimpleDateFormat simple = new SimpleDateFormat(format);
		return simple.format(date);
	}
	
	public static String formatByDate(Date date){
		return formatByDate(date, "yyyy-MM-DD HH:mm:ss");
	}
}
