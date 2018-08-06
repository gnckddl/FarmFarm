package spring.mvc.farmfarm.dto;

import java.util.Date;

public class FundListDTO {
   
	private int stock_no;
	private String stock_name;
    private String stock_detail;
    private int stock_kg;
    private int stock_ea;
    private int stock_price;
    private String stock_image;
    private int stock_regDate; 
    private int stock_kind ;
	private String fund_no;
	private String fund_title;
	private int fund_price;
	private int fund_status;
	private Date fund_regDate;
	private Date fund_endDate;
	private int farm_key;
	
	
	
	public Date getFund_regDate() {
		return fund_regDate;
	}
	public void setFund_regDate(Date fund_regDate) {
		this.fund_regDate = fund_regDate;
	}
	public int getFarm_key() {
		return farm_key;
	}
	public void setFarm_key(int farm_key) {
		this.farm_key = farm_key;
	}
	public int getStock_no() {
		return stock_no;
	}
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getStock_detail() {
		return stock_detail;
	}
	public void setStock_detail(String stock_detail) {
		this.stock_detail = stock_detail;
	}
	public int getStock_kg() {
		return stock_kg;
	}
	public void setStock_kg(int stock_kg) {
		this.stock_kg = stock_kg;
	}
	public int getStock_ea() {
		return stock_ea;
	}
	public void setStock_ea(int stock_ea) {
		this.stock_ea = stock_ea;
	}
	public int getStock_price() {
		return stock_price;
	}
	public void setStock_price(int stock_price) {
		this.stock_price = stock_price;
	}
	public String getStock_image() {
		return stock_image;
	}
	public void setStock_image(String stock_image) {
		this.stock_image = stock_image;
	}
	public int getStock_regDate() {
		return stock_regDate;
	}
	public void setStock_regDate(int stock_regDate) {
		this.stock_regDate = stock_regDate;
	}
	public int getStock_kind() {
		return stock_kind;
	}
	public void setStock_kind(int stock_kind) {
		this.stock_kind = stock_kind;
	}
	public String getFund_no() {
		return fund_no;
	}
	public void setFund_no(String fund_no) {
		this.fund_no = fund_no;
	}
	public String getFund_title() {
		return fund_title;
	}
	public void setFund_title(String fund_title) {
		this.fund_title = fund_title;
	}
	public int getFund_price() {
		return fund_price;
	}
	public void setFund_price(int fund_price) {
		this.fund_price = fund_price;
	}
	public int getFund_status() {
		return fund_status;
	}
	public void setFund_status(int fund_status) {
		this.fund_status = fund_status;
	}
	public Date getFund_endDate() {
		return fund_endDate;
	}
	public void setFund_endDate(Date fund_endDate) {
		this.fund_endDate = fund_endDate;
	}
}