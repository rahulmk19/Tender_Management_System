package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Bidder;
import com.masai.DTO.BidderImpl;
import com.masai.DTO.Tender;
import com.masai.DTO.TenderImpl;
import com.masai.DTO.Vendor;
import com.masai.DTO.VendorImpl;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public class AdministratorDAOimpl implements AdministratorDAO {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_MAGENTA = "\u001B[35m";

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
				System.out.println(ANSI_BOLD + ANSI_RED + "Vendor Register Succesfully" + ANSI_RESET);
			} else
				throw new TenderException(ANSI_BOLD + ANSI_RED + "Vendor already exits with this id "
						+ vendor.getVender_id() + ANSI_RESET);

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
			String SELECT_QUERY = "SELECT * FROM VENDOR ORDER BY vender_email";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			if (set == null)
				throw new VendorException(ANSI_RED + "No Vendor Found !" + ANSI_RESET);
			else {
				System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n** All Vendor Details **" + ANSI_RESET);
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

	public void createTender(Tender tender) throws TenderException, ClassNotFoundException {
		try (Connection conn = DbUtils.getconnectionTodatabase()) {
			String INSERT_QUERY = "INSERT INTO TENDER (tender_id, tender_name, type, tender_price, tender_location) VALUES(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);

			statement.setString(1, tender.getTender_id());
			statement.setString(2, tender.getTender_name());
			statement.setString(3, tender.getType());
			statement.setLong(4, tender.getTender_price());
			statement.setString(5, tender.getTender_location());

			int num = statement.executeUpdate();
			if (num > 0) {
				System.out.println(ANSI_BOLD + ANSI_RED + "\nTender Added Successfully\n" + ANSI_RESET);
			} else {
				throw new TenderException(ANSI_BOLD + ANSI_RED + "Tender already exists with this id "
						+ tender.getTender_id() + ANSI_RESET);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TenderException(
					ANSI_BOLD + ANSI_RED + "An error occurred while creating the tender." + ANSI_RESET);
		}
	}

	@Override
	public List<Tender> viewAllTenders() throws TenderException {
		List<Tender> tenderList = new ArrayList<>();
		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM Tender ORDER BY tender_id";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			ResultSet rs = statement.executeQuery();

			if (rs == null)
				throw new TenderException(ANSI_RED + "No Tender Found" + ANSI_RESET);

			else {
				System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n** All Tender Details **" + ANSI_RESET);
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
						throw new TenderException(ANSI_RED + "No Tender Found !" + ANSI_RESET);
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
		return tenderList;
	}

	@Override
	public List<Bidder> viewAllBidsOfTenders(String tender_id) throws BidderException {
		List<Bidder> bidderList = new ArrayList<>();
		try {

			conn = DbUtils.getconnectionTodatabase();

			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE tender_id= ? ORDER BY bid_price desc";
			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			statement.setString(1, tender_id);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				int id = set.getInt(1);
				String tenderID = tender_id;
				String vendorId = set.getString(3);
				Long price = set.getLong(4);
				String status = set.getString(5);

				Bidder bider = new BidderImpl(id, tenderID, vendorId, price, status);
				bidderList.add(bider);
			}
			if (!bidderList.isEmpty())
				return bidderList;
			if (bidderList.isEmpty())
				throw new BidderException(ANSI_RED + "No Bidder Found !" + ANSI_RESET);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n** All Vendor Details **" + ANSI_RESET);
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
	public void assignTenderToVender(String vendorId, String tenderId) throws BidderException {

		Connection conn = null;

		try {
			conn = DbUtils.getconnectionTodatabase();
			conn.setAutoCommit(false); // Start a transaction

			String UPDATE_BIDDER_QUERY = "UPDATE bidder SET bid_status = 'Close' WHERE vender_id = ? AND tender_id = ? AND bid_status = 'Open'";
			PreparedStatement bidderStatement = conn.prepareStatement(UPDATE_BIDDER_QUERY);
			bidderStatement.setString(1, vendorId);
			bidderStatement.setString(2, tenderId);

			int num = bidderStatement.executeUpdate();
			if (num > 0) {
				System.out.println(ANSI_BOLD + ANSI_RED + tenderId + " Tender Assigned Successfully to Vendor "
						+ vendorId + ANSI_RESET);

				String UPDATE_TENDER_QUERY = "UPDATE Tender SET status = 'Close' WHERE tender_id = ?";
				PreparedStatement tenderStatement = conn.prepareStatement(UPDATE_TENDER_QUERY);
				tenderStatement.setString(1, tenderId);

				int tenderUpdateNum = tenderStatement.executeUpdate();
				if (tenderUpdateNum > 0) {
					System.out.println("Tender " + tenderId + " status updated to 'Close' successfully.");
					conn.commit();
				} else {
					System.out
							.println(ANSI_RED + "Something went wrong while updating the Tender status." + ANSI_RESET);
					conn.rollback();
				}
			} else {
				System.out.println(ANSI_RED + "Something went wrong. Not able to assign the Tender." + ANSI_RESET);
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.setAutoCommit(true);
					DbUtils.CloseConnection(conn);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<Bidder> viewAllAssingedTender() throws TenderException {
		List<Bidder> bidderList = new ArrayList<>();
		try {

			conn = DbUtils.getconnectionTodatabase();

			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE bid_status= ? ORDER BY tender_id";
			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);

			String bid_status = "Close";
			statement.setString(1, bid_status);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				int id = set.getInt(1);
				String tenderID = set.getString(2);
				String vendorId = set.getString(3);
				Long price = set.getLong(4);
				String status = set.getString(5);

				Bidder bider = new BidderImpl(id, tenderID, vendorId, price, status);
				bidderList.add(bider);
			}
			if (!bidderList.isEmpty())
				return bidderList;
			if (bidderList.isEmpty())
				System.out.println(ANSI_BOLD + ANSI_RED + "No Tender Assigned To Any One !" + ANSI_RESET);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n** All Assigned Tender **" + ANSI_RESET);
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (final Exception e2) {
				e2.printStackTrace();
			}
		}
		return bidderList;
	}
}
