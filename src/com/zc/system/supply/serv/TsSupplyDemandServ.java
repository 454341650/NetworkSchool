package com.zc.system.supply.serv;

 
import java.util.List;

import com.zc.system.supply.pojo.TsSupplyDemand;

public interface TsSupplyDemandServ {
	
	public int addTsSupplyDemand(TsSupplyDemand tsSupplyDemand) ;
	
	public int updateTsSupplyDemand(TsSupplyDemand tsSupplyDemand);

	public int delTsSupplyDemand(TsSupplyDemand tsSupplyDemand);
	
	public int findTsSupplyDemand(TsSupplyDemand tsSupplyDemand);
	
	public List<TsSupplyDemand> listTsSupplyDemand(TsSupplyDemand tsSupplyDemand);

	public int findForPage(TsSupplyDemand tsSupplyDemand);
	

}
