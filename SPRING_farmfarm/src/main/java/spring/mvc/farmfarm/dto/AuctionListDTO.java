package spring.mvc.farmfarm.dto;

import java.util.Date;

public class AuctionListDTO {

	private String auc_no;
	private String auc_title;
	private int auc_startPrice;
	private int auc_nowPrice;
	private int auc_finalPrice;
	private int auc_status;
	private Date auc_regDate;
	private Date auc_endDate;
	private String stock_image;

	// 삭제예정
	private Date auc_term;

	// 후창추가 리스트뿌릴때 농부이름필요
	private String mem_id;

	public final String getMem_id() {
		return mem_id;
	}

	public final void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public final Date getAuc_endDate() {
		return auc_endDate;
	}

	public final void setAuc_endDate(Date auc_endDate) {
		this.auc_endDate = auc_endDate;
	}

	public String getAuc_no() {
		return auc_no;
	}

	public void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}

	public String getAuc_title() {
		return auc_title;
	}

	public void setAuc_title(String auc_title) {
		this.auc_title = auc_title;
	}

	public int getAuc_startPrice() {
		return auc_startPrice;
	}

	public void setAuc_startPrice(int auc_startPrice) {
		this.auc_startPrice = auc_startPrice;
	}

	public int getAuc_nowPrice() {
		return auc_nowPrice;
	}

	public void setAuc_nowPrice(int auc_nowPrice) {
		this.auc_nowPrice = auc_nowPrice;
	}

	public int getAuc_finalPrice() {
		return auc_finalPrice;
	}

	public void setAuc_finalPrice(int auc_finalPrice) {
		this.auc_finalPrice = auc_finalPrice;
	}

	public int getAuc_status() {
		return auc_status;
	}

	public void setAuc_status(int auc_status) {
		this.auc_status = auc_status;
	}

	public Date getAuc_regDate() {
		return auc_regDate;
	}

	public void setAuc_regDate(Date auc_regDate) {
		this.auc_regDate = auc_regDate;
	}

	public Date getAuc_term() {
		return auc_term;
	}

	public void setAuc_term(Date auc_term) {
		this.auc_term = auc_term;
	}

	public String getStock_image() {
		return stock_image;
	}

	public void setStock_image(String stock_image) {
		this.stock_image = stock_image;
	}

}