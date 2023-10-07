package com.masai.DTO;

import java.util.Objects;

public class BidderImpl implements Bidder {

	private int bidder_id;
	private String tender_id;
	private String vender_id;
	private long bid_price;
	private String bid_status;

	public BidderImpl() {
		super();
	}

	public BidderImpl(String tender_id, String vender_id, long bid_price, String bid_status) {
		super();
		this.tender_id = tender_id;
		this.vender_id = vender_id;
		this.bid_price = bid_price;
		this.bid_status = bid_status;
	}

	public BidderImpl(int bidder_id, String tender_id, String vender_id, long bid_price, String bid_status) {
		super();
		this.bidder_id = bidder_id;
		this.tender_id = tender_id;
		this.vender_id = vender_id;
		this.bid_price = bid_price;
		this.bid_status = bid_status;
	}

	public int getBidder_id() {
		return bidder_id;
	}

	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}

	public String getTender_id() {
		return tender_id;
	}

	public void setTender_id(String tender_id) {
		this.tender_id = tender_id;
	}

	public String getVender_id() {
		return vender_id;
	}

	public void setVender_id(String vender_id) {
		this.vender_id = vender_id;
	}

	public long getBid_price() {
		return bid_price;
	}

	public void setBid_price(long bid_price) {
		this.bid_price = bid_price;
	}

	public String getBid_status() {
		return bid_status;
	}

	public void setBid_status(String bid_status) {
		this.bid_status = bid_status;
	}

	@Override
	public String toString() {
		return "[Bidder_Id=" + bidder_id + ", Tender_Id=" + tender_id + ", Vender_Id=" + vender_id + ", Price=" + bid_price + ", Status="
				+ bid_status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid_price, bid_status, bidder_id, tender_id, vender_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidderImpl other = (BidderImpl) obj;
		return bid_price == other.bid_price && Objects.equals(bid_status, other.bid_status)
				&& Objects.equals(bidder_id, other.bidder_id) && Objects.equals(tender_id, other.tender_id)
				&& Objects.equals(vender_id, other.vender_id);
	}

}
