package model;

import java.util.*;

public class Product {
	private final String productId;
	private final String productName;
	private int productQuantity;
	private final Address productAddress;
	
	public Product(String productId, String productName, int productQuantity, Address address) {
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productAddress = address;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
	
	public Address getProductAddress() {
		return productAddress;
	}
}
