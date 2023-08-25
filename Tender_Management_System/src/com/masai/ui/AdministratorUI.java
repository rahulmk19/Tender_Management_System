package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.AdministratorDAO;
import com.masai.DAO.AdministratorDAOimpl;
import com.masai.DTO.Bidder;
import com.masai.DTO.Tender;
import com.masai.DTO.TenderImpl;
import com.masai.DTO.Vendor;
import com.masai.DTO.VendorImpl;

import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public class AdministratorUI {

	public static void register(Scanner scanner) {

		System.out.println("Enter vendor ID");
		String vendorId = scanner.next();
		System.out.println("Enter vendor name");
		String vendorName = scanner.next();
		System.out.println("Enter email:");
		String email = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		System.out.println("Enter Mobile Number:");
		String phone = scanner.next();
		System.out.println("Enter address:");
		String address = scanner.next();

		Vendor user = new VendorImpl(vendorId, password, vendorName, email, phone, address);
		AdministratorDAO adminDao = new AdministratorDAOimpl();
		try {
			adminDao.addVendor(user);
		} catch (VendorException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewVendors() {
		AdministratorDAO adminDao = new AdministratorDAOimpl();
		try {
			adminDao.viewAllVendors();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void createTender(Scanner scanner) {

		System.out.println("Enter Tender ID");
		String tender_id = scanner.next();
		System.out.println("Enter Tender Name");
		String tender_name = scanner.next();
		System.out.println("Enter Type:");
		String type = scanner.next();
		System.out.println("Enter Tender Price:");
		int tender_price = scanner.nextInt();
		System.out.println("Enter Address");
		String tender_location = scanner.next();

		Tender tender = new TenderImpl(tender_id, tender_name, type, tender_price, tender_location);
		AdministratorDAO adminDao = new AdministratorDAOimpl();
		try {
			adminDao.createTender(tender);
		} catch (TenderException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewTenders() {
		List<Tender> list = new ArrayList<>();
		AdministratorDAO adminDao = new AdministratorDAOimpl();

		try {
			list = adminDao.viewAllTenders();
			list.forEach(e -> System.out.println(e));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void viewBids(Scanner input) {
		try {
			System.out.print("ENTER TENDER ID HERE : ");
			String tender_id = input.next();

			AdministratorDAO administratorDAO = new AdministratorDAOimpl();

			List<Bidder> bidderList = administratorDAO.viewAllBidsOfTenders(tender_id);

			if (!bidderList.isEmpty()) {
				System.out.println("Bids for Tender ID: " + tender_id);
				for (Bidder bidder : bidderList) {
					System.out.println(bidder);
				}
			} else {
				System.out.println("No bids found for Tender ID: " + tender_id);
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static void assignTender(Scanner input) {
	    System.out.print("Enter vendor_id: ");
	    String vendor_id = input.next();
	    System.out.print("Enter tender_id: ");
	    String tender_id = input.next();

	    AdministratorDAOimpl adminDao = new AdministratorDAOimpl();

	    try {
	        adminDao.assignTenderToVender(vendor_id, tender_id);
	    } catch (BidderException e) {
	        e.printStackTrace();
	    }
	}


}
