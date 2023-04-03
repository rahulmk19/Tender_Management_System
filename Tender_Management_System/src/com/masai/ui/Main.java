package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.DbUtils;

public class Main {

//	static void VendorLogin(Scanner sc) throws NoRecordFoundException {
//			
//		if(IsVendorLogged.isLogged) {
//				Vendor(sc);
//		}else {
//			System.out.println("Enter Username!");
//			String username = sc.next();
//			System.out.println("Enter Password!");
//			String password = sc.next();	
//		}	
//	}
//
//	static void VendorSignUp(Scanner sc) throws NoRecordFoundException {
//		
//			
//	}

	static void Vendor(Scanner input) {

		int choice = 0;

		while (true) {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println("Welcome Vendor");
			System.out.println("1: Login");
			System.out.println("2: Sign Up");
			choice = input.nextInt();

			try {

				switch (choice) {
				case 0:
					return;
				case 1:
					VendorUI.login(input);
					break;
				case 2:
					VendorUI.signUp(input);
					break;
				default:
					System.out.println("Invalid choice! Please choose again.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number.");
				input.next();
				continue;
			}

		}

	}

	static void Administrator(Scanner input) {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Welcome Administrator");
		String username = "admin";
		String password = "admin";
		String choice;

		System.out.print("Enter username: ");
		String user = input.next();
		System.out.print("Enter password: ");
		String pass = input.next();

		if (user.equals(username) && pass.equals(password)) {
			System.out.println("Login successful.\n");

			do {
				// Menu
				System.out.println("*** MENU ***");
				System.out.println("1. View all vendors");
				System.out.println("2. Create new tender");
				System.out.println("3. View all tenders");
				System.out.println("4. View all bids of a tender");
				System.out.println("5. Assign tender to a vendor");
				System.out.println("6. Logout");
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

				System.out.print("\nEnter your choice: ");
				choice = input.next();

				switch (choice) {

				case "1":
					AdministratorUI.viewVendors();
					System.out.println("1: View all vendors...");
					break;
				case "2":
					AdministratorUI.createTender(input);
					System.out.println("2: Create new tender...");
					break;
				case "3":
					AdministratorUI.viewTenders();
					System.out.println("3: View all tenders...");
					break;
				case "4":
					AdministratorUI.viewBids(input);
					System.out.println("4: View all bids of a tender...");
					break;
				case "5":
					AdministratorUI.assignTender(input);
					System.out.println("5: Assign tender to a vendor...");
					break;
				case "6":
					// Logout
					System.out.println("6: Logout successful.");
					break;
				default:
					System.out.println("Invalid choice.");
					break;
				}
			} while (!choice.equals("6"));

		} else {
			System.out.println("Invalid Username and Password.");
		}
	}

	public static void main(String[] args) {
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
