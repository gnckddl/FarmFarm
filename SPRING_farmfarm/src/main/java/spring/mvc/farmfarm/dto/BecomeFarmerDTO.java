package spring.mvc.farmfarm.dto;

import java.util.Date;

public class BecomeFarmerDTO {
   
	private int farm_key;
	private String fPlan_title;
    private String fPlan_plan;
    private int fPlan_capital; 
	private String fPlan_use;
	private String fPlan_address;
	private String mem_id;
	private int farm_status;
	private String fPlan_detail;
	
	public String getfPlan_detail() {
		return fPlan_detail;
	}
	public void setfPlan_detail(String fPlan_detail) {
		this.fPlan_detail = fPlan_detail;
	}
	public int getFarm_key() {
		return farm_key;
	}
	public void setFarm_key(int farm_key) {
		this.farm_key = farm_key;
	}
	public String getfPlan_title() {
		return fPlan_title;
	}
	public void setfPlan_title(String fPlan_title) {
		this.fPlan_title = fPlan_title;
	}
	public String getfPlan_plan() {
		return fPlan_plan;
	}
	public void setfPlan_plan(String fPlan_plan) {
		this.fPlan_plan = fPlan_plan;
	}
	public int getfPlan_capital() {
		return fPlan_capital;
	}
	public void setfPlan_capital(int fPlan_capital) {
		this.fPlan_capital = fPlan_capital;
	}
	public String getfPlan_use() {
		return fPlan_use;
	}
	public void setfPlan_use(String fPlan_use) {
		this.fPlan_use = fPlan_use;
	}
	public String getfPlan_address() {
		return fPlan_address;
	}
	public void setfPlan_address(String fPlan_address) {
		this.fPlan_address = fPlan_address;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getFarm_status() {
		return farm_status;
	}
	public void setFarm_status(int farm_status) {
		this.farm_status = farm_status;
	}
	
	
}