package com.zc.system.supply.dao;


import java.sql.SQLException;
import java.util.List;

import com.zc.system.supply.pojo.TsSupplyDemand;

public interface TsSupplyDemandDao{

	public Object addTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException;
	
	public int updateTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException;
	
	public TsSupplyDemand findTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException;
	
	public List<TsSupplyDemand> listTsSupplyDemand (TsSupplyDemand tsSupplyDemand) throws SQLException;
	
	public List<TsSupplyDemand> listTsSupplyDemandForPage (TsSupplyDemand tsSupplyDemand) throws SQLException;

	public int delTsSupplyDemand(TsSupplyDemand tsSupplyDemand) throws SQLException;
	
	public Long findTsSupplyDemandCount(TsSupplyDemand tsSupplyDemand)  throws SQLException;
	
	
}
