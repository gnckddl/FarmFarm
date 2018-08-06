package spring.mvc.farmfarm.dto;

import java.sql.Date;

public class DonateDTO {
   /* tbl_doOrg (기부단체 상세 정보) : 관리자에서 접근 or 기부단체에서 먼저 접근 */
   private int doForm_id; // 기부단체아이디(시퀀스) - 숫자로만(PK)
   private String doOrg_name; // 기부단체명
   private String doOrg_image; // 기부단체 로고
   private String doOrg_hp; // 기부단체 연락처
   private String doOrg_address; // 기부단체 주소
   private String doOrg_person; // 기부단체 담당자
   private int doOrg_account; // 총 기부 받은 금액
   private Date doOrg_regDate; // 기부단체 등록일
   private String doOrg_title; // 신청 제목
   private String doOrg_content; // 신청 내용

   /* tbl_memDo (회원이 기부한 내역) */
   private String dona_no; // 기부 내역 순서(시퀀스) -
   private String mem_id; // 회원 아이디(삭제시 delete_001_0713_id)시퀀스(FK)
   private int dona_price; // 기부 금액 : check
   private String dona_title; // 기부 제목
   private Date dona_date; // 기부한 날짜

   public int getDoForm_id() {
      return doForm_id;
   }

   public void setDoForm_id(int doForm_id) {
      this.doForm_id = doForm_id;
   }

   public String getDoOrg_name() {
      return doOrg_name;
   }

   public void setDoOrg_name(String doOrg_name) {
      this.doOrg_name = doOrg_name;
   }

   public String getDoOrg_image() {
      return doOrg_image;
   }

   public void setDoOrg_image(String doOrg_image) {
      this.doOrg_image = doOrg_image;
   }

   public String getDoOrg_hp() {
      return doOrg_hp;
   }

   public void setDoOrg_hp(String doOrg_hp) {
      this.doOrg_hp = doOrg_hp;
   }

   public String getDoOrg_address() {
      return doOrg_address;
   }

   public void setDoOrg_address(String doOrg_address) {
      this.doOrg_address = doOrg_address;
   }

   public String getDoOrg_person() {
      return doOrg_person;
   }

   public void setDoOrg_person(String doOrg_person) {
      this.doOrg_person = doOrg_person;
   }

   public int getDoOrg_account() {
      return doOrg_account;
   }

   public void setDoOrg_account(int doOrg_account) {
      this.doOrg_account = doOrg_account;
   }

   public Date getDoOrg_regDate() {
      return doOrg_regDate;
   }

   public void setDoOrg_regDate(Date doOrg_regDate) {
      this.doOrg_regDate = doOrg_regDate;
   }

  

   public String getDoOrg_title() {
   return doOrg_title;
}

public void setDoOrg_title(String doOrg_title) {
   this.doOrg_title = doOrg_title;
}

public String getDoOrg_content() {
   return doOrg_content;
}

public void setDoOrg_content(String doOrg_content) {
   this.doOrg_content = doOrg_content;
}

public String getDona_no() {
      return dona_no;
   }

   public void setDona_no(String dona_no) {
      this.dona_no = dona_no;
   }

   public String getMem_id() {
      return mem_id;
   }

   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }

   public int getDona_price() {
      return dona_price;
   }

   public void setDona_price(int dona_price) {
      this.dona_price = dona_price;
   }

   public String getDona_title() {
      return dona_title;
   }

   public void setDona_title(String dona_title) {
      this.dona_title = dona_title;
   }

   public Date getDona_date() {
      return dona_date;
   }

   public void setDona_date(Date dona_date) {
      this.dona_date = dona_date;
   }

}