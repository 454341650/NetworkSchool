package com.zc.system.supply.action;


import com.opensymphony.xwork2.ModelDriven;
import com.zc.common.BaseAction;
import com.zc.system.supply.pojo.TsSupplyDemand;
import com.zc.system.supply.serv.TsSupplyDemandServ;

/**
 * 供求管理.
 *
 */
public class TsSupplyDemandAction extends BaseAction implements ModelDriven<TsSupplyDemand> {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7457463725897427337L;

	private transient TsSupplyDemandServ tsSupplyDemandServ;
	
	private TsSupplyDemand model = new TsSupplyDemand();
	

	/**分页查询.*/
	public String doFetchForPage() {
		model.setClientRequest(getRequest());
	    try{
		    tsSupplyDemandServ.findForPage(model);
		} catch (Exception e) {
		    e.printStackTrace();
			log.error(e);
		}
		return SUCCESS;
	}

	public String doFetchOne() {
		try {
			if(model.getId() != null && !model.getId().equals("")){
				tsSupplyDemandServ.findTsSupplyDemand(model);
			}
		} catch (Exception e) {
		    e.printStackTrace();
			log.error(e);
		}
		
		return SUCCESS;
	}
	
	public String doAdd() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return SUCCESS;
	}
	
	public String doUpdate() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return SUCCESS;
	}
	public String doDelete() {
		try {
		

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return SUCCESS;
	}
	
	public void setModel(TsSupplyDemand model) {
		this.model = model;
	}

	public TsSupplyDemand getModel() {
		return model;
	}

	
	public void setTsSupplyDemandServ(TsSupplyDemandServ tsSupplyDemandServ) {
		this.tsSupplyDemandServ = tsSupplyDemandServ;
	}

	

	
}