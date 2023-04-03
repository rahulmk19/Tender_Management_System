package com.masai.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.AdministratorDAO;
import com.masai.DAO.AdministratorDAOimpl;
import com.masai.DTO.Administrator;
import com.masai.DTO.VendorDTO;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public class AdministratorUI {
	
	static ArrayList<String> vendors = new ArrayList<String>();
    static ArrayList<String> tenders = new ArrayList<String>();
    static ArrayList<String> bids = new ArrayList<String>();

	static void viewVendors() {
		AdministratorDAO dao = new AdministratorDAOimpl();
		try {
			List<VendorDTO> list = dao.viewVendor();
			for (VendorDTO i : list) {
				System.out.println(i.getId() + " " + i.getName()+" "+ i.getPhone()+" "+i.getAddress());
			}
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	static void createTender(Scanner scanner) {
		System.out.print("Enter tender name: ");
        String tenderName = scanner.next();
        
        System.out.print("Enter tender description: ");
        String description = scanner.next();
        
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.next();
        
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.next();
        AdministratorDAO dao = new AdministratorDAOimpl();
        try {
			dao.addTender(tenderName, description, startDate, endDate);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	static void viewTenders() {
		AdministratorDAO dao = new AdministratorDAOimpl();
		try {
			List<Administrator> list = dao.viewAllTenders();
			
			for(Administrator i : list) {
				System.out.println(i);
//				System.out.println(i.getTender_name(),i.getDescription(),i.getStart_date(),i.getEnd_date(),i.getStatus());
			}
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void viewBids(Scanner input) {
		System.out.print("Enter tender name: ");
		String tender = input.nextLine();
		System.out.println("All bids for tender " + tender + ":");
//        for (String bid : bids) {
//            if (bid.contains(tender)) {
//                System.out.println(bid);
//            }
//        }
	}

	static void assignTender(Scanner input) {
		System.out.print("Enter vendor name: ");
		String vendor = input.nextLine();
		System.out.print("Enter tender name: ");
		String tender = input.nextLine();
//        bids.add(vendor + " bid for " + tender);
		System.out.println("Tender " + tender + " assigned to vendor " + vendor + " successfully.");
	}

}
