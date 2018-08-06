package spring.mvc.farmfarm.dto;


public class RankingDTO {

	//펀드기준, 경매,기부는 이름맞춰서 사용
	private String fund_no;	
	private String fund_title;
	private String stock_name;
	private String stock_price;
	private String farmer_id;		
	private int fund_price;
	private String fund_endDate;	
	private int fund_join;
	
	
	
	public final int getFund_join() {
		return fund_join;
	}
	public final void setFund_join(int fund_join) {
		this.fund_join = fund_join;
	}
	public final String getFarmer_id() {
		return farmer_id;
	}
	public final void setFarmer_id(String farmer_id) {
		this.farmer_id = farmer_id;
	}
	public final String getStock_price() {
		return stock_price;
	}
	public final void setStock_price(String stock_price) {
		this.stock_price = stock_price;
	}
	public final String getFund_endDate() {
		return fund_endDate;
	}
	public final void setFund_endDate(String fund_endDate) {
		this.fund_endDate = fund_endDate;
	}
	public final String getStock_name() {
		return stock_name;
	}
	public final void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public final String getFund_no() {
		return fund_no;
	}
	public final void setFund_no(String fund_no) {
		this.fund_no = fund_no;
	}
	public final String getFund_title() {
		return fund_title;
	}
	public final void setFund_title(String fund_title) {
		this.fund_title = fund_title;
	}
	public final int getFund_price() {
		return fund_price;
	}
	public final void setFund_price(int fund_price) {
		this.fund_price = fund_price;
	}
	
}
