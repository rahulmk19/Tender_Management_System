package com.masai.DTO;

import java.util.Objects;

public class AdministratorImpl implements Administrator {
	private String admin_id;
	private String admin_password;
	private String admin_name;
	private String admin_email;
	private String admin_city;

	public AdministratorImpl() {
		super();
	}

	public AdministratorImpl(String admin_id, String admin_password, String admin_name, String admin_email,
			String admin_city) {
		super();
		this.admin_id = admin_id;
		this.admin_password = admin_password;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_city = admin_city;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_city() {
		return admin_city;
	}

	public void setAdmin_city(String admin_city) {
		this.admin_city = admin_city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admin_city, admin_email, admin_id, admin_name, admin_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdministratorImpl other = (AdministratorImpl) obj;
		return Objects.equals(admin_city, other.admin_city) && Objects.equals(admin_email, other.admin_email)
				&& Objects.equals(admin_id, other.admin_id) && Objects.equals(admin_name, other.admin_name)
				&& Objects.equals(admin_password, other.admin_password);
	}

}
