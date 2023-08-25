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
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public class VendorDaoImpl implements VendorDao {

	static Connection conn = null;

	@Override
	public Vendor AuthenticateVendor(String username) throws VendorException {
		Vendor vendor = null;

		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM Vendor WHERE vender_email=?";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);
			statement.setString(1, username);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				String vender_id = rs.getString("vender_id");
				String vender_password = rs.getString("vender_password");
				String vender_name = rs.getString("vender_name");
				String vender_email = rs.getString("vender_email");
				String vender_mobileNumber = rs.getString("vender_mobileNumber");
				String vender_location = rs.getString("vender_location");

				vendor = new VendorImpl(vender_id, vender_password, vender_name, vender_email, vender_mobileNumber,
						vender_location);
			} else {
				throw new VendorException("No Record Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new VendorException("An error occurred during vendor authentication");
		} finally {
			try {
				DbUtils.CloseConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vendor;
	}

	@Override
	public List<Tender> viewAllTender() throws TenderException {
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
	public void placeBidAgainstTender(BidderImpl input) throws TenderException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tender> currentOpenStatusTender(String openstatus) throws TenderException {
		List<Tender> tenderList = new ArrayList<>();

		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM Tender WHERE status=?";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);
			statement.setString(1, openstatus);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String location = rs.getString(5);
				String status = rs.getString(6);

				Tender tender = new TenderImpl(id, name, type, price, location, status);
				tenderList.add(tender);
			}

			if (tenderList.isEmpty()) {
				throw new TenderException("No Open Tenders Found");
			}
		} catch (Exception e) {
			throw new TenderException("An error occurred while retrieving open tenders");
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
	public List<Bidder> viewOwnBidHistory(String vendorId) throws BidderException {
		List<Bidder> list = new ArrayList<>();

		try {
			conn = DbUtils.getconnectionTodatabase();
			String SELECT_QUERY = "SELECT * FROM bidder WHERE vender_id = ?";

			PreparedStatement statement = conn.prepareStatement(SELECT_QUERY);
			statement.setString(1, vendorId);

			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String bid_id = set.getString(1);
				String ten_id = set.getString(2);
				String ven_id = set.getString(3);
				int price = set.getInt(4);
				String status = set.getString(5);

				Bidder b = new BidderImpl(bid_id, ten_id, ven_id, price, status);
				list.add(b);
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
		return list;
	}

	@Override
	public void changeDetailsVendor(Vendor vendor) {
		PreparedStatement statement = null;

		try {
			String query = "UPDATE vendor SET vender_password=?, vendor_name=?, vender_mobileNumber=?, vender_location=? WHERE vender_id=?";

			statement = conn.prepareStatement(query);
			statement.setString(1, vendor.getVender_password());
			statement.setString(2, vendor.getVender_name());
			statement.setString(3, vendor.getVender_mobileNumber());
			statement.setString(4, vendor.getVender_location());
			statement.setString(5, vendor.getVender_id());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Vendor details updated successfully.");
			} else {
				System.out.println("No vendor details were updated.");
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
	}
}
