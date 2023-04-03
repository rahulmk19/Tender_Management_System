package com.masai.DTO;

public interface VendorDTO {
	public void setId(int id);
	
	public int getId();
	
	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public String getPhone();

	public void setPhone(String phone);

	public String getAddress();

	public void setAddress(String address);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public int isActive();

	public void setActive(int isActive);
}
