package com.zc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * excel导出类.
 *
 */

public class ExcelOut {
	
     public static InputStream exportDataToExcel(String path,
			List<ExcelEntity> propertyList, List<?> dataList)
			throws Exception {
    	 
		ExcelUtil excelUtil = new ExcelUtil();

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet();
		
		Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

		short columnIndex = 0;

		HSSFRow row = sheet.createRow(0);
		

		row.setHeight((short) 500);

		excelUtil.setWorkbook(workbook);

		while (titleRowIterator.hasNext()) {
			
			sheet.setColumnWidth((short)columnIndex, (short)5000);
			
			ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

			String cellValue = titleEntity.getTitle();//栏目名称
			
			int width = titleEntity.getWidth();
			
			int height = titleEntity.getHeight();
			
			HSSFCell cell = row.createCell(columnIndex);

			excelUtil.setStyle(cell, true, width, height, 2, true);

			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			

			// cell.setCellValue(new HSSFRichTextString(cellValue));

			cell.setCellValue(cellValue);

			columnIndex++;

		}

		Iterator rowIterator = dataList.iterator();

		int rowIndex = 1;

		while (rowIterator.hasNext()) {
			
			row = sheet.createRow(rowIndex);
			
			Object obj = rowIterator.next();
			
			Class classEntity = obj.getClass();
			
			columnIndex = 0;
			
			for(int i = 0;i < propertyList.size();i ++){
				
				ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);
				
				int width = titleEntity.getWidth();
				
				int height = titleEntity.getHeight();
				
				String flag = titleEntity.getFlag();//数据类型
				
    			String fdname = titleEntity.getProperty();
    			
    			Method metd = null;  
    			
    			metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数  
    		    
    			if(metd != null){
    		    	Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法  
    		    	
    		    	HSSFCell cell = row.createCell(columnIndex);
//数据量大时，cellStyle有影响  zzq
        			excelUtil.setStyle(cell, true, width, height, 2, false);
        			
        			//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        			String value =  String.valueOf(cellValue);
        				
					if(flag.equals("1")){
						HSSFCellStyle cellStyle = workbook.createCellStyle();
    			        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
    			        cell.setCellStyle(cellStyle);
						if(value != null && !value.equals("null")){
							cell.setCellValue(value);
						}else{
							cell.setCellValue("");
						}
    					
        			}else if(flag.equals("2")){
        				HSSFCellStyle cellStyle = workbook.createCellStyle();
    			        cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
    			        cell.setCellStyle(cellStyle);
        			        
        				if(value != null && !value.equals("null")){
        					cell.setCellValue(ArithUtil.add(Double.parseDouble(value), 0));
        				}else{
        					cell.setCellValue(0);
        				}
        				
        			}
        			
    		    }
    			columnIndex++;
			}
    		rowIndex++;
		}

		try {

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;
	}
     /** 
      * @param src 
      *            源字符串 
      * @return 字符串，将src的第一个字母转换为大写，src为空时返回null 
      */  
     public static String change(String src) {  
         if (src != null) {  
             StringBuffer sb = new StringBuffer(src);  
             sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));  
             return sb.toString();  
         } else {  
             return null;  
         }  
     } 
}
