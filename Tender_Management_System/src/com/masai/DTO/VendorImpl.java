package com.masai.DTO;

import java.util.Objects;

public class VendorImpl implements Vendor {

	private String vender_id;
	private String vender_password;
	private String vender_name;
	private String vender_email;
	private String vender_mobileNumber;
	private String vender_location;

	public VendorImpl() {
		super();
	}

	public VendorImpl(String vender_id, String vender_password, String vender_name, String vender_email,
			String vender_mobileNumber, String vender_location) {
		super();
		this.vender_id = vender_id;
		this.vender_password = vender_password;
		this.vender_name = vender_name;
		this.vender_email = vender_email;
		this.vender_mobileNumber = vender_mobileNumber;
		this.vender_location = vender_location;
	}

	public String getVender_id() {
		return vender_id;
	}

	public void setVender_id(String vender_id) {
		this.vender_id = vender_id;
	}

	public String getVender_password() {
		return vender_password;
	}

	public void setVender_password(String vender_password) {
		this.vender_password = vender_password;
	}

	public String getVender_name() {
		return vender_name;
	}

	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
	}

	public String getVender_email() {
		return vender_email;
	}

	public void setVender_email(String vender_email) {
		this.vender_email = vender_email;
	}

	public String getVender_mobileNumber() {
		return vender_mobileNumber;
	}

	public void setVender_mobileNumber(String vender_mobileNumber) {
		this.vender_mobileNumber = vender_mobileNumber;
	}

	public String getVender_location() {
		return vender_location;
	}

	public void setVender_location(String vender_location) {
		this.vender_location = vender_location;
	}

	@Override
	public String toString() {
		return "[vender_id=" + vender_id + ", vender_password=" + vender_password + ", vender_name=" + vender_name
				+ ", vender_email=" + vender_email + ", vender_mobileNumber=" + vender_mobileNumber
				+ ", vender_location=" + vender_location + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(vender_email, vender_id, vender_location, vender_mobileNumber, vender_name,
				vender_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorImpl other = (VendorImpl) obj;
		return Objects.equals(vender_email, other.vender_email) && Objects.equals(vender_id, other.vender_id)
				&& Objects.equals(vender_location, other.vender_location)
				&& Objects.equals(vender_mobileNumber, other.vender_mobileNumber)
				&& Objects.equals(vender_name, other.vender_name)
				&& Objects.equals(vender_password, other.vender_password);
	}

}
