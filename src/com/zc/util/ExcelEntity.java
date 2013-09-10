package com.zc.util;

/**
 * excel导出类的参数定义类.
 *
 */
public class ExcelEntity {

	private String title;//excel列头
	
	private String property;//取值的字段
	
	private int width=200;//excel宽
	
	private int height=180;//excel高 ib
	
	private String flag="1";//基本数据类型 1:String 2:double 
	
	private String realPath="";//项目的根路径
	
	private String saleImage="";

	private String invoiceImage="";
	
	private String profitImage="";
	
	private String profitImage2="";
	
	private String costImage="";
	
	private String reportImage1;
	
	private String reportImage2;
	
	private String reportImage3;
	
	private String reportImage4;
	
	private String excelTitle="";
	
	private String remark="(说明：图表中K表示：千，M表示：百万，表格中价格显示默认为：元)";

	public ExcelEntity(){
	}
	/**
	 * 
	 * @param title 标题
	 * @param property 属性值
	 * @param isBold 是否加粗
	 */
	public ExcelEntity(String title,String property){
		this.title=title;
		this.property=property;
	}
	/**
	 * 
	 * @param title 标题
	 * @param property 属性值
	 * @param width 宽
	 * @param height 高
	 * @param isBold 是否加粗
	 * @param flag 基本数据类型 1:String 2:double 
	 */
	public ExcelEntity(String title,String property,int width,int height,String flag){
		this.title=title;
		this.property=property;
		this.width=width;
		this.height=height;
		this.flag=flag;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getInvoiceImage() {
		return invoiceImage;
	}
	public void setInvoiceImage(String invoiceImage) {
		this.invoiceImage = invoiceImage;
	}
	public String getProfitImage() {
		return profitImage;
	}
	public void setProfitImage(String profitImage) {
		this.profitImage = profitImage;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getSaleImage() {
		return saleImage;
	}
	public void setSaleImage(String saleImage) {
		this.saleImage = saleImage;
	}
	public String getExcelTitle() {
		return excelTitle;
	}
	public void setExcelTitle(String excelTitle) {
		this.excelTitle = excelTitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCostImage() {
		return costImage;
	}
	public void setCostImage(String costImage) {
		this.costImage = costImage;
	}
	public String getReportImage1() {
		return reportImage1;
	}
	public void setReportImage1(String reportImage1) {
		this.reportImage1 = reportImage1;
	}
	public String getReportImage2() {
		return reportImage2;
	}
	public void setReportImage2(String reportImage2) {
		this.reportImage2 = reportImage2;
	}
	public String getProfitImage2() {
		return profitImage2;
	}
	public void setProfitImage2(String profitImage2) {
		this.profitImage2 = profitImage2;
	}
	public String getReportImage3() {
		return reportImage3;
	}
	public void setReportImage3(String reportImage3) {
		this.reportImage3 = reportImage3;
	}
	public String getReportImage4() {
		return reportImage4;
	}
	public void setReportImage4(String reportImage4) {
		this.reportImage4 = reportImage4;
	}
	
	
	
	
	
}
