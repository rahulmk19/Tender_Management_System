package com.masai.UI;

import java.util.Scanner;

public class Main {
	
	static void Vendor(Scanner sc) {
		System.out.println("Welcome Vendor");
		
	}

	static void Administrator(Scanner input) {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-***-");
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
	                System.out.println("MENU");
	                System.out.println("1. View all vendors");
	                System.out.println("2. Create new tender");
	                System.out.println("3. View all tenders");
	                System.out.println("4. View all bids of a tender");
	                System.out.println("5. Assign tender to a vendor");
	                System.out.println("6. Logout");
	                System.out.println("0. Main Menu");

	                System.out.print("\nEnter your choice: ");
	                choice = input.next();

	                switch (choice) {
	                    case "1":
	                        // View all vendors
	                        System.out.println("View all vendors...");
	                        break;
	                    case "2":
	                        // Create new tender
	                        System.out.println("Create new tender...");
	                        break;
	                    case "3":
	                        // View all tenders
	                        System.out.println("View all tenders...");
	                        break;
	                    case "4":
	                        // View all bids of a tender
	                        System.out.println("View all bids of a tender...");
	                        break;
	                    case "5":
	                        // Assign tender to a vendor
	                        System.out.println("Assign tender to a vendor...");
	                        break;
	                    case "6":
	                        // Logout
	                        System.out.println("Logout successful.");
	                        break;
	                    default:
	                        System.out.println("Invalid choice.");
	                        break;
	                }
	            } while (!choice.equals("6"));

	        } else {
	            System.out.println("Invalid username or password.");
	        }
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("1. Administrator");
			System.out.println("2. Vendor");
			
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					Administrator(sc);
					break;
					
				case 2:
					Vendor(sc);
					break;
					
				default:
					System.out.println("Please Select Correct Option");
			}
		}
		while(choice!=0);
		sc.close();
	}



}
