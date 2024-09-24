package model;
import java.util.*;

public class Order {
	private final String orderId;
	private final String productId;
	private final String buyerId;
	private final int quantity;
	private final PaymentMode paymentMode;
	
	public Order(String orderId, String productId, String buyerId, int quantity, PaymentMode paymentMode) {
		this.orderId = orderId;
		this.productId = productId;
		this.buyerId = buyerId;
		this.quantity = quantity;
		this.paymentMode = paymentMode;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public String getBuyerId() {
		return buyerId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
}
