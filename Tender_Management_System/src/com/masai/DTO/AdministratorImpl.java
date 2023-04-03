package com.masai.DTO;

import java.time.LocalDate;

public class AdministratorImpl implements Administrator {
	private int tender_id;
	private String tender_name;
	private String description;
	private LocalDate start_date;
	private LocalDate end_date;
	private String status;
	
	public AdministratorImpl(String tender_name, String description, LocalDate start_date, LocalDate end_date,
			String status) {
		super();
		this.tender_name = tender_name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}
	
	public int getTender_id() {
		return tender_id;
	}
	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}
	public String getTender_name() {
		return tender_name;
	}
	public void setTender_name(String tender_name) {
		this.tender_name = tender_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.tender_id=int1;
		
	}
	@Override
	public String toString() {
		return "Tender_name=" + tender_name + ", Description="
				+ description + ", Start_date=" + start_date + ", End_date=" + end_date + ", Status=" + status + "";
	}

	

	
	
}
