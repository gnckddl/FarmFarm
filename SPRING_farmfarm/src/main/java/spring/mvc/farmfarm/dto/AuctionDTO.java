package spring.mvc.farmfarm.dto;

import java.util.Date;

public class AuctionDTO {
   
   private int stock_no;
   private int farm_key;
   private String stock_name;
    private String stock_detail;
    private int stock_kg;
    private int stock_ea;
    private int stock_price;
    private String stock_image;
    private int stock_regDate; 
    private int stock_kind ;
    private Date auc_regDate;
    private int auc_join;
    private int auc_startPrice;
    private Integer auc_nowPrice;
    private Date auc_endDate;
    private String auc_title;
    //화면뿌릴려고 추가
    private String mem_id;
    private String auc_no;
    private int join_aucPrice;
    private Date join_regDate;
    
	//auc_endDate로 수정해야함
    private Date auc_term;
    private int cnt;		//참여횟수
    
    
    
	public final int getJoin_aucPrice() {
		return join_aucPrice;
	}
	public final void setJoin_aucPrice(int join_aucPrice) {
		this.join_aucPrice = join_aucPrice;
	}
	public final Date getJoin_regDate() {
		return join_regDate;
	}
	public final void setJoin_regDate(Date join_regDate) {
		this.join_regDate = join_regDate;
	}
	public final String getAuc_title() {
		return auc_title;
	}
	public final void setAuc_title(String auc_title) {
		this.auc_title = auc_title;
	}
	public final int getCnt() {
		return cnt;
	}
	public final void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public final String getAuc_no() {
		return auc_no;
	}
	public final void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}
	public final String getMem_id() {
		return mem_id;
	}
	public final void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
    public final Integer getAuc_nowPrice() {
		return auc_nowPrice;
	}
	public final void setAuc_nowPrice(Integer auc_nowPrice) {
		this.auc_nowPrice = auc_nowPrice;
	}
	public final int getAuc_join() {
		return auc_join;
	}
	public final void setAuc_join(int auc_join) {
		this.auc_join = auc_join;
	}
	public final int getAuc_startPrice() {
		return auc_startPrice;
	}
	public final void setAuc_startPrice(int auc_startPrice) {
		this.auc_startPrice = auc_startPrice;
	}
	public final Date getAuc_endDate() {
		return auc_endDate;
	}
	public final void setAuc_endDate(Date auc_endDate) {
		this.auc_endDate = auc_endDate;
	}
public int getStock_no() {
      return stock_no;
   }
   public void setStock_no(int stock_no) {
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
    
}