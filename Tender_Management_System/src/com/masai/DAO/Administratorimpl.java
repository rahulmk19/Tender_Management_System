package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.VendorDTO;
import com.masai.DTO.VendorDTOImpl;

import exception.NoRecordFoundException;
import exception.SomethingWentWrongException;

public class Administratorimpl implements AdministratorDAO{
	@Override
	public List<VendorDTO> viewVendor() throws SomethingWentWrongException,NoRecordFoundException{
		Connection conn=null;
		List<VendorDTO> list=new ArrayList<>();
		try {
			conn=DbUtils.getconnectionTodatabase();
			
			String query="SELECT vendor_id,vendor_name,phone,address,isActive from vendor";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			if(DbUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Vendor Found");
			}
			while(rs.next()) {
				list.add(new VendorDTOImpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)));
			}
			
		}
		catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("No found mobile");
		}
		finally {
			try {
				DbUtils.CloseConnection(conn);
			}
			catch(SQLException ex) {
				
			}
		}
		return list;
	}
}
