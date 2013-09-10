package com.zc.util;

import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;




public class ExcelUtil {
	
	//private final static String fileSeparator = System.getProperty("file.separator");

	static final long serialVersionUID = -6719842238864057289L;

	//private HttpServletRequest request = null;

	//private Connection connect = null;

	public Statement statement = null;

	public ResultSet result = null;

	/* 工作薄 */
	public HSSFWorkbook workbook = null;

	/* EXCEL sheet */
	public HSSFSheet aSheet = null;

	public HSSFFont auFont = null;

	public HSSFCellStyle cellStyle = null;

	/* 纸张 */
	public static final short LETTER_PAPERSIZE = 1;

	public static final short LEGAL_PAPERSIZE = 5;

	public static final short EXECUTIVE_PAPERSIZE = 7;

	public static final short A4_PAPERSIZE = 9;

	public static final short A5_PAPERSIZE = 11;

	public static final short ENVELOPE_10_PAPERSIZE = 20;

	public static final short ENVELOPE_DL_PAPERSIZE = 27;

	public static final short ENVELOPE_CS_PAPERSIZE = 28;

	public static final short ENVELOPE_MONARCH_PAPERSIZE = 37;

	/* 表头 */
	public static final int LEFT_ORI = 1;

	public static final int CENTER_ORI = 2;

	public static final int RIGHT_ORI = 3;

	/* CELL 样式 */
	public static final int CELL_CENTER_NOLINE = 1;

	public static final int CELL_CENTER_HASLINE = 2;

	public static final int CELL_RIGHT_NOLINE = 3;

	public static final int CELL_RIGHT_HASLINE = 4;

	public static final int CELL_LEFT_NOLINE = 5;

	public static final int CELL_LEFT_HASLINE = 6;

	/* 页脚位置 */
	public static final String HEADER_FOOTER_RIGHT = "&R ";

	public static final String HEADER_FOOTER_LEFT = "&L ";

	public static final String HEADER_FOOTER_CENTER = "&C ";

	private String cellFont = "宋体";

	/* 参数容器 */
/*	private HashMap paramMap = null;

	private String downFileName;

	private String footer = "";

	private String footerAlign = "&L ";

	private String reportType = "0";

	private String header = "";

	private String headerAlign = "&L ";

	private String tempPath = "";*/

	public HSSFCellStyle setTitleCellStyle(HSSFWorkbook workbook,
			int weight, int height, boolean isWrap) {
		HSSFFont auFont = workbook.createFont();

		auFont.setFontName(getCellFont());
		auFont.setBoldweight((short) weight);
		auFont.setFontHeight((short) height);
		auFont.setColor(HSSFColor.BLACK.index);

		HSSFCellStyle cellStyle = workbook.createCellStyle();

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);

		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);

//		cellStyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);

		/* 设置CELL为垂直居中 */
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(auFont);
		/* CELL中是否允许换行 */
		cellStyle.setWrapText(isWrap);

		return cellStyle;
	}
	/**
	 * cell 例对象
	 * iswrap CELL中是否允许换行
	 * weight,宽度
	 * height,高度
	 * flag ,样式选择 ,1居中，2居中 黑色边框....
	 * bold 是否加粗
	 * 
	 */
	
	public void setStyle(HSSFCell cell, boolean iswrap, int weight, int height,
			int flag,boolean bold) throws Exception {
		auFont = workbook.createFont();

		auFont.setFontName(this.getCellFont());
		auFont.setBoldweight((short) weight);
		auFont.setFontHeight((short) height);
		if(bold){
			auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
		}
		cellStyle = workbook.createCellStyle();
		

		switch (flag) {
		case CELL_CENTER_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			break;
		case CELL_CENTER_HASLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
			break;
		case CELL_RIGHT_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			break;
		case CELL_RIGHT_HASLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			break;
		case CELL_LEFT_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			
			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
			break;
		case CELL_LEFT_HASLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			break;
		}
		/* 设置CELL为垂直居中 */
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(auFont);
		/* CELL中是否允许换行 */
		cellStyle.setWrapText(iswrap);
		cell.setCellStyle(cellStyle);
		try {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		} catch (Exception e) {
			throw e ;
		}
		/* 设置CELL字符 */
		//cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
		auFont = null;
		cellStyle = null;
	}
	/**
	 * cell 例对象
	 * iswrap CELL中是否允许换行
	 * weight,宽度
	 * height,高度
	 * flag ,样式选择 ,1居中，2居中 黑色边框 ....
	 * bold 是否加粗
	 * 
	 */
	
	public void setTitleStyle(HSSFCell cell, boolean iswrap, int weight, int height,
			int flag,boolean bold) throws Exception {
		auFont = workbook.createFont();

		auFont.setFontName(this.getCellFont());
		auFont.setBoldweight((short) weight);
		auFont.setFontHeight((short) height);
		
		if(bold){
			auFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗   
		}
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); //填充单元格
		cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index); //填充颜色

		switch (flag) {
		case 1:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			break;
		case 2:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
			break;
		case 3:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setBottomBorderColor(HSSFColor.CORNFLOWER_BLUE.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.CORNFLOWER_BLUE.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.CORNFLOWER_BLUE.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.CORNFLOWER_BLUE.index);
			break;
		}
		/* 设置CELL为垂直居中 */
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(auFont);
		/* CELL中是否允许换行 */
		cellStyle.setWrapText(iswrap);
		cell.setCellStyle(cellStyle);
		try {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		} catch (Exception e) {
			throw e ;
		}
		/* 设置CELL字符 */
		//cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
		auFont = null;
		cellStyle = null;
	}
	
	public void setFormulaStyle(HSSFCell cell, boolean iswrap, int weight, int height, int flag) throws Exception {
		auFont = workbook.createFont();

		auFont.setFontName(this.getCellFont());
		auFont.setBoldweight((short) weight);
		auFont.setFontHeight((short) height);
		cellStyle = workbook.createCellStyle();

		switch (flag) {
		case CELL_CENTER_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			break;
		case CELL_CENTER_HASLINE:

			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
			break;
		case CELL_RIGHT_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			break;
		case CELL_RIGHT_HASLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			break;
		case CELL_LEFT_NOLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			
			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
			break;
		case CELL_LEFT_HASLINE:
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			break;
		}
		/* 设置CELL为垂直居中 */
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(auFont);
		/* CELL中是否允许换行 */
		cellStyle.setWrapText(iswrap);
		cell.setCellStyle(cellStyle);
		try {
			cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
		} catch (Exception e) {
			throw e ;
		}
		/* 设置CELL字符 */
		//cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
		auFont = null;
		cellStyle = null;
	}

	public String getCellFont() {
		return cellFont;
	}

	public void setCellFont(String cellFont) {
		this.cellFont = cellFont;
	}

	public HSSFFont getAuFont() {
		return auFont;
	}

	public void setAuFont(HSSFFont auFont) {
		this.auFont = auFont;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public void setFStyle(HSSFCell cell, boolean iswrap, int weight, int height, int flag) {
		cellStyle = workbook.createCellStyle();
		
//		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
//		
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//
//		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//
//		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//		
		//cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
		
		cell.setCellStyle(cellStyle) ;
	}
}