package com.zc.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间效用工具
 * 
 * @author chenrs
 * 
 */
public class DateUtil {
	public final static String DEFAULT_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public final static String ORACLE_TIME_PATTERN = "yyyy-mm-dd hh24:mi:ss";

	/**
	 * 添加几天
	 * 
	 * @param time
	 * @param field
	 * @param amount
	 * @return
	 */
	public static Date add(Date time, int field, int amount) {
		Calendar c = java.util.Calendar.getInstance(Locale.CHINA);
		c.setTime(time);
		c.add(field, amount);
		return c.getTime();
	}

	/**
	 * 将时间转换为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, DEFAULT_TIME_PATTERN);
	}

	/**
	 * 将时间转换为字符串
	 * 
	 * @param date
	 * @param parttern
	 * @return
	 */
	public static String format(Date date, String parttern) {
		if (date == null) {
			return null;
		}
		if (parttern == null) {
			parttern = DEFAULT_TIME_PATTERN;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(parttern);
		return dateFormat.format(date);
	}
	
	/**
	 * 切换 时间字符串 样式
	 * yyyyMMdd yyyy-MM-dd
	 * @param date
	 * @param parttern1
	 * @param parttern2
	 * @return
	 */
	public static String changeStyle(String date, String parttern1,String parttern2) {
		if (date == null) {
			return null;
		}
		if (parttern2 == null) {
			parttern2 = DEFAULT_TIME_PATTERN;
		}
		return format(parse(date, parttern1), parttern2);
	}
	/**
	 * 自定义显示时间样式 xxxx年xx月xx日/xxxx年第x季度
	 * @param date
	 * @return
	 */
	public static String formatDateStyle(String date){
		date = date.trim();
		String dateStr = "";
		if(date != null && !"".equals(date)){
			int len = date.length();
			switch(len){
			case 4:
				dateStr = date+"年";
				break;
			case 5:
				dateStr = date.substring(0,4)+"年第"+date.substring(4,5)+"季度";
				break;
			case 6:
				dateStr = date.substring(0,4)+"年"+date.substring(4,6)+"月";
				break;
			case 8:
				dateStr = date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6,8)+"日";
				break;
			default:
				dateStr = date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6,8)+"日";
				break;
			}
		}
		return dateStr;
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date parse(String date) {
		return parse(date, DEFAULT_TIME_PATTERN);
	}

	/**
	 * 
	 * @param date
	 * @param parttern
	 * @return
	 */
	public static Date parse(String date, String parttern) {
		if (date == null) {
			throw new IllegalArgumentException("Date parameter is required.");
		}
		if (parttern == null) {
			parttern = DEFAULT_TIME_PATTERN;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(parttern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获得当前月份.
	 * @return
	 */
	public static int getCurrentMonth(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}
	/**
	 * 获得当前年份.
	 * @return
	 */
	public static int getCurrentYear(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}
	/**
	 * 获得上个月份.
	 * @return
	 */
	public static int getLastMonth(){
		Calendar cal = Calendar.getInstance();
		cal.add(cal.MONTH,-1);//得到上个月的月份   
		return cal.get(Calendar.MONTH) + 1;
	}
	/**
	 * 获得上个月所属的年份.
	 * @return
	 */
	public static int getLastYearForLastMonth(){
		Calendar cal = Calendar.getInstance();
		cal.add(cal.MONTH,-1);//得到上个月的月份   
		return cal.get(Calendar.YEAR);
	}
	
	public static String getNowDateTime() {
		return String.valueOf(new Timestamp(new Date().getTime()));
	}
	public static Timestamp getNowStampDateTime() {
		return new Timestamp(new Date().getTime());
	}
	/*public static void main(String arg[]){
		String str="2012-01-11 10:10:20.0";
		Date date = parse(str,"yyyy-mm-dd");
		String result = format(date,"yyyy-mm-dd");
		System.out.println(format(date,"yyyy-mm-dd"));
	}*/
	public static String formatToDay(String str){
		Date date = parse(str,"yyyy-mm-dd");
		String result = format(date,"yyyy-mm-dd");
		return result;
	}
	public static String formatToMonth(String str){
    	Date date = parse(str,"yyyy-mm-dd");
		String result = format(date,"yyyy-mm");
		return result;
	}
	public static String formatToSeason(String str){
    	Date date = parse(str,"yyyy-mm-dd");
		String result = format(date,"yyyy-q");
		return result;
	}
    public static String formatToYear(String str){
    	Date date = parse(str,"yyyy-mm-dd");
		String result = format(date,"yyyy");
		return result;
	}
    public static String formatToAll(String str,String parttern){
    	Date date = parse(str,parttern);
		String result = format(date,parttern);
		return result;
	}
    /**
     * 得到输入日期的年份
     * 
     * @param date
     * @return
     */
    public static int getYear(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int year = cal.get(Calendar.YEAR);
        return year;
    }
 
    /**
     * 得到一天是一年中的第几周
     * 
     * @param date
     * @return
     */
    public static int getWeek(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        return week;
    }
 
    /**
     * 得到一天是一年的第几个月
     * 
     * @param date
     * @return
     */
    public static int getMonth(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }
    /**
     * 得到一天是一年的第几个季度
     * 
     * @param date
     * @return
     */
    public static int getQuarter(String date) {
        int month = getMonth(date);
        int quarter;
        switch (month) {
            case 1:
            case 2:
            case 3:
                quarter = 1;
                break;
            case 4:
            case 5:
            case 6:
                quarter = 2;
                break;
            case 7:
            case 8:
            case 9:
                quarter = 3;
                break;
            case 10:
            case 11:
            case 12:
                quarter = 4;
                break;
            default:
                quarter = 0;
                break;
        }
 
        return quarter;
    }
    /**
     * 获取某一年的上一年
     * @param year
     * @return
     */
    public static String getLastYear(String year){
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        try {
            cal.setTime(format.parse(year));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int y = cal.get(Calendar.YEAR) - 1;
        return String.valueOf(y);
    }
    /**
     * 获取某年某月的上一年月，如：传参为201202，返回201201，
     * @param yearMonth
     * @return
     */
    public static String getCurrentYearLastMonth(String yearMonth){
    	String year = yearMonth.substring(0,4);
    	String month = yearMonth.substring(4);
    	String result = "";
    	if(month.startsWith("0")){
    		month = month.substring(1);
    	}
        if(month.length()==1){
        	if(month.equals("1")){
        		month = "12";
        		year = String.valueOf(Integer.parseInt(year)-1);
        	}else{
        		month = "0"+String.valueOf(Integer.parseInt(month)-1);
        	}
        }else{
        	month = String.valueOf(Integer.parseInt(month)-1);
        	if(month.length() == 1){
        		month = "0"+month;
        	}
        }
        result = year+month;
        return result;
    }
    /**
     * 获取某年某月的上一年当前月，如：传参为201202，返回201102，
     * @param yearMonth
     * @return
     */
    public static String getLastYearCurrentMonth(String yearMonth){
    	String year = yearMonth.substring(0,4);
    	String month = yearMonth.substring(4);
    	String result = "";
        result = String.valueOf(Integer.parseInt(year)-1)+month;
        return result;
    }
    /**
     * 获得指定日期的后一天
     * 
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }

    public static void main(String []arg){    	
    	Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        System.out.println(dayAfter);
        //return String.valueOf(y);
    }
    /**
     * 获得指定日期的前一天
     * 
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }
    /**  
     * 功能：判断输入年份是否为闰年<br>  
     * @param year  
     * @return 是：true  否：false  
     * @author pure  
     */  
   public static boolean leapYear(String yearNow) { 
	   int year =  Integer.parseInt(yearNow); 
       boolean leap;   
       if (year % 4 == 0) {   
           if (year % 100 == 0) {   
               if (year % 400 == 0) leap = true;   
                   else leap = false;   
               }   
           else leap = true;   
       }   
       else leap = false;   
       return leap;   
    }   
}
