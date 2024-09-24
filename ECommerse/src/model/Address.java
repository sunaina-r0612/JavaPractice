package model;

import java.util.*;

public class Address {
	private final String address;
	private final String city;
	private final String pincode;
	
	public Address(String address, String city, String pincode) {
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPincode() {
		return pincode;
	}
}
