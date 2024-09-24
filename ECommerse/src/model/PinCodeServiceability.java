package model;
import java.util.*;

public class PinCodeServiceability {
	private final String destinationPincode;
	private final PaymentMode paymentMode;
	
	public PinCodeServiceability(String destinationPincode, PaymentMode paymentMode) {
		this.destinationPincode = destinationPincode;
		this.paymentMode = paymentMode;
	}
	
	public String getDestinationPincode() {
		return destinationPincode;
	}
	
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
}
