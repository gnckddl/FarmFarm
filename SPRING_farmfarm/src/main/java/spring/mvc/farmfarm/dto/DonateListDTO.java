package spring.mvc.farmfarm.dto;

import java.util.Date;

public class DonateListDTO {
   
	private int doForm_id;
	private String mem_id;
    private String doOrg_name;
    private String doOrg_image;
    private String doOrg_hp;
    private String doOrg_address;
    private String doOrg_person;
    private int dona_no;
    private int dona_price;
    private Date dona_date;
    
	public int getDoForm_id() {
		return doForm_id;
	}
	public void setDoForm_id(int doForm_id) {
		this.doForm_id = doForm_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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
	public int getDona_no() {
		return dona_no;
	}
	public void setDona_no(int dona_no) {
		this.dona_no = dona_no;
	}
	public int getDona_price() {
		return dona_price;
	}
	public void setDona_price(int dona_price) {
		this.dona_price = dona_price;
	}
	public Date getDona_date() {
		return dona_date;
	}
	public void setDona_date(Date dona_date) {
		this.dona_date = dona_date;
	}
}