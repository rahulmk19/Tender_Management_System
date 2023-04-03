package com.masai.DTO;

public interface UserDTO {

	public int getVendorId();
    public void setVendorId(int vendorId);
    public String getVendorName();
    public void setVendorName(String vendorName);
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
    public boolean isActive();
    public void setActive(boolean active);
}
