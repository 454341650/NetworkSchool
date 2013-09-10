package com.zc.common;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * pojo父类.
 */
public class BasePojo<T> implements Serializable {
	
	/** 持久化版本ID,系统自动生成. */
	private static final long serialVersionUID = 4993990459151998182L;
	
	/** 数据唯一标示符. */
	private String id;

	/** 当前页. */
	private Integer currentPage = 1;

	/** 结束行数. */
	private Integer endRow = null;

	/** 页面容量. */
	private Integer pageSize = 25;

	/** 分页查询出来的记录集合. */
	private List<T> recordList;

	/** 起始行数. */
	private Integer startRow = 1;

	/** 总行数. */
	private Long totalPage = null;

	/** 总行数. */
	private Long totalRow = null;
	
	/** url地址. */
	private String pageUrl = "";
	
	/** 排序字段. */
	private String orderByField;
	
	/** 排序方式：默认降序:desc 升序:asc */
	private String orderByMode = "desc";
	
	/** 是否升序，true表示升序，false表示降序 */
	private boolean isOrderByAsc = false;
	
	/**分页提示信息，如暂无数据提示*/
	private String pageMessage="抱歉，没有找到相关信息。";
	
	/**html头部title显示信息*/
	private String htmlTitle="";
	
	/**html头部description显示信息*/
	private String htmlDescription="嘉兴数格格网络技术有限公司是一家集......";
	
	/**html头部keywords显示信息*/
	private String htmlKeywords="数格格 物流 云 数据共享 产品 商品 官方数据 云数据 云计算 云统计 海量数据 会员";
	
	/**放一些操作的结果标示*/
	private String resultFlag = "";
	
	/**放一些message之类的信息*/
	private String message = "";
	
	/** 取多少条记录. */
	private String rownum;
	/**
	 * Gets the current page.
	 *
	 * @return the current page
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public Integer getEndRow() {
		return endRow;
	}
	
	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * Gets the record list.
	 *
	 * @return the record list
	 */
	public List<T> getRecordList() {
		return recordList;
	}
	
	/**
	 * Gets the start row.
	 *
	 * @return the start row
	 */
	public Integer getStartRow() {
		return startRow;
	}
	
	/**
	 * 项目站点路径
	 */
	public String realPath;
	
	/**
	 * 获取项目站点路径
	 * @return
	 */
	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	/**
     * 获取总页数
     * @param Integer totalRows
     * @return Integer
     */
    public Long getTotalPage() {
    	if(null == totalRow) {
    		totalRow = 0L;
    	}
    	
        /* 设置总页数 */
    	totalPage = totalRow / pageSize;

        /* 如果总行数不能被页面容量整除，那么总页数加1 */
        Long mod = totalRow % pageSize;

        if (mod > 0) {
        	totalPage++;
        }

        return totalPage;
    }
	
	/**
	 * Gets the total row.
	 *
	 * @return the total row
	 */
	public Long getTotalRow() {
		return totalRow;
	}

	/**
	 * Sets the current page.
	 *
	 * @param currentPage the new current page
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Sets the record list.
	 *
	 * @param recordList the new record list
	 */
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}

	/**
	 * Sets the start row.
	 *
	 * @param startRow the new start row
	 */
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * Sets the total row.
	 *
	 * @param totalRow the new total row
	 */
	public void setTotalRow(Long totalRow) {
		this.totalRow = totalRow;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
	
	
	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	
	
	public boolean isOrderByAsc() {
		return isOrderByAsc;
	}

	public void setOrderByAsc(boolean isOrderByAsc) {
		if(isOrderByAsc){
			setOrderByMode("asc"); 
		}
		this.isOrderByAsc = isOrderByAsc;
	}

	public String getOrderByField() {
		return orderByField;
	}

	public void setOrderByField(String orderByField) {
		if(orderByField != null){
			if(!orderByField.equals("")){
				this.orderByField = orderByField.replaceAll("[^a-zA-Z_\u4e00-\u9fa5]", "");//防特殊字符sql注入//[清掉以下特殊字符： /、\、?、*、:、<、>、|、" ]
			}
		}
		this.orderByField = orderByField;
	}

	public String getOrderByMode() {
		return orderByMode;
	}

	public void setOrderByMode(String orderByMode) {
		this.orderByMode = orderByMode;
	}


	public String getHtmlTitle() {
		return htmlTitle;
	}

	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	public String getPageMessage() {
		return pageMessage;
	}

	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getHtmlKeywords() {
		return htmlKeywords;
	}

	public void setHtmlKeywords(String htmlKeywords) {
		this.htmlKeywords = htmlKeywords;
	}

	public void getStartRowAndEndRow(){
		if(currentPage == null){
			currentPage = 1;
		}
		if(currentPage == 1){
			 startRow = 1;
			 endRow = pageSize;
		}else if(currentPage > 1){
			 startRow = (pageSize * (currentPage-1))+1;
			 endRow = currentPage * pageSize;
			
		}
	}

	public void setClientRequest(HttpServletRequest request) {
		Enumeration enumeration = request.getParameterNames();
		String requestURl =  request.getRequestURI()+"?";
		while (enumeration.hasMoreElements()) {
			String parameterName = (String) enumeration.nextElement();
			String parameterValue = request.getParameter(parameterName);
			requestURl +="&"+parameterName+"="+parameterValue;
		}
		requestURl = requestURl.replaceAll("&currentPage="+currentPage,"");
		setPageUrl(requestURl);
		getStartRowAndEndRow();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}
	
	
	
}
