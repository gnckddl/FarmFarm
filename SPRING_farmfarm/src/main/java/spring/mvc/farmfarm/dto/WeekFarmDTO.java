package spring.mvc.farmfarm.dto;

import java.sql.Date;

/**
 *	주말농장 DTO
 */
public class WeekFarmDTO {
	 /* tbl_wfarm (주말농장) */
	   private int wfarm_key; // 주말농장 키(시퀀스) - 숫자로만(PK)
	   private String mem_id; // 회원 아이디(임대자)(FK)
	   private int farm_key; // 농부의 고유키(시퀀스) - 숫자로만(FK)

	   /* tbl_wfarmInfo (주말농장 상세 정보) */
	   private String wfarmInfo_title; // 주말농장 닉네임(이름)
	   private int wfarmInfo_price; // 1평당 가격(1x1 가격) : check
	   private int wfarmInfo_status; // 주말농장 상태(1: 승인대기, 2: 승인)
	   private Date wfarmInfo_regDate; // 주말농장 신청일 default : sysdate

	   /* tbl_iot (주말농장 IoT 데이터값) */
	   private String iot_soilHumi; // 토양습도(파일명 - 경로)
	   private String iot_temp; // 온도(파일명 - 경로)
	   private String iot_video; // 영상(파일명 - 경로)
	   private Date iot_date; // 값을 보낸 날짜(파일명 - 경로)
	
/**
 * 	장렬
 * 농부 - 주말농장 신청  DTO 매개변수 추가
 * 2018-07-30
 */
	private String wfarminfo_title;		// 주말농장 신청 시 닉네임 작성
	private int wfarminfo_price;		//평당 땅 가격 금액 산정
	private int wfarm_status;			//관리자 승인 상태코드 (1.대기 2.확정)
	private int num;          			//작성 글번호 (추후 소팅을 위한 정렬기능)
	private String wfarminfo_add;		//주말농장 주소 입력
	
//setter
	public void setWfarm_key(int wfarm_key) {
		this.wfarm_key = wfarm_key;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public void setFarm_key(int farm_key) {
		this.farm_key = farm_key;
	}

	
	//농부 - 주말농장 신청  DTO setter START
	public void setWfarminfo_title(String wfarminfo_title) {
		this.wfarminfo_title = wfarminfo_title;
	}
	public void setWfarminfo_price(int wfarminfo_price) {
		this.wfarminfo_price = wfarminfo_price;
	}
	public void setWfarm_status(int wfarm_status) {
		this.wfarm_status = wfarm_status;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setWfarminfo_add(String wfarminfo_add) {
		this.wfarminfo_add = wfarminfo_add;
	}
	//농부 - 주말농장 신청  DTO setter END
	
	//getter
	public int getWfarm_key() {
		return wfarm_key;
	}
	public String getMem_id() {
		return mem_id;
	}
	public int getFarm_key() {
		return farm_key;
	}

	//농부 - 주말농장 신청  DTO getter START
	public String getWfarminfo_title() {
		return wfarminfo_title;
	}
	public int getWfarminfo_price() {
		return wfarminfo_price;
	}
	public int getWfarm_status() {
		return wfarm_status;
	}
	public int getNum() {
		return num;
	}
	public String getWfarminfo_add() {
		return wfarminfo_add;
	}
	//농부 - 주말농장 신청  DTO getter END
	public final String getWfarmInfo_title() {
		return wfarmInfo_title;
	}
	public final void setWfarmInfo_title(String wfarmInfo_title) {
		this.wfarmInfo_title = wfarmInfo_title;
	}
	public final int getWfarmInfo_price() {
		return wfarmInfo_price;
	}
	public final void setWfarmInfo_price(int wfarmInfo_price) {
		this.wfarmInfo_price = wfarmInfo_price;
	}
	public final int getWfarmInfo_status() {
		return wfarmInfo_status;
	}
	public final void setWfarmInfo_status(int wfarmInfo_status) {
		this.wfarmInfo_status = wfarmInfo_status;
	}
	public final Date getWfarmInfo_regDate() {
		return wfarmInfo_regDate;
	}
	public final void setWfarmInfo_regDate(Date wfarmInfo_regDate) {
		this.wfarmInfo_regDate = wfarmInfo_regDate;
	}
	public final String getIot_soilHumi() {
		return iot_soilHumi;
	}
	public final void setIot_soilHumi(String iot_soilHumi) {
		this.iot_soilHumi = iot_soilHumi;
	}
	public final String getIot_temp() {
		return iot_temp;
	}
	public final void setIot_temp(String iot_temp) {
		this.iot_temp = iot_temp;
	}
	public final String getIot_video() {
		return iot_video;
	}
	public final void setIot_video(String iot_video) {
		this.iot_video = iot_video;
	}
	public final Date getIot_date() {
		return iot_date;
	}
	public final void setIot_date(Date iot_date) {
		this.iot_date = iot_date;
	}
	
	
	
	
}
