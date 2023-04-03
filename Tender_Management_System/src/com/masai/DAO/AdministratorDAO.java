package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Administrator;
import com.masai.DTO.VendorDTO;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public interface AdministratorDAO {
	public List<VendorDTO> viewVendor() throws SomethingWentWrongException,NoRecordFoundException;
	public void addTender(String tenderName, String description, String startDate, String endDate) throws SomethingWentWrongException;
	public List<Administrator> viewAllTenders() throws SomethingWentWrongException;
	
}
