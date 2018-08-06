package spring.mvc.farmfarm.dto;

import java.sql.Date;

public class StockDTO {
	
	/*	tbl_stock (상품) */
	private String stock_no; 				//상품 번호(시퀀스)
	private int farm_key;				//농부의 고유키(시퀀스) 
	private String stock_name; 			//상품명
	private String stock_detail; 		//상품특징
	private int stock_kg;				//무게(kg) 
	private int stock_ea;				//개수(ea)
	private int stock_price;			//상품가격
	private String stock_image;			//이미지(경로)
	private int stock_regDate;			//상품배송기간 (주단
	//종류(1: 이벤트, 2: 농산, 3: 축산, 4: 수산, 5: 건강·유기농, 6: 버섯, 7: 주류, 8: 기타)	
	private int stock_kind;				
	
/*	tbl_auction (경매)*/
	private String auc_no;				//경매 번호(시퀀스) - A_00000001(PK)(FK)
	private String auc_title;			//경매명	
	private int auc_startPrice; 		//경매 시작가
	private int auc_nowPrice;			//현재 경매가
	private int auc_finalPrice;			//경매 낙찰가
	private int auc_status;				//경매 낙찰 여부(1: 진행중, 2: 유찰, 3: 낙찰)	
	private Date auc_regDate;			//경매 등록일	
	private Date auc_endDate;			//경매 종료일
	private Date auc_term;				//경매 기간(얼마나 경매를 할 건지 기간을 정한다.)	
	private int auc_join;				//경매참여인원

	/*	tbl_memAuc (회원이 한 경매 정보)*/
	private int memAuc_price;			//경매 액수

/*	tbl_join(참여회원):경매,펀드에 참여한 회원*/
	private int join_no;//회원시퀀스(그냥숫자)(PK)	
	private String mem_id;//회원 아이디(삭제시 delete_001_0713_id)시퀀스(FK)
	private Date join_regDate; //참여일
	
/*	tbl_fund (펀드)*/
	private String fund_no;				//펀드 번호(시퀀스) -
	private String fund_title;			//펀드명	
	private int fund_price;				//펀드 목표액수(=리워드 금액) -->
	private int fund_status;			//펀드 상태(1: 미등록 2: 진행중 3: 종료)
	private Date fund_regDate;			//펀드 등록일	
	private Date fund_endDate;			//펀드 종료일(펀드를 언제 종료할지 농부가 정한다.)	
	private int fund_join;				//펀드참여인원

	
	public Date getAuc_endDate() {
		return auc_endDate;
	}
	public void setAuc_endDate(Date auc_endDate) {
		this.auc_endDate = auc_endDate;
	}
	public int getAuc_join() {
		return auc_join;
	}
	public void setAuc_join(int auc_join) {
		this.auc_join = auc_join;
	}
	public String getStock_no() {
		return stock_no;
	}
	public void setStock_no(String stock_no) {
		this.stock_no = stock_no;
	}
	public int getFarm_key() {
		return farm_key;
	}
	public int getFund_join() {
		return fund_join;
	}
	public void setFund_join(int fund_join) {
		this.fund_join = fund_join;
	}
	public void setFarm_key(int farm_key) {
		this.farm_key = farm_key;
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
	public int getMemAuc_price() {
		return memAuc_price;
	}
	public void setMemAuc_price(int memAuc_price) {
		this.memAuc_price = memAuc_price;
	}
	public int getJoin_no() {
		return join_no;
	}
	public void setJoin_no(int join_no) {
		this.join_no = join_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getJoin_regDate() {
		return join_regDate;
	}
	public void setJoin_regDate(Date join_regDate) {
		this.join_regDate = join_regDate;
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
	public Date getFund_regDate() {
		return fund_regDate;
	}
	public void setFund_regDate(Date fund_regDate) {
		this.fund_regDate = fund_regDate;
	}
	public Date getFund_endDate() {
		return fund_endDate;
	}
	public void setFund_endDate(Date fund_endDate) {
		this.fund_endDate = fund_endDate;
	}
	
}