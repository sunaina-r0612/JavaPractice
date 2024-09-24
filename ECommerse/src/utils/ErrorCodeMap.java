package utils;
import java.util.*;
import model.*;

public class ErrorCodeMap {
	public static HashMap<ErrorCode, String> erroCodeStringHashMap = new HashMap<>();
	static {
		erroCodeStringHashMap.put(ErrorCode.BUYER_CREATION_FAILED, "Buyer Already Created");
		erroCodeStringHashMap.put(ErrorCode.ORDER_CREATION_FAILED, "Order Already Created");
		erroCodeStringHashMap.put(ErrorCode.PRODUCT_CREATION_FAILED, "Product Creation Failed");
		erroCodeStringHashMap.put(ErrorCode.IN_SUFFICCIENT_INVENTORY, "Order failed because product stock is in-serviceable");
		erroCodeStringHashMap.put(ErrorCode.PIN_CODE_UNSERVICEABLE, "Order failed because pin-code is unserviceable");
		erroCodeStringHashMap.put(ErrorCode.PRODUCT_ALREADY_CREATED, "Product Duplication");
	}
}
