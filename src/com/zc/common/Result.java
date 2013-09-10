package com.zc.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.zc.util.StringUtil;



public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6120592918800192272L;
	public Map<Object, Object> getBeanMap() {
		return beanMap;
	}
	public String getMegCode() {
		return megCode;
	}
	public String getMessage() {
		return message;
	}
	public Object getValue(String key) {
		if(StringUtil.isEmpty(key)) {
			return null;
		}
		
		return beanMap.get(key.trim());
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setBeanMap(Map<Object, Object> beanMap) {
		this.beanMap = beanMap;
	}
	
	public void setMegCode(String megCode) {
		this.megCode = megCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public void setValue(Object key, Object value) {
		if(null != key) {
			beanMap.put(key, value);
		}
	}

	private Map<Object, Object> beanMap = new HashMap<Object, Object>();
	private String megCode = null;

	private String message = null;
	
	private String resultId = null;//返回的结果ID

	private boolean success = true;
}
