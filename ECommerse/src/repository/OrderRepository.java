package repository;
import java.util.HashMap;

import exception.*;
import model.*;
import utils.*;

public class OrderRepository {
	HashMap<String, Order> orders;
	
	public OrderRepository(){
		orders = new HashMap<>();
	}
	
	public Order createOrder(Order order) {
		if(orders.get(order.getOrderId()) != null) {
			throw new EcommerceException(
					ErrorCode.ORDER_CREATION_FAILED, ErrorCodeMap.erroCodeStringHashMap.get(ErrorCode.ORDER_CREATION_FAILED)
				);
		}
		
		orders.put(order.getOrderId(), order);
		return order;
	}
	
	public Order getOrder(String orderId) {
		return orders.get(orderId);
	}
}
