package service.impl;

import exception.EcommerceException;
import model.PaymentMode;
import model.PinCodeServiceability;
import repository.PinCodeServiceabilityRepository;
import service.PinCodeServiceabilityService;

import java.util.HashMap;


public class PincodeServiceabilityImpl  implements PinCodeServiceabilityService {

    PinCodeServiceabilityRepository pincodeServiceabilityRepository;

    public PincodeServiceabilityImpl(PinCodeServiceabilityRepository pincodeServiceabilityRepository){
        this.pincodeServiceabilityRepository = pincodeServiceabilityRepository;
    }


    @Override
    public Boolean createPinCodeServiceability(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode) throws EcommerceException {
        PinCodeServiceability pinCodeServiceability = new PinCodeServiceability(destinationPinCode,paymentMode);
        return pincodeServiceabilityRepository.createPinCodeServicceability(sourcePinCode,pinCodeServiceability);

    }

    @Override
    public Boolean checkIsSourceAndDestPinCodeMatchesForPaymentType(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode) throws EcommerceException {
        HashMap<String, PaymentMode> allDestinationPincodes = pincodeServiceabilityRepository.getAllDest(sourcePinCode);
        return allDestinationPincodes.containsKey(destinationPinCode) &&
                paymentMode.equals(allDestinationPincodes.get(destinationPinCode));
    }
}