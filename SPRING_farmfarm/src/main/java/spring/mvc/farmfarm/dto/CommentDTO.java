package spring.mvc.farmfarm.dto;

public class CommentDTO {

	  private int cm_no;	     // 댓글 번호(PK) (시퀀스)
	  private int boa_id;       // 글 번호(FK) (시퀀스)
	  private String mem_id;  // 회원 아이디(FK) (회원이 탈퇴할 경우 시퀀스 사용 --> delete_0713_001_아이디)
	  private String cm_content;   // 댓글 내용
	  private String cm_regDate;    // 댓글 작성일 (Default: sysdate)
	
	  
	public int getCm_no() {
		return cm_no;
	}
	public void setCm_no(int cm_no) {
		this.cm_no = cm_no;
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
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public String getCm_regDate() {
		return cm_regDate;
	}
	public void setCm_regDate(String cm_regDate) {
		this.cm_regDate = cm_regDate;
	}
	  
	  
	  
}
