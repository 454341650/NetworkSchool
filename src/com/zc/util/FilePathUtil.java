package com.zc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FilePathUtil {
	public static String getFileName() {
		Date date = new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = from.format(date);
		return times;
	}

	public static String getFilePath(Date date) {
		String folder = DateUtil.format(date, "yyyy-MM-dd");
		String myFileName = DateUtil.format(date);

		StringBuffer sb = new StringBuffer();
		String[] arr = folder.split("-");

		for (String s : arr) {
			sb.append(s);
			sb.append("/");
		}

		return sb.append(myFileName).toString();
	}
}
