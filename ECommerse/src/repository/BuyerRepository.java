package repository;
import java.util.*;

import exception.EcommerceException;
import model.*;
import utils.ErrorCodeMap;

public class BuyerRepository {
	HashMap<String, Buyer> buyers;
	
	public BuyerRepository(){
		buyers = new HashMap<>();
	}
	
	public Buyer createBuyer(Buyer buyer) {
		if(buyers.get(buyer.getBuyerId()) != null) {
			throw new EcommerceException(
					ErrorCode.BUYER_CREATION_FAILED, ErrorCodeMap.erroCodeStringHashMap.get(ErrorCode.BUYER_CREATION_FAILED)
				);
		}
		
		buyers.put(buyer.getBuyerId(), buyer);
		return buyer;
	}
	
	public Buyer getBuyer(String buyerId) {
		return buyers.get(buyerId);
	}
}
