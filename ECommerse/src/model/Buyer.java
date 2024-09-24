package model;

import java.util.*;

public class Buyer {
	private final String buyerId;
	private final String buyerName;
	private final Address address;
	
	public Buyer(String buyerId, String buyerName, Address address) {
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.address = address;
	}
	
	public String getBuyerId() {
		return buyerId;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public Address getBuyerAddress() {
		return address;
	}
}
