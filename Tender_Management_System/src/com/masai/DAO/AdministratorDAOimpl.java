package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Bidder;
import com.masai.DTO.BidderImpl;
import com.masai.DTO.Tender;
import com.masai.DTO.TenderImpl;
import com.masai.DTO.Vendor;
import com.masai.DTO.VendorImpl;
import com.masai.exception.BidderException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public class AdministratorDAOimpl implements AdministratorDAO {

	static Connection conn = null;

	@Override
	public void addVendor(Vendor vendor) throws VendorException {
		try {
			conn = DbUtils.getconnectionTodatabase();

			String addQuery = "INSERT INTO VENDOR VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(addQuery);
			ps.setString(1, vendor.getVender_id());
			ps.setString(2, vendor.getVender_password());
			ps.setString(3, vendor.getVender_name());
			ps.setString(4, vendor.getVender_email());
			ps.setString(5, vendor.getVender_mobileNumber());
			ps.setString(6, vendor.getVender_location());

			int n = ps.executeUpdate();

			if (n > 0) {
				System.out.println("Vendor Register Succesfully");
			} else
				throw new TenderException("Tender already exits with this id " + vendor.getVender_id());

		} catch (Exception e) {

			System.out.println("Vendor already exits with this id" + vendor.getVender_id());
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				System.out.println("Something went wrong");
			}
		}
	}

	@Override
	public List<Vendor> viewAllVendors() throws VendorException {
		List<Vendor> vendorList = new ArrayList<>();
		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM VENDOR";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			if (set == null)
				throw new VendorException("NO RECORD FOUND");
			else {
				while (set.next()) {
					String id = set.getString(1);
					String password = set.getString(2);
					String name = set.getString(3);
					String email = set.getString(4);
					String phone = set.getString(5);
					String location = set.getString(6);

					Vendor vendor = new VendorImpl(id, password, name, email, phone, location);
					vendorList.add(vendor);
					System.out.println(vendor);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vendorList;
	}

	@Override
	public void createTender(Tender tender) throws TenderException {

		try {
			conn = DbUtils.getconnectionTodatabase();
			String INSERT_QUERY = "INSERT INTO TENDER VALUES(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);

			statement.setString(1, tender.getTender_id());
			statement.setString(2, tender.getTender_name());
			statement.setString(3, tender.getType());
			statement.setInt(4, tender.getTender_price());
			statement.setString(5, tender.getTender_location());

			int num = statement.executeUpdate();
			if (num > 0)
				System.out.println("\nTender Added Successfully In Database\n");
			else {
				throw new TenderException("Tender already exits with this id " + tender.getTender_id());
			}
		} catch (Exception e) {
			System.out.println("Tender already exits with this id " + tender.getTender_id());

		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				System.out.println("Something went wrong");
			}
		}
	}

	@Override
	public List<Tender> viewAllTenders() throws TenderException {
		List<Tender> tenderList = new ArrayList<>();
		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM Tender";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			ResultSet rs = statement.executeQuery();

			if (rs == null)
				throw new TenderException("No Rocord Found");

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String location = rs.getString(5);
				String status = rs.getString(6);

				Tender tender = new TenderImpl(id, name, type, price, location, status);
				tenderList.add(tender);

				if (tenderList.size() == 0)
					throw new TenderException("No Record found with tenderList");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return tenderList;
	}

	@Override
	public List<Bidder> viewAllBidsOfTenders(String tender_id) throws BidderException {
		List<Bidder> bidderList = new ArrayList<>();
		try {

			conn = DbUtils.getconnectionTodatabase();

			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE tender_id= ?";
			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			statement.setString(1, tender_id);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				String id = set.getString(1);
				String vendorId = set.getString(2);
				String tenderID = set.getString(3);
				int price = set.getInt(4);
				String status = set.getString(5);

				Bidder bider = new BidderImpl(id, tenderID, vendorId, price, status);
				bidderList.add(bider);
			}
			if (!bidderList.isEmpty())
				return bidderList;
			if (bidderList.isEmpty())
				throw new BidderException("NO BIDDER FOUND!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (final Exception e2) {
				e2.printStackTrace();
			}
		}
		return bidderList;
	}

	@Override
	public void assignTenderToVender(String venderId, String tenderId) throws BidderException {
		try {
			conn = DbUtils.getconnectionTodatabase();

			String UPDATE_QUERY = "UPDATE bidder SET bid_status = 'Close' where vender_id = ? AND tender_id = ?";
			PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);

			statement.setString(1, venderId);
			statement.setString(2, tenderId);

			int n = statement.executeUpdate();
			if (n > 0) {
				System.out.println("Tender Assigned Successfully");
			} else {
				throw new BidderException("Failed to assign tender");
			}
		} catch (Exception e) {
			throw new BidderException("An error occurred while assigning tender");
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
