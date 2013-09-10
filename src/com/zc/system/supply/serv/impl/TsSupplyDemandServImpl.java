package com.zc.system.supply.serv.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zc.system.supply.dao.TsSupplyDemandDao;
import com.zc.system.supply.pojo.TsSupplyDemand;
import com.zc.system.supply.serv.TsSupplyDemandServ;
import com.zc.util.StringUtil;

public class TsSupplyDemandServImpl implements TsSupplyDemandServ {
	/** 记录日志的接口 */
	private static Log log = LogFactory.getLog(TsSupplyDemandServImpl.class);

	/** . */
	private TsSupplyDemandDao tsSupplyDemandDao;

	public int addTsSupplyDemand(TsSupplyDemand tsSupplyDemand) {

		try {

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return 0;
	}

	public int updateTsSupplyDemand(TsSupplyDemand tsSupplyDemand) {

		try {
			tsSupplyDemandDao.updateTsSupplyDemand(tsSupplyDemand);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return 0;
	}

	public int delTsSupplyDemand(TsSupplyDemand tsSupplyDemand) {

		try {
			tsSupplyDemandDao.delTsSupplyDemand(tsSupplyDemand);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return 0;
	}

	/** 分页查询 */
	public int findForPage(TsSupplyDemand tsSupplyDemand) {
		try {
			tsSupplyDemand.setTotalRow(tsSupplyDemandDao.findTsSupplyDemandCount(tsSupplyDemand));
			tsSupplyDemand.setRecordList(tsSupplyDemandDao.listTsSupplyDemandForPage(tsSupplyDemand));
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return 0;
	}

	
	public int findTsSupplyDemand(TsSupplyDemand tsSupplyDemand) {
		try {
			TsSupplyDemand info = tsSupplyDemandDao.findTsSupplyDemand(tsSupplyDemand);
			if(info == null){
				info = new TsSupplyDemand();
			}
			StringUtil.convertBeanToOtherBean(info, tsSupplyDemand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	public List<TsSupplyDemand> listTsSupplyDemand(TsSupplyDemand tsSupplyDemand) {
		List<TsSupplyDemand> list = new ArrayList<TsSupplyDemand>();

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

		return list;
	}

	
	public void setTsSupplyDemandDao(TsSupplyDemandDao tsSupplyDemandDao) {
		this.tsSupplyDemandDao = tsSupplyDemandDao;
	}
}
