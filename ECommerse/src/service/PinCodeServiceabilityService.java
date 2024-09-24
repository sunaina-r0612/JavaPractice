package service;

import exception.EcommerceException;
import model.PaymentMode;
public interface PinCodeServiceabilityService {

    Boolean createPinCodeServiceability(String sourcePinCode,
                                       String destinationPinCode,
                                       PaymentMode paymentMode) throws EcommerceException;
    Boolean checkIsSourceAndDestPinCodeMatchesForPaymentType(
            String sourcePinCode,
            String destinationPinCode,
            PaymentMode paymentMode
    ) throws EcommerceException;

}