package com.zc.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * excel导出类.
 * 
 */

public class ReportExcelOut {

	public static InputStream exportDataToExcel(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(4);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 5;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	public static InputStream exportSaleStructrue(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(4);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 5;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	public static InputStream exportSaleTrend(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < 19;ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 6){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
            //趋势图
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getSaleImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getInvoiceImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,31, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getProfitImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,57, 0, 1);

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	public static InputStream exportSaleWhole(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(29);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 30;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getSaleImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getInvoiceImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 3, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getProfitImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 6, 1);
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	/**
	 * 销售统计报表导出.
	 * @param path
	 * @param propertyList
	 * @param dataList
	 * @param ee
	 * @return
	 */
	public static InputStream exportSaleAllReport(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(70);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 71;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getSaleImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getInvoiceImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,26, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getProfitImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,48 , 0, 1);
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	/**
	 * 采购统计报表导出.
	 * @param path
	 * @param propertyList
	 * @param dataList
	 * @param ee
	 * @return
	 */
	public static InputStream exportPurchaseAllReport(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(92);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 93;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getCostImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getSaleImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,26, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getInvoiceImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,48 , 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getProfitImage()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,70 , 0, 1);
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	/**
	 * 库存统计报表导出.
	 * @param path
	 * @param propertyList
	 * @param dataList
	 * @param ee
	 * @return
	 */
	public static InputStream exportStockWholeReport(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(32);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 33;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage1()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	/**
	 * 财务统计报表导出.
	 * @param path
	 * @param propertyList
	 * @param dataList
	 * @param ee
	 * @return
	 */
	public static InputStream exportFinanceWholeReport(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();

			short columnIndex = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
            //excel数据title行
			HSSFRow row = sheet.createRow(32);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 33;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage1()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage2()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 7, 1);
			
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	// 自定义的方法,插入某个图片到指定索引的位置
	private static void insertImage(HSSFWorkbook wb,HSSFSheet sheet,
			ByteArrayOutputStream byteArrayOut, int row, int column, int index) {
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		/*int x1 = index * 250;
		int y1 = 0;
		int x2 = x1 + 255;
		int y2 = 255;*/
		//HSSFClientAnchor anchor = new HSSFClientAnchor(x1, y1, x2, y2,(short) column, row, (short) column, row);
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,(short) column, row, (short) column, row);
		HSSFPicture pict = patriarch.createPicture(anchor, wb.addPicture(byteArrayOut
				.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
		pict.resize();
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
	
	/**
	 * 财务统计报表导出.
	 * @param path
	 * @param propertyList
	 * @param dataList
	 * @param ee
	 * @return
	 */
	public static InputStream exportSaleRankingReport(String path,
			List<ExcelEntity> propertyList, List<?> dataList,ExcelEntity ee,List<ExcelEntity> propertyList2, List<?> dataList2) {
		try {
			ExcelUtil excelUtil = new ExcelUtil();

			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();

			Iterator<ExcelEntity> titleRowIterator = propertyList.iterator();
			Iterator<ExcelEntity> titleRowIterator2 = propertyList2.iterator();

			short columnIndex = 0;
			short columnIndex2 = 0;
			
			//大标题
			HSSFRow allTitlerow = sheet.createRow(1);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = allTitlerow.createCell(ti);
				if(ti == 4){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)450);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getExcelTitle());
					cell.setCellStyle(cellStyle);
				}
			}
			//备注
			HSSFRow remarkRow = sheet.createRow(2);
			for(int ti = 0;ti < propertyList.size();ti ++){
				HSSFCell cell = remarkRow.createCell(ti);
				if(ti == 0){
					HSSFCellStyle cellStyle = workbook.createCellStyle();
					HSSFFont auFont = workbook.createFont();
					auFont.setColor(HSSFColor.BLACK.index);
					auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
					auFont.setFontHeight((short)300);
					cellStyle.setFont(auFont);
					cell.setCellValue(ee.getRemark());
					cell.setCellStyle(cellStyle);
				}
			}
			//excel数据title行
			HSSFRow row = sheet.createRow(28);

			row.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator.hasNext()) {

				sheet.setColumnWidth((short) columnIndex, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row.createCell(columnIndex);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex++;

			}
			
			
			HSSFRow row2 = sheet.createRow(64);

			row2.setHeight((short) 500);

			excelUtil.setWorkbook(workbook);

			while (titleRowIterator2.hasNext()) {

				sheet.setColumnWidth((short) columnIndex2, (short) 5000);

				ExcelEntity titleEntity = (ExcelEntity) titleRowIterator2.next();

				String cellValue = titleEntity.getTitle();// 栏目名称

				int width = titleEntity.getWidth();

				int height = titleEntity.getHeight();

				HSSFCell cell = row2.createCell(columnIndex2);

				excelUtil.setTitleStyle(cell, true, width, height, 3, true);

				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				

				// cell.setCellValue(new HSSFRichTextString(cellValue));

				cell.setCellValue(cellValue);

				columnIndex2++;

			}
			
			
			
			
			
			
			
			
			//遍历数据行

			Iterator rowIterator = dataList.iterator();

			int rowIndex = 29;

			while (rowIterator.hasNext()) {

				row = sheet.createRow(rowIndex);

				Object obj = rowIterator.next();

				Class classEntity = obj.getClass();

				columnIndex = 0;

				for (int i = 0; i < propertyList.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex++;
				}
				rowIndex++;
			}
			
			
			//遍历数据行

			Iterator rowIterator2 = dataList2.iterator();

			int rowIndex2 = 65;

			while (rowIterator2.hasNext()) {

				row = sheet.createRow(rowIndex2);

				Object obj = rowIterator2.next();

				Class classEntity = obj.getClass();

				columnIndex2 = 0;

				for (int i = 0; i < propertyList2.size(); i++) {

					ExcelEntity titleEntity = (ExcelEntity) propertyList2.get(i);

					int width = titleEntity.getWidth();

					int height = titleEntity.getHeight();

					String flag = titleEntity.getFlag();// 数据类型

					String fdname = titleEntity.getProperty();

					Method metd = null;

					metd = classEntity.getMethod("get" + change(fdname), null);// 根据字段名找到对应的get方法，null表示无参数

					if (metd != null) {
						Object cellValue = metd.invoke(obj, null);// 调用该字段的get方法
						
						HSSFCell cell = row.createCell(columnIndex2);

						excelUtil.setStyle(cell, true, width, height, 2, false);

						// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						String value = String.valueOf(cellValue);

						if (flag.equals("1")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
							cell.setCellStyle(cellStyle);
							if (value != null && !value.equals("null")) {
								cell.setCellValue(value);
							} else {
								cell.setCellValue("");
							}

						} else if (flag.equals("2")) {
							HSSFCellStyle cellStyle = workbook
									.createCellStyle();
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
							cell.setCellStyle(cellStyle);

							if (value != null && !value.equals("null")) {
								cell.setCellValue(ArithUtil.add(Double
										.parseDouble(value), 0));
							} else {
								cell.setCellValue(0);
							}

						}

					}
					columnIndex2++;
				}
				rowIndex2++;
			}
			
			
			
			
			/*//**插入图片示例start
			BufferedImage bufferImg = null;
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			String webappPath = "D:\\workspace2\\DataWarehouse\\webapp\\";
			bufferImg = ImageIO.read(new File(webappPath+ "upload\\chart_image\\FusionChartsa42a5792-6208-455a-a8d6-849a34c64559_22113213158_1358861518203.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,50, 1, 1);
			//**插入图片示例end*/
			String webappPath = ee.getRealPath();
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage1()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage2()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,4, 5, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage3()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,42, 0, 1);
			
			byteArrayOut = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File(webappPath+ee.getReportImage4()));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			insertImage(workbook,sheet, byteArrayOut,42, 5, 1);
			
				

			File file = new File(path);

			FileOutputStream fos = new FileOutputStream(file);

			workbook.write(fos);

			fos.flush();

			fos.close();

			return new FileInputStream(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}
	
}
