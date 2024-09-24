package repository;
import java.util.*;
import model.*;
import exception.*;
import repository.*;


public class PinCodeServiceabilityRepository {
	HashMap<String, HashMap<String, PaymentMode>> pincodes;
	
	public PinCodeServiceabilityRepository() {
		pincodes = new HashMap<>();
	}
	
	public Boolean createPinCodeServicceability(String source, PinCodeServiceability pinCodeServiceability) {
		if(pincodes.get(source) == null) {
			HashMap<String, PaymentMode> dest = new HashMap<>();
			dest.put(pinCodeServiceability.getDestinationPincode(), pinCodeServiceability.getPaymentMode());
			pincodes.put(source, dest);
		}
		
		pincodes.get(source).put(pinCodeServiceability.getDestinationPincode(), pinCodeServiceability.getPaymentMode());
		return true;
	}
	
	public HashMap<String, PaymentMode> getAllDest(String sourcePinCode){
		return pincodes.get(sourcePinCode);
	}
}
