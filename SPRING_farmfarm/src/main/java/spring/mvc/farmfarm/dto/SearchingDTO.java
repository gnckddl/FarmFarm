package spring.mvc.farmfarm.dto;

public class SearchingDTO {
	//상품부분
	private String stock_no;
	private String stock_name;
	private int stock_kg;
	private int stock_ea;
	private String stock_image;
	private int stock_kind;
	
	//펀드부분
	private String fund_no;
	private String fund_title;
	private int fund_price;
	private int fund_status;
	private String fund_regDate;
	private String fund_endDate;
	
	//경매부분
	private String auc_no;
	private String auc_title;
	private int auc_nowPrice;
	private int auc_status;
	private String auc_regDate;
	private String auc_endDate;
	
	
	
	public final String getFund_endDate() {
		return fund_endDate;
	}
	public final void setFund_endDate(String fund_endDate) {
		this.fund_endDate = fund_endDate;
	}
	public final int getFund_price() {
		return fund_price;
	}
	public final void setFund_price(int fund_price) {
		this.fund_price = fund_price;
	}
	public final int getStock_kg() {
		return stock_kg;
	}
	public final void setStock_kg(int stock_kg) {
		this.stock_kg = stock_kg;
	}
	public final String getStock_no() {
		return stock_no;
	}
	public final void setStock_no(String stock_no) {
		this.stock_no = stock_no;
	}
	public final String getStock_name() {
		return stock_name;
	}
	public final void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public final int getStock_ea() {
		return stock_ea;
	}
	public final void setStock_ea(int stock_ea) {
		this.stock_ea = stock_ea;
	}
	public final String getStock_image() {
		return stock_image;
	}
	public final void setStock_image(String stock_image) {
		this.stock_image = stock_image;
	}
	public final int getStock_kind() {
		return stock_kind;
	}
	public final void setStock_kind(int stock_kind) {
		this.stock_kind = stock_kind;
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
	public final int getFund_status() {
		return fund_status;
	}
	public final void setFund_status(int fund_status) {
		this.fund_status = fund_status;
	}
	public final String getFund_regDate() {
		return fund_regDate;
	}
	public final void setFund_regDate(String fund_regDate) {
		this.fund_regDate = fund_regDate;
	}
	public final String getAuc_no() {
		return auc_no;
	}
	public final void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}
	public final String getAuc_title() {
		return auc_title;
	}
	public final void setAuc_title(String auc_title) {
		this.auc_title = auc_title;
	}
	public final int getAuc_nowPrice() {
		return auc_nowPrice;
	}
	public final void setAuc_nowPrice(int auc_nowPrice) {
		this.auc_nowPrice = auc_nowPrice;
	}
	public final int getAuc_status() {
		return auc_status;
	}
	public final void setAuc_status(int auc_status) {
		this.auc_status = auc_status;
	}
	public final String getAuc_regDate() {
		return auc_regDate;
	}
	public final void setAuc_regDate(String auc_regDate) {
		this.auc_regDate = auc_regDate;
	}
	public final String getAuc_endDate() {
		return auc_endDate;
	}
	public final void setAuc_endDate(String auc_endDate) {
		this.auc_endDate = auc_endDate;
	}
	
	
	
}
