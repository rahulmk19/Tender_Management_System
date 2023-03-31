package com.masai.UI;

import java.util.Scanner;

import exception.NoRecordFoundException;

public class VendorUI {
	public static void venderLogin(Scanner scanner) {
			
			if(isVendorLogged.isLogged) {
				try {
					showUserMenu(scanner);
				} catch (NoRecordFoundException e) {
					System.out.println(e.getMessage());
				}
			}else {
				int choice;
	
		        do {
		            System.out.println("Main Menu");
	            System.out.println("1. Sign Up");
	            System.out.println("2. Login");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	
	            switch (choice) {
	                case 1:
	                    signUp(scanner);
	                    break;
	                case 2:
	                    login(scanner);
	                    break;
	                case 3:
	                    System.out.println("Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 3);
		}
	}
	
	
	
}
