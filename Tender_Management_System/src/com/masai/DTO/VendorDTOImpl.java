package com.masai.DTO;

public class VendorDTOImpl implements VendorDTO{
	
		private String name;
		private String email;
		private String phone;
		private String address;
	 	private String username;
	    private String password;
	    private boolean isActive;
	    
		public VendorDTOImpl(String name, String email, String phone, String address, String username, String password,
				boolean isActive) {
			super();
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.username = username;
			this.password = password;
			this.isActive = isActive;
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
	    

	    

}
