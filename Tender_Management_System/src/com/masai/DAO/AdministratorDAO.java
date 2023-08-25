package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Administrator;
import com.masai.DTO.Bidder;
import com.masai.DTO.Tender;
import com.masai.DTO.TenderImpl;
import com.masai.DTO.Vendor;
import com.masai.exception.AdministratorException;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface AdministratorDAO {

	public void addVendor(Vendor v) throws VendorException;

	public List<Vendor> viewAllVendors() throws VendorException;

	public void createTender(Tender tender) throws TenderException;

	public List<Tender> viewAllTenders() throws TenderException;

	public List<Bidder> viewAllBidsOfTenders(String tender_id) throws BidderException ;

	public void assignTenderToVender(String venderId, String tenderId) throws BidderException;
}
