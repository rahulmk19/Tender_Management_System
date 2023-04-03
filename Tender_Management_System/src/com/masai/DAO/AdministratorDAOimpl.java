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
import com.masai.DTO.VendorDTOImpl;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public class AdministratorDAOimpl implements AdministratorDAO {
	@Override
	public List<VendorDTO> viewVendor() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<VendorDTO> list = new ArrayList<>();
		try {
			conn = DbUtils.getconnectionTodatabase();

			String query = "SELECT * from vendor";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (DbUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Vendor Found");
			}
			while (rs.next()) {
				VendorDTO vendor = new VendorDTOImpl(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
				vendor.setId(rs.getInt(1));
				list.add(vendor);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("No found Data");
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (SQLException ex) {

			}
		}

		return list;
	}

	public void addTender(String tenderName, String description, String startDate, String endDate)
			throws SomethingWentWrongException {
		Connection conn = null;

		try {
			conn = DbUtils.getconnectionTodatabase();

			String query = "INSERT INTO tender (tender_name, description, start_date, end_date, status) VALUES (?, ?, ?, ?, 'open')";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, tenderName);
			ps.setString(2, description);
			ps.setString(3, startDate);
			ps.setString(4, endDate);

			ps.executeUpdate();
			System.out.println("Tender added successfully.");
		}

		catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("No found Data");
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}
	
	public List<Administrator> viewAllTenders() throws SomethingWentWrongException {
	    List<Administrator> tenderList = new ArrayList<>();
	    Connection conn = null;
	    
	    try {
	        conn = DbUtils.getconnectionTodatabase();
	        String SELECT_QUERY = "SELECT * FROM tender";
	        PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);
	        ResultSet rs = statement.executeQuery();
	        
	        while (rs.next()) {
	            int tender_id = rs.getInt("tender_id");
	            String tender_name = rs.getString("tender_name");
	            String description = rs.getString("description");
	            LocalDate start_date = rs.getDate("start_date").toLocalDate();
	            LocalDate end_date = rs.getDate("end_date").toLocalDate();
	            String status = rs.getString("status");
	            Administrator tender = new AdministratorImpl(tender_name, description, start_date, end_date, status);
	            tender.setTender_id(rs.getInt(1));
	            tenderList.add(tender);
	      
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	    
	    return tenderList;
	}

	


}
