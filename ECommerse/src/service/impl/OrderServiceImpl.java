package service.impl;

import exception.EcommerceException;

import model.ErrorCode;
import model.Order;
import repository.OrderRepository;

import service.BuyerService;
import service.OrderService;
import service.PinCodeServiceabilityService;
import service.ProductService;
import utils.ErrorCodeMap;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ProductService productService;
    PinCodeServiceabilityService pincodeServiceabilityService;
    BuyerService buyerService;

    public OrderServiceImpl(
            OrderRepository orderRepository,ProductService productService,
            PinCodeServiceabilityService pincodeServiceabilityService,
            BuyerService buyerService){
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.pincodeServiceabilityService = pincodeServiceabilityService;
        this.buyerService = buyerService;
    }

    @Override
    public String addOrder(Order order) throws EcommerceException {
        // Check Pincode
        final String sourcePinCode = productService.getProduct(order.getProductId()).getProductAddress().getPincode();
        final String destinationPinCode = buyerService.getBuyer(order.getBuyerId()).getBuyerAddress().getPincode();

        if(!pincodeServiceabilityService.checkIsSourceAndDestPinCodeMatchesForPaymentType(
                sourcePinCode,
                destinationPinCode, order.getPaymentMode()
                )){
            throw new EcommerceException(
                    ErrorCode.PIN_CODE_UNSERVICEABLE, ErrorCodeMap.erroCodeStringHashMap.get(ErrorCode.PIN_CODE_UNSERVICEABLE)
            );
        }
        // Check Inventory
        if(productService.checkInventory(order.getQuantity(),order.getProductId())){
            Order createdOrder =  orderRepository.createOrder(order);
            return createdOrder.getOrderId();
        }
        throw new EcommerceException(
                ErrorCode.ORDER_CREATION_FAILED, ErrorCodeMap.erroCodeStringHashMap.get(ErrorCode.PRODUCT_ALREADY_CREATED)
        );
    }

    @Override
    public Order getOrder(String orderId) throws EcommerceException {
        return orderRepository.getOrder(orderId);
    }
}