package main;
import exception.EcommerceException;
import model.*;
import repository.*;
import service.impl.*;
import service.*;

public class Main {

    public static void main(String[] args) {
        BuyerRepository buyerRepository = new BuyerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();
        PinCodeServiceabilityRepository pincodeServiceabilityRepository = new PinCodeServiceabilityRepository();

        BuyerService buyerService = new BuyerServiceImpl(buyerRepository);
        ProductService productService = new ProductServiceImpl(productRepository);
        PinCodeServiceabilityService pincodeServiceabilityService = new PincodeServiceabilityImpl(pincodeServiceabilityRepository);
        OrderServiceImpl orderService = new OrderServiceImpl(
                orderRepository, productService, pincodeServiceabilityService, buyerService);

        Address address1 =  new Address("Tag","Vizag","531162");
        Address address2 =  new Address("Somaji","Hyderabad","500082");
        Address address3 =  new Address("Hubili","Bangalore","536264");


        Product product1 = new Product("p1","T-shirt Levis", 10, address1);
        Product product2 = new Product("p2","Casual Shoes", 10, address2);
        Product product3 = new Product("p3","Modern Classic Pants", 10, address3);
        Product product4 = new Product("p4","Kudtha", 10, address1);

        String product1Id = productService.addProduct(product1);
        String product2Id = productService.addProduct(product2);
        String product3Id = productService.addProduct(product3);
        String product4Id = productService.addProduct(product4);


        Buyer buyer1 = new Buyer("b1","LavKumar",address1);
        Buyer buyer2 = new Buyer("b2","Pranva",address2);
        Buyer buyer3 = new Buyer("b3","Khavya",address3);

        String buyer1Id = buyerService.addBuyer(buyer1);
        String buyer2Id = buyerService.addBuyer(buyer2);
        String buyer3Id = buyerService.addBuyer(buyer3);


        pincodeServiceabilityService.createPinCodeServiceability(
                "531162","500082", PaymentMode.PREPAID
        );
        pincodeServiceabilityService.createPinCodeServiceability(
                "531162","531162", PaymentMode.PREPAID
        );
        pincodeServiceabilityService.createPinCodeServiceability(
                "500082","536264", PaymentMode.PREPAID
        );
        pincodeServiceabilityService.createPinCodeServiceability(
                "536264","531162", PaymentMode.PREPAID
        );

        Order order1 = new Order("O1",product1Id, buyer1Id, 5, PaymentMode.PREPAID);
        Order order3 = new Order("O2",product1Id, buyer1Id, 6, PaymentMode.PREPAID);
        Order order2 = new Order("O3",product1Id, buyer3Id, 5, PaymentMode.PREPAID);

        try {
            String order1Id = orderService.addOrder(order1);
            System.out.println("Order1 Placed Sucessfull "+ order1Id);

            String order3Id = orderService.addOrder(order3);
            System.out.println("Order3 Placed Sucessfull "+ order3Id);

        }catch (EcommerceException e){
            System.out.println(e.getErrorCode()+"  "+e.getErrorMessage());
        }

        try{
            String order2Id = orderService.addOrder(order2);
            System.out.println("Order2 Placed Sucessfull "+ order2Id);
        }catch (EcommerceException e){
            System.out.println(e.getErrorCode()+"  "+e.getErrorMessage());
        }
    }
}