package spring.mvc.farmfarm.dto;

import java.util.ArrayList;
import java.util.Date;

public class OrderDTO {
	/* tbl_member (회원) */
	private String mem_id; // 회원 아이디
	private String mem_pwd; // 회원 비밀번호
	private String mem_name; // 회원 이름
	private String mem_hp; // 회원 휴대폰 번호
	private String mem_email; // 회원 이메일
	private String mem_address; // 회원 주소
	private int mem_grade; // 회원 등급
	private int mem_adv; // 회원 점수
	private Date mem_regDate; // 회원 가입일
	private String mem_drop; // 탈퇴여부

	/* tbl_stock (상품) */
	private String stock_no; // 상품 번호(시퀀스)
	private int farm_key; // 농부의 고유키(시퀀스)
	private String stock_name; // 상품명
	private String stock_detail; // 상품특징
	private int stock_kg; // 무게(kg)
	private int stock_ea; // 개수(ea)
	private int stock_price; // 상품가격
	private String stock_image; // 이미지(경로)
	private int stock_regDate; // 상품배송기간 (주단
	// 종류(1: 이벤트, 2: 농산, 3: 축산, 4: 수산, 5: 건강·유기농, 6: 버섯, 7: 주류, 8: 기타)
	private int stock_kind;

	/* tbl_order (주문) */
	private String order_no; // 주문 번호(거래 요청이 들어온 순서) D_00000001(PK)

	/* tbl_orInfo (주문 상세 정보) */
	//테이블수정후 후창이추가
	private int oInfo_no;
	
	private int order_kg; // 회원이 구매한 무게(g으로 입력할 경우, 입력시에는 ÷1000을 하고, 보여줄 때는 ×1000을 해준다.) : check
	private int order_ea; // 회원이 구매한 수량 : check
	private int order_status; // 거래 상태(1: 구매요청, 2: 구매완료, 3: 환불요청, 4: 환불완료)
	private Date order_date; // 거래 상태가 바뀐 날짜(status가 변경되었을 때의 날짜)
	private int order_kind; // 주문 종류 (1: 펀드, 2: 경매)

	/* tbl_pay (결제) : 거래 들어온 상황에 맞춰서 / '카카오페이' */
	private int pay_price; // 결제 금액 : check
	private int pay_status; // 결제 상태(1: 결제 미완료, 2: 결제 완료, 3: 결제 취소)
	private Date pay_date; // 결제 상태가 바뀐 날짜(status가 변경되었을 때의 날짜)

	/* tbl_delivery (배송) : 주문 번호에 맞는 값을 Update한다. */
	private String de_no; // 배송 번호(배송 요청이 들어온 순서) D_00000001(PK)
	private int de_status; // 배송 상태(1: 배송요청, 2: 배송준비중, 3: 배송중, 4: 배송완료)
	private Date de_arrDate; // 배송 예정일
	//테이블수정후 후창이추가
	private String de_address;

	/* tbl_join(참여회원):경매,펀드에 참여한 회원 */
	private int join_no; // 회원시퀀스(그냥숫자)(PK)
	private String fund_no; // 펀드 번호(시퀀스) - F_00000001(FK)
	private String auc_no; // 경매 번호(시퀀스) - A_00000001(FK)
	private int join_aucPrice; // 경매 참여 액수 : check
	private int join_fundPrice; // 펀드 참여 액수 : check
	private Date join_regDate; // 참여일 default : sysdate


	//후창 주소 나눠서뿌리려고 추가함
	private String[] addr;//0:우편주소,1:기본주소,2:상세주소
	
	
	
	

	public final String[] getAddr() {
		return addr;
	}

	public final void setAddr(String[] addr) {
		this.addr = addr;
	}

	public final int getoInfo_no() {
		return oInfo_no;
	}

	public final void setoInfo_no(int oInfo_no) {
		this.oInfo_no = oInfo_no;
	}

	public final String getDe_address() {
		return de_address;
	}

	public final void setDe_address(String de_address) {
		this.de_address = de_address;
	}

	public int getOrder_kind() {
		return order_kind;
	}

	public void setOrder_kind(int order_kind) {
		this.order_kind = order_kind;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_hp() {
		return mem_hp;
	}

	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public int getMem_grade() {
		return mem_grade;
	}

	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}

	public int getMem_adv() {
		return mem_adv;
	}

	public void setMem_adv(int mem_adv) {
		this.mem_adv = mem_adv;
	}

	public Date getMem_regDate() {
		return mem_regDate;
	}

	public void setMem_regDate(Date mem_regDate) {
		this.mem_regDate = mem_regDate;
	}

	public String getMem_drop() {
		return mem_drop;
	}

	public void setMem_drop(String mem_drop) {
		this.mem_drop = mem_drop;
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

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public int getOrder_kg() {
		return order_kg;
	}

	public void setOrder_kg(int order_kg) {
		this.order_kg = order_kg;
	}

	public int getOrder_ea() {
		return order_ea;
	}

	public void setOrder_ea(int order_ea) {
		this.order_ea = order_ea;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getPay_price() {
		return pay_price;
	}

	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}

	public int getPay_status() {
		return pay_status;
	}

	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public String getDe_no() {
		return de_no;
	}

	public void setDe_no(String de_no) {
		this.de_no = de_no;
	}

	public int getDe_status() {
		return de_status;
	}

	public void setDe_status(int de_status) {
		this.de_status = de_status;
	}

	public Date getDe_arrDate() {
		return de_arrDate;
	}

	public void setDe_arrDate(Date de_arrDate) {
		this.de_arrDate = de_arrDate;
	}

	public int getJoin_no() {
		return join_no;
	}

	public void setJoin_no(int join_no) {
		this.join_no = join_no;
	}

	public String getFund_no() {
		return fund_no;
	}

	public void setFund_no(String fund_no) {
		this.fund_no = fund_no;
	}

	public String getAuc_no() {
		return auc_no;
	}

	public void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}

	public int getJoin_aucPrice() {
		return join_aucPrice;
	}

	public void setJoin_aucPrice(int join_aucPrice) {
		this.join_aucPrice = join_aucPrice;
	}

	public int getJoin_fundPrice() {
		return join_fundPrice;
	}

	public void setJoin_fundPrice(int join_fundPrice) {
		this.join_fundPrice = join_fundPrice;
	}

	public Date getJoin_regDate() {
		return join_regDate;
	}

	public void setJoin_regDate(Date join_regDate) {
		this.join_regDate = join_regDate;
	}

}