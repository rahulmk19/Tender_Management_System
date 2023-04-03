package com.masai.DTO;

public class UserImpl implements UserDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private boolean isActive;
    
    public UserImpl(String name, String email, String phone, String address, String username, String password, boolean isActive) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

	@Override
	public int getVendorId() {
		// TODO Auto-generated method stub
		return 0;
//		return vendor;
	}

	@Override
	public void setVendorId(int vendorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getVendorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVendorName(String vendorName) {
		// TODO Auto-generated method stub
		
	}
}
