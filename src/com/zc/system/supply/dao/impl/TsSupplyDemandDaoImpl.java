package com.zc.system.supply.dao.impl;

 
import java.sql.SQLException;
import java.util.List;

import com.zc.common.BaseDao;
import com.zc.system.supply.dao.TsSupplyDemandDao;
import com.zc.system.supply.pojo.TsSupplyDemand;

@SuppressWarnings("unchecked")
public class TsSupplyDemandDaoImpl extends BaseDao implements TsSupplyDemandDao {

	public Object addTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().insert("TsSupplyDemand.addTsSupplyDemand", tsSupplyDemand);
	}
	
	public int updateTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().update("TsSupplyDemand.updateTsSupplyDemand", tsSupplyDemand);
	}
	public int delTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().delete("TsSupplyDemand.delTsSupplyDemand", tsSupplyDemand);
	}
	
	public TsSupplyDemand findTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return (TsSupplyDemand) getSqlMapClientTemplate().queryForObject("TsSupplyDemand.findTsSupplyDemand", tsSupplyDemand);
	}
	
	public TsSupplyDemand findTsSupplyDemand2 (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return (TsSupplyDemand) getSqlMapClientTemplate().queryForObject("TsSupplyDemand.findTsSupplyDemand2", tsSupplyDemand);
	}
	
	public List<TsSupplyDemand> listTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().queryForList("TsSupplyDemand.findTsSupplyDemand", tsSupplyDemand);
	}
	
	public List<TsSupplyDemand> listTsSupplyDemandForPage (TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().queryForList("TsSupplyDemand.findTsSupplyDemandForPage", tsSupplyDemand);
	}

	public Long findTsSupplyDemandCount(TsSupplyDemand tsSupplyDemand) throws SQLException{
		return (Long) getSqlMapClient().queryForObject("TsSupplyDemand.findTsSupplyDemandCount", tsSupplyDemand);
	}


	public List<TsSupplyDemand> findWebsiteSdNum(TsSupplyDemand tsSupplyDemand) throws SQLException {
		return getSqlMapClientTemplate().queryForList("TsSupplyDemand.findWebsiteSdNum", tsSupplyDemand);
	}
}
