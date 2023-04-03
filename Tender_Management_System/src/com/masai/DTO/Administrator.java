package com.masai.DTO;

import java.time.LocalDate;

public interface Administrator {
	
	public int getTender_id();
	
	public void setTender_id(int tender_id);
	
	public String getTender_name();
	
	public void setTender_name(String tender_name);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public LocalDate getStart_date();
	
	public void setStart_date(LocalDate start_date);
	
	public LocalDate getEnd_date();
	
	public void setEnd_date(LocalDate end_date);
	
	public String getStatus();

	public void setStatus(String status);

	public void setId(int int1);
	
	

}
