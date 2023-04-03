package com.masai.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.AdministratorDAO;
import com.masai.DAO.AdministratorDAOimpl;
import com.masai.DAO.Vendor;
import com.masai.DAO.VendorImpl;
import com.masai.DTO.Administrator;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserImpl;
import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorDTOImpl;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public class VendorUI {

	public static void signUp(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter vendor name");
		String vendorName = scanner.next();
		System.out.println("Enter email:");
		String email = scanner.next();
		System.out.println("Enter phone:");
		String phone = scanner.next();
		System.out.println("Enter address:");
		String address = scanner.next();
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		System.out.println("Enter venodr status 1/0");
		int isActive = scanner.nextInt();

		VendorDTO user = new VendorDTOImpl(vendorName, email, phone, address, username, password, isActive);
		Vendor dao = new VendorImpl();
		try {
			dao.addVendor(user);
			System.out.println("Vendor Added Succesfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void login(Scanner scanner) {

		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter password");
		String pass = scanner.next();

		int choice;
		do {
			System.out.println("1. Update vendor account details and change password");
			System.out.println("2. View all the Current Tenders");
			System.out.println("3. Place Bid against a Tender");
			System.out.println("4. View Bid History");
			System.out.println("5. Search Tender by ID or Date Range");
			System.out.println("0. Logout");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				update_vendor(scanner);
				break;
			case 2:
				view_Tender(scanner);
				break;
//			case 3:
//				Bid_Tender(scanner);
//				break;
//			case 4:
//				view_Bid_history(scanner);
//				break;
//			case 5:
//				search(scanner);
//				break;
			case 6:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 6);

	}

	public static void update_vendor(Scanner scanner) {
		System.out.println("Enter vendor_name");
		String vendor_name = scanner.next();
		System.out.println("Enter email");
		String email = scanner.next();
		System.out.println("Enter phone");
		String phone = scanner.next();
		System.out.println("Enter address");
		String address = scanner.next();
		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();

		Connection conn = null;
		PreparedStatement statement = null;
		boolean success = false;

		try {
			String query = "UPDATE vendor SET vendor_name=?, contact_person_name=?, email=?, phone=?, address=?, username=?, password=? WHERE email=? AND password=?";
			statement = conn.prepareStatement(query);
			statement.setString(1, vendor_name);
			statement.setString(2, email);
			statement.setString(3, phone);
			statement.setString(4, address);
			statement.setString(5, username);
			statement.setString(6, password);
//			statement.setInt(7, vendor_Id);

			int rowsUpdated = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//		return success;
	}

	public static void view_Tender(Scanner scanner) {

		AdministratorDAO dao = new AdministratorDAOimpl();
		try {
			List<Administrator> list = dao.viewAllTenders();

			for (Administrator i : list) {
				System.out.println(i);
			}
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
