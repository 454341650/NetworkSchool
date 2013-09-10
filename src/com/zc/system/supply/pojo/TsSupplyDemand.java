package com.zc.system.supply.pojo;

 
import com.zc.common.BasePojo;

/**
 * 
 **/
public class TsSupplyDemand extends BasePojo {
	private static final long serialVersionUID = -1L;
	private String rank;
	private String sd_unit_name;
	private String unit_name;
	private String product_id;
	private String ac_code;
	
	public TsSupplyDemand(){
		
	}
	public String getAc_code() {
		return ac_code;
	}

	public void setAc_code(String acCode) {
		ac_code = acCode;
	}
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unitName) {
		unit_name = unitName;
	}

	public String getSd_unit_name() {
		return sd_unit_name;
	}

	public void setSd_unit_name(String sdUnitName) {
		sd_unit_name = sdUnitName;
	}
	private String product_detail;
	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String productDetail) {
		product_detail = productDetail;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String image_url;
	private String full_name;
	private String chs_name;
	public String getChs_name() {
		return chs_name;
	}

	public void setChs_name(String chsName) {
		chs_name = chsName;
	}
	/** 标题 **/
    private String title;
    
    /** 供求开始时间 **/
    private String start_time;
    
    /** 供求结束时间 **/
    private String end_time;
    
    /** 企业编码 **/
    private String client_code;
    
    /** 商品编码 **/
    private String product_code;
    
    /** 收藏数 **/
    private Integer collect_num;
    
    /** 点击数 **/
    private Integer click_num;
    
    /** 关注数 **/
    private Integer attention_num;
    
    /** 供应量 **/
    private String supply_num;
    
    /** 求购量 **/
    private String demand_num;
    
    /** 供应/求购单位 **/
    private String sd_unit_code;
    
    /** 单价 **/
    private String unit_price;
    
    /** 单价单位 **/
    private String unit_code;
    
    /** 1.供应 2.求购 **/
    private String sd_type;
    
    /** 详情内容 **/
    private String content;
    
    /** 状态 0.未审核1.正常2.审核不通过 **/
    private String status;
    
    /** 包装规格 **/
    private String pack_spec_code;
    
    /**  **/
    private String remark;
    
    /**  **/
    private String create_user;
    
    /**  **/
    private String create_time;
    
    /**  **/
    private String update_user;
    
    /**  **/
    private String update_time;
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public void setStart_time(String start_time){
        this.start_time = start_time;
    }
    
    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }
    
    public String getClient_code(){
        return client_code;
    }
    
    public void setClient_code(String client_code){
        this.client_code = client_code;
    }
    
    public String getProduct_code(){
        return product_code;
    }
    
    public void setProduct_code(String product_code){
        this.product_code = product_code;
    }
    
    public Integer getCollect_num() {
		return collect_num;
	}

	public void setCollect_num(Integer collectNum) {
		collect_num = collectNum;
	}

	public Integer getClick_num() {
		return click_num;
	}

	public void setClick_num(Integer clickNum) {
		click_num = clickNum;
	}

	public Integer getAttention_num() {
		return attention_num;
	}

	public void setAttention_num(Integer attentionNum) {
		attention_num = attentionNum;
	}

	public String getSupply_num(){
        return supply_num;
    }
    
    public void setSupply_num(String supply_num){
        this.supply_num = supply_num;
    }
    
    public String getDemand_num(){
        return demand_num;
    }
    
    public void setDemand_num(String demand_num){
        this.demand_num = demand_num;
    }
    
    public String getSd_unit_code(){
        return sd_unit_code;
    }
    
    public void setSd_unit_code(String sd_unit_code){
        this.sd_unit_code = sd_unit_code;
    }
    
    public String getUnit_price(){
        return unit_price;
    }
    
    public void setUnit_price(String unit_price){
        this.unit_price = unit_price;
    }
    
    public String getUnit_code(){
        return unit_code;
    }
    
    public void setUnit_code(String unit_code){
        this.unit_code = unit_code;
    }
    
    public String getSd_type(){
        return sd_type;
    }
    
    public void setSd_type(String sd_type){
        this.sd_type = sd_type;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getPack_spec_code(){
        return pack_spec_code;
    }
    
    public void setPack_spec_code(String pack_spec_code){
        this.pack_spec_code = pack_spec_code;
    }
    
    public String getRemark(){
        return remark;
    }
    
    public void setRemark(String remark){
        this.remark = remark;
    }
    
    public String getCreate_user(){
        return create_user;
    }
    
    public void setCreate_user(String create_user){
        this.create_user = create_user;
    }
    
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }
    public String getCreate_time(){
    	if(create_time != null && !create_time.equals("") && create_time.length()>10){
    		create_time = create_time.substring(0,10);
    	}
        return create_time;
    }
    public String getUpdate_time(){
    	if(update_time != null && !update_time.equals("") && update_time.length()>10){
    		update_time = update_time.substring(0,10);
    	}
        return update_time;
    }
    public String getUpdate_user(){
        return update_user;
    }
    
    public void setUpdate_user(String update_user){
        this.update_user = update_user;
    }
    
    public void setUpdate_time(String update_time){
        this.update_time = update_time;
    }
    public String getStart_time() {
		if (start_time != null && !start_time.equals("")
				&& start_time.length() > 10) {
			start_time = start_time.substring(0, 10);
		}
		return start_time;
	}
	public String getEnd_time() {
		if (end_time != null && !end_time.equals("")
				&& end_time.length() > 10) {
			end_time = end_time.substring(0, 10);
		}
		return end_time;
	}
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String imageUrl) {
		image_url = imageUrl;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String fullName) {
		full_name = fullName;
	}
	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	


    
}