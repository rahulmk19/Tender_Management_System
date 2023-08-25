package com.masai.DTO;

import java.util.Objects;

public class TenderImpl implements Tender {

	private String tender_id;
	private String tender_name;
	private String type;
	private int tender_price;
	private String tender_location;
	private String status;

	public TenderImpl() {
		super();
	}

	public TenderImpl(String tender_id, String tender_name, String type, int tender_price, String tender_location) {
		super();
		this.tender_id = tender_id;
		this.tender_name = tender_name;
		this.type = type;
		this.tender_price = tender_price;
		this.tender_location = tender_location;
	}

	public TenderImpl(String tender_id, String tender_name, String type, int tender_price, String tender_location,
			String status) {
		super();
		this.tender_id = tender_id;
		this.tender_name = tender_name;
		this.type = type;
		this.tender_price = tender_price;
		this.tender_location = tender_location;
		this.status = status;
	}

	public String getTender_id() {
		return tender_id;
	}

	public void setTender_id(String tender_id) {
		this.tender_id = tender_id;
	}

	public String getTender_name() {
		return tender_name;
	}

	public void setTender_name(String tender_name) {
		this.tender_name = tender_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTender_price() {
		return tender_price;
	}

	public void setTender_price(int tender_price) {
		this.tender_price = tender_price;
	}

	public String getTender_location() {
		return tender_location;
	}

	public void setTender_location(String tender_location) {
		this.tender_location = tender_location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[tender_id=" + tender_id + ", tender_name=" + tender_name + ", type=" + type + ", tender_price="
				+ tender_price + ", tender_location=" + tender_location + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, tender_id, tender_location, tender_name, tender_price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenderImpl other = (TenderImpl) obj;
		return Objects.equals(status, other.status) && Objects.equals(tender_id, other.tender_id)
				&& Objects.equals(tender_location, other.tender_location)
				&& Objects.equals(tender_name, other.tender_name) && tender_price == other.tender_price
				&& Objects.equals(type, other.type);
	}

}
