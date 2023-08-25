package com.masai.ui;

import java.util.Scanner;

import com.masai.DAO.VendorDao;
import com.masai.DAO.VendorDaoImpl;
import com.masai.DTO.Vendor;
import com.masai.exception.VendorException;

public class Main {

	static void Vendor(Scanner scanner) throws VendorException {

		VendorDao vendorDao = new VendorDaoImpl();

		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();

		Vendor vendor = vendorDao.AuthenticateVendor(username);

		if (vendor.getVender_email().equals(username) && vendor.getVender_password().equals(password)) {
			VendorUI.option(scanner, vendor);
		} else {
			System.out.println("Please Give a correct username and password");
			return;
		}
	}

	static void Administrator(Scanner input) {
		System.out.print("Enter username: ");
		String user = input.next();
		System.out.print("Enter password: ");
		String pass = input.next();

		if (!user.equals("Admin") || !pass.equals("Admin")) {
			System.out.println("Please Fill The Correct Username and Password\n");
			return;
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Welcome Administrator");
		String choice;

		do {
			System.out.println("*** MENU ***");
			System.out.println("1. Register Vendor");
			System.out.println("2. View All Vendors");
			System.out.println("3. Create New Tender");
			System.out.println("4. View All Tenders");
			System.out.println("5. View All Bids Against A Tender");
			System.out.println("6. Assign Tender To A Vendor");
			System.out.println("0. Logout");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

			System.out.print("\nEnter your choice: ");
			choice = input.next();

			switch (choice) {

			case "1":
				AdministratorUI.register(input);
				break;
			case "2":
				AdministratorUI.viewVendors();
				break;
			case "3":
				AdministratorUI.createTender(input);
				break;
			case "4":
				AdministratorUI.viewTenders();
				break;
			case "5":
				AdministratorUI.viewBids(input);
				break;
			case "6":
				AdministratorUI.assignTender(input);
				break;
			case "0":
				// Logout
				System.out.println("0: Logout successful.");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (!choice.equals("0"));

	}

	public static void main(String[] args) throws VendorException {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("1. Administrator");
			System.out.println("2. Vendor Login");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Administrator(sc);
				break;

			case 2:
				Vendor(sc);
				break;

			default:
				System.out.println("Please Select Correct Option");
			}
		} while (choice != 0);
		sc.close();
	}

}
