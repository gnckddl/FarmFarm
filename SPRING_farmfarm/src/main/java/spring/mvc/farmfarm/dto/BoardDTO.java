package spring.mvc.farmfarm.dto;

import java.sql.Date;

public class BoardDTO {

	private int boa_id;      // 글 번호(PK) (시퀀스) 
    private String mem_id;  // 회원 아이디(FK) (시퀀스 - delete_0713_001_아이디)
    private String boa_subject; // 글 제목
    private String boa_content;  // 글 내용
    private int boa_readCnt;	    // 조회 수 (Default: 0)
    private String boa_regDate;    // 글 작성일 (Default: sysdate)
    private String boa_ip;   // 아이피 주소
    private int boa_category;   // 카테고리 (1: 공지사항, 2: 회원 1:1문의, 3: 농부 1:1문의, 4: 농부 소식, 5: 회원 요청, 6: 쪽지)
    private int cm_cnt;			//댓글 카운트를 위해 추가
	private int rNum;
	private String boa_image;		//소식게시판 이미지 추가
	private Date boa_regDate2;    // 글 작성일 (Default: sysdate)
	
	/**
     * 쪽지기능 추가 DTO - 고장렬
     */
    private String letter_id;	// 쪽지 수신자
    
    
    
	public final Date getBoa_regDate2() {
		return boa_regDate2;
	}
	public final void setBoa_regDate2(Date boa_regDate2) {
		this.boa_regDate2 = boa_regDate2;
	}
	public final String getLetter_id() {
		return letter_id;
	}
	public final void setLetter_id(String letter_id) {
		this.letter_id = letter_id;
	}
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getBoa_id() {
		return boa_id;
	}
	public void setBoa_id(int boa_id) {
		this.boa_id = boa_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBoa_subject() {
		return boa_subject;
	}
	public void setBoa_subject(String boa_subject) {
		this.boa_subject = boa_subject;
	}
	public String getBoa_content() {
		return boa_content;
	}
	public void setBoa_content(String boa_content) {
		this.boa_content = boa_content;
	}
	public int getBoa_readCnt() {
		return boa_readCnt;
	}
	public void setBoa_readCnt(int boa_readCnt) {
		this.boa_readCnt = boa_readCnt;
	}
	
	public String getBoa_regDate() {
		return boa_regDate;
	}
	public void setBoa_regDate(String boa_regDate) {
		this.boa_regDate = boa_regDate;
	}
	public String getBoa_ip() {
		return boa_ip;
	}
	public void setBoa_ip(String boa_ip) {
		this.boa_ip = boa_ip;
	}
	public int getBoa_category() {
		return boa_category;
	}
	public void setBoa_category(int boa_category) {
		this.boa_category = boa_category;
	}
	public int getCm_cnt() {
		return cm_cnt;
	}
	public void setCm_cnt(int cm_cnt) {
		this.cm_cnt = cm_cnt;
	}
	public String getBoa_image() {
		return boa_image;
	}
	public void setBoa_image(String boa_image) {
		this.boa_image = boa_image;
	}

	
    
    
}
