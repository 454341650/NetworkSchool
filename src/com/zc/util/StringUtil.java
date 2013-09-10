package com.zc.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class StringUtil {
	/**
	 * 截取某字符串.
	 * 
	 * @param str
	 *            要截取的字符串
	 * @param prefix
	 *            开始字符
	 * @param suffix
	 *            结束字符
	 * @return
	 */
	public static String getMiddleString(String str, String prefix,
			String suffix) {
		int prefixIndex = str.indexOf(prefix);
		String result = null;

		if (-1 < prefixIndex) {
			str = str.substring(prefixIndex + prefix.length());

			if (suffix == null) {
				return str;
			}

			prefixIndex = str.indexOf(suffix);

			if (prefixIndex > 0) {
				result = str.substring(0, prefixIndex);
				str = str.substring(prefixIndex);
			}
		}

		return result;
	}

	/**
	 * 判断是否为空字符串.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		boolean b = false;

		if (null == s || 1 > s.trim().length()) {
			b = true;
		}

		return b;
	}

	public static List<String> stringArrayToList(String[] words, String sign) {
		if (null == words || 1 > words.length) {
			return Collections.emptyList();
		}

		List<String> wordList = new ArrayList<String>();

		for (String s : words) {
			if (!StringUtil.isEmpty(s)) {
				if (null != sign) {
					wordList.add(sign + StringUtil.trim(s) + sign);
				} else {
					wordList.add(StringUtil.trim(s));
				}
			}
		}

		return wordList;
	}

	public static List<String> stringToList(String str, String separator) {
		List<String> list = new ArrayList<String>();

		if (!StringUtil.isEmpty(str)) {
			String[] arr = str.split(separator);

			if (null != arr && 0 < arr.length) {
				for (String s : arr) {
					if (!StringUtil.isEmpty(s)) {
						list.add(s);
					}
				}
			}
		}

		return list;
	}

	public static List<String> stringToList(String str, String separator,
			String sign) {
		if (StringUtil.isEmpty(str) || null == separator) {
			return Collections.emptyList();
		}

		String[] words = StringUtil.trim(str).split(separator);

		if (null == words || 1 > words.length) {
			return Collections.emptyList();
		}

		List<String> wordList = new ArrayList<String>();

		for (String s : words) {
			if (!StringUtil.isEmpty(s)) {
				if (null != sign) {
					wordList.add(sign + StringUtil.trim(s) + sign);
				} else {
					wordList.add(StringUtil.trim(s));
				}
			}
		}

		return wordList;
	}

	public static String toStr(Object o) {
		String s = "";

		if (null != o) {
			s = o.toString();
		}

		return s;
	}

	public static String trim(String s) {
		if (isEmpty(s)) {
			return "";
		} else {
			return s.trim();
		}
	}

	/**
	 * list去重复.
	 * 
	 * @param arlList
	 */
	public static void removeListDuplicate(List<?> arlList)

	{

		Set set = new HashSet();

		List newList = new ArrayList();

		for (Iterator iter = arlList.iterator(); iter.hasNext();)

		{

			Object element = iter.next();

			if (set.add(element))
				newList.add(element);

		}

		arlList.clear();

		arlList.addAll(newList);

	}

	/**
	 * 格式化两位小数.
	 * 
	 * @param str
	 * @return
	 */
	public static String formatNumber(String str) {
		DecimalFormat df1 = new DecimalFormat("##.00");
		return df1.format(Double.parseDouble(str));
	}

	/**
	 * 格式化两位小数.
	 * 
	 * @param str
	 * @return
	 */
	public static String formatNumber(double str) {
		DecimalFormat df1 = new DecimalFormat("##.00");
		return df1.format(str);
	}

	/**
	 * 格式化两位小数(金融格式).
	 * 
	 * @param str
	 * @return
	 */
	public static String formatFinancial(String str) {
		DecimalFormat df1 = new DecimalFormat("##,##0.00");
		if(str == null || "".equals(str)){
			return "0.00";
		}
		return df1.format(Double.parseDouble(str));
	}

	/**
	 * 格式化两位小数(金融格式)..
	 * 
	 * @param str
	 * @return
	 */
	public static String formatFinancial(double str) {
		DecimalFormat df1 = new DecimalFormat("##,##0.00");
		return df1.format(str);
	}
	
	public static Double parseFinancial(String str) {
		if(str == null || "".equals(str)){
			return 0.0;
		}
		for(int i=0;i<str.length();i++){
	      int chr=str.charAt(i);
	      if((chr>=48 && chr<=57) || chr==44 || chr==46 || chr==45){
	    	  continue;
	      }else{
	    	  return 0.0;
	      }
		}
		if(str.indexOf(",")>-1){
			str = str.replace(",", "");
		}
		return Double.parseDouble(str);
	}

	public static void main(String[] arg) {
		System.out.println(parseFinancial("-161,653.0"));
	}

	/**
	 * * * 功能：(oracle中，将clob类型的数据转换为string） * *
	 * 
	 * @Title: fomcatClobToString *
	 * @Date: 0521, 2012 17:10:52 PM *
	 * @param clob *
	 * @return string
	 */
	/*public static String fomcatClobToString(CLOB clob) throws SQLException, IOException {
		if(clob == null){
			return "";
		}
		String reString = "";
		Reader is = clob.getCharacterStream();
		// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {
			// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}*/
	//小数转换成百分数
	public static String formatPercentage(double str){
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMaximumFractionDigits(2);
		String val=nf.format(str);
		if(val.equals("-0%")){
			val="0%";
		}
		return val;
	}
	/**
	 *  格式化日期
	 */
	public static String formatDate(String str){
		String date = "";
		List<String> dates = new ArrayList<String>();
		if(isEmpty(str)){
			return "";
		}
		dates = stringToList(str, "/");
		for (String string : dates) {
			date += string + "-";
		}
		return date.substring(0, date.length()-1);
	}
	/**
	 * 将一个bean的数据拷贝到另一个bean,必须同一个bean.
	 * @param from 数据来源bean
	 * @param to 拷贝目标bean
	 * @return 返回目标bean
	 */
	public static Object convertBeanToOtherBean(Object from, Object to) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(to.getClass());
			PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor p : ps) {
				Method getMethod = p.getReadMethod();
				Method setMethod = p.getWriteMethod();
				if (getMethod != null && setMethod != null) {
					try {
						Object result = getMethod.invoke(from);
						setMethod.invoke(to, result);
					} catch (Exception e) {
						// 如果from没有此属性的get方法，跳过
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return to;
	}
	/**
	 * 返回最大值.
	 * @param list 
	 * @return
	 */
    public static String getMaximum(List<String> tempList){
    	if(tempList!=null){
    		if(tempList.size() >0){
    			for (int i = 0; i < tempList.size(); i++) {
        			for (int j = 0; j < tempList.size() - i - 1; j++) {
        				String c1 = tempList.get(j);
        				String c2 = tempList.get(j + 1);
        				double v1 = Double.valueOf(c1);
        				double v2 = Double.valueOf(c2);
        				if (v1 < v2) {
        					String temp = c2;
        					tempList.set(j + 1, c1);
        					tempList.set(j, temp);
        				}
        			}
        		}
        		return tempList.get(0);
    		}else{
        		return null;
        	}
    	}else{
    		return null;
    	}
	}
    /**
	    * 将map转换成list;
	   */
	  public static List  mapTransitionList(Map map) {
			List list = new ArrayList();
			Iterator iter = map.entrySet().iterator();  //获得map的Iterator
			while(iter.hasNext()) {
				Entry entry = (Entry)iter.next();
				list.add(entry.getValue());
			}
			return list;
		}
	  
}
