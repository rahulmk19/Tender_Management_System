package com.masai.DAO;

import java.util.List;

import com.masai.DTO.VendorDTO;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public interface AdministratorDAO {
	public List<VendorDTO> viewVendor() throws SomethingWentWrongException,NoRecordFoundException;
}
