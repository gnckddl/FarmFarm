package spring.mvc.farmfarm.dto;


public class AdvantageDTO {
	private int adv_key;
	private String mem_id;
	private int adv_reason;
	private int adv_point;
	//private int adv_sumPoint;
	private String adv_regDate;
	private Integer mem_adv;
	//adv 목록가져올때 번호순서를 위해서 추가
	private int rNum;
	
	
	
	
	public final Integer getMem_adv() {
		return mem_adv;
	}
	public final void setMem_adv(Integer mem_adv) {
		this.mem_adv = mem_adv;
	}
	public  int getrNum() {
		return rNum;
	}
	public  void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getAdv_key() {
		return adv_key;
	}
	public void setAdv_key(int adv_key) {
		this.adv_key = adv_key;
	}
	public  String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getAdv_reason() {
		return adv_reason;
	}
	public void setAdv_reason(int adv_reason) {
		this.adv_reason = adv_reason;
	}
	public int getAdv_point() {
		return adv_point;
	}
	public void setAdv_point(int adv_point) {
		this.adv_point = adv_point;
	}
	public String getAdv_regDate() {
		return adv_regDate;
	}
	public void setAdv_regDate(String adv_regDate) {
		this.adv_regDate = adv_regDate;
	}
	
		
       
}
