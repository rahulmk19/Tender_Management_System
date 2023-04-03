package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Administrator;
import com.masai.DTO.AdministratorImpl;
import com.masai.DTO.VendorDTO;

import exception.SomethingWentWrongException;

public class VendorImpl implements Vendor {
	public void addVendor(VendorDTO vendor) throws SomethingWentWrongException{
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    
		    try {
		        conn = DbUtils.getconnectionTodatabase();
		        String sql = "INSERT INTO vendor (vendor_name, email, phone, address, username, password, isActive) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        stmt = conn.prepareStatement(sql);
		        stmt.setString(1, vendor.getName());
		        stmt.setString(2, vendor.getEmail());
		        stmt.setString(3, vendor.getPhone());
		        stmt.setString(4, vendor.getAddress());
		        stmt.setString(5, vendor.getUsername());
		        stmt.setString(6, vendor.getPassword());
		        stmt.setInt(7, vendor.isActive());
		        stmt.executeUpdate();
		    }catch(SQLException  | ClassNotFoundException e) {
		    	throw new SomethingWentWrongException("something went wrong");
		    }finally{
		    	try {
		    		DbUtils.CloseConnection(conn);
		    	}catch(SQLException e) {
		    		
		    	}
		    }
		}


	@Override
	public List<AdministratorImpl> viewAllTender() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
