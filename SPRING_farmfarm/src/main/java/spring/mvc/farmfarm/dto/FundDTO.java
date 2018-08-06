package spring.mvc.farmfarm.dto;

public class FundDTO {

	private String fund_no; // 펀드 번호(PK) (시퀀스 - F_00000001)
	private String stock_no; // 상품 번호(FK) (시퀀스 - S_00000001)
	private String stock_detail;
	private String stock_name;
	private int stock_kg;
	private int stock_ea;
	private int stock_price;
	private int stock_regDate;
	private int stock_kind;

	private String fund_title; // 펀드명
	private String fund_content; // 펀드내용
	private int fund_price; // 펀드 액수(=리워드 금액) --> 상품 금액 : check >0
	private int fund_status; // 펀드 상태(1미등록 2진행중 3종료)
	private String fund_regDate; // 펀드 등록일 (Default: sysdate)
	private String fund_endDate; // 펀드 종료일 (펀드를 언제 종료할지 농부가 정한다.)
	private int rNum;
	private int farm_key;
	private int fund_join;

	private String stock_image; // 리스트에서사용하기위해추가
	private String mem_id; // 리스트에서사용하기위해추가

	
	
	
	
	public final String getStock_name() {
		return stock_name;
	}

	public final void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public final String getStock_detail() {
		return stock_detail;
	}

	public final void setStock_detail(String stock_detail) {
		this.stock_detail = stock_detail;
	}

	public final int getStock_kg() {
		return stock_kg;
	}

	public final void setStock_kg(int stock_kg) {
		this.stock_kg = stock_kg;
	}

	public final int getStock_ea() {
		return stock_ea;
	}

	public final void setStock_ea(int stock_ea) {
		this.stock_ea = stock_ea;
	}

	public final int getStock_price() {
		return stock_price;
	}

	public final void setStock_price(int stock_price) {
		this.stock_price = stock_price;
	}

	public final int getStock_regDate() {
		return stock_regDate;
	}

	public final void setStock_regDate(int stock_regDate) {
		this.stock_regDate = stock_regDate;
	}

	public final int getStock_kind() {
		return stock_kind;
	}

	public final void setStock_kind(int stock_kind) {
		this.stock_kind = stock_kind;
	}

	public String getFund_no() {
		return fund_no;
	}

	public void setFund_no(String fund_no) {
		this.fund_no = fund_no;
	}

	public String getStock_no() {
		return stock_no;
	}

	public void setStock_no(String stock_no) {
		this.stock_no = stock_no;
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

	public String getFund_regDate() {
		return fund_regDate;
	}

	public void setFund_regDate(String fund_regDate) {
		this.fund_regDate = fund_regDate;
	}

	public String getFund_endDate() {
		return fund_endDate;
	}

	public void setFund_endDate(String fund_endDate) {
		this.fund_endDate = fund_endDate;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getFarm_key() {
		return farm_key;
	}

	public void setFarm_key(int farm_key) {
		this.farm_key = farm_key;
	}

	public String getStock_image() {
		return stock_image;
	}

	public void setStock_image(String stock_image) {
		this.stock_image = stock_image;
	}

	public int getFund_join() {
		return fund_join;
	}

	public void setFund_join(int fund_join) {
		this.fund_join = fund_join;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getFund_content() {
		return fund_content;
	}

	public void setFund_content(String fund_content) {
		this.fund_content = fund_content;
	}

}
