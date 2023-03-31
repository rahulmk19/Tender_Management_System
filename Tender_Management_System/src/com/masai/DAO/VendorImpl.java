package com.masai.DAO;

import exception.SomethingWentWrongException;

public class VendorImpl implements Vendor{
	
	public  void addVendor(Vendor vendor) throws SomethingWentWrongException {
//	    String query = "INSERT INTO vendor (first_name, last_name, username, password, address, mobile_number, email, wallet_balance, is_active) VALUES (?,?,?,?,?,?,?,?,?)";
//	    Connection conn = null;
//	    try{
//	    	conn = DBUtils.getConnection();
//	        PreparedStatement pstmt = conn.prepareStatement(query);
//	        pstmt.setString(1, vendor.getFirstName());
//	        pstmt.setString(2, vendor.getLastName());
//	        pstmt.setString(3, vendor.getUsername());
//	        pstmt.setString(4, vendor.getPassword());
//	        pstmt.setString(5, vendor.getAddress());
//	        pstmt.setString(6, vendor.getPhone());
//	        pstmt.setString(7, vendor.getEmail());
//	        pstmt.setDouble(8, vendor.getWalletBalance());
//	        pstmt.setInt(9, 1);
//	        pstmt.executeUpdate();
//
//	    } catch (SQLException | ClassNotFoundException e) {
//	        throw new SomethingWentWrongException("Could not able to add customer"+e.getMessage());
//	    }finally {
//	    	try {
//	    		DBUtils.closeConnection(conn);
//	    	}catch(SQLException e) {
//	    		
//	    	}
//	    }
	}
}
