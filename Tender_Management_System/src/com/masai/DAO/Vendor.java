package com.masai.DAO;

import java.util.List;

import com.masai.DTO.AdministratorImpl;
import com.masai.DTO.VendorDTO;

import exception.SomethingWentWrongException;

public interface Vendor {
	public List<AdministratorImpl> viewAllTender() throws SomethingWentWrongException;
	public void addVendor(VendorDTO user) throws SomethingWentWrongException;
}
