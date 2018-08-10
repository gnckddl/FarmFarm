package spring.mvc.farmfarm.dto;

import java.util.Date;

public class ScheduleDTO {

	private String fund_no;
	private Date fund_endDate;
	
	private String auc_no;
	private Date auc_endDate;
	
	
	
	public final String getFund_no() {
		return fund_no;
	}
	public final void setFund_no(String fund_no) {
		this.fund_no = fund_no;
	}
	public final String getAuc_no() {
		return auc_no;
	}
	public final void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}
	public final Date getFund_endDate() {
		return fund_endDate;
	}
	public final void setFund_endDate(Date fund_endDate) {
		this.fund_endDate = fund_endDate;
	}
	public final Date getAuc_endDate() {
		return auc_endDate;
	}
	public final void setAuc_endDate(Date auc_endDate) {
		this.auc_endDate = auc_endDate;
	}
	
	
	
}
