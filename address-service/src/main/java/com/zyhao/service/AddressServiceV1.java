package com.zyhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.zyhao.address.Address;
import com.zyhao.address.AddressRepository;

@Service
public class AddressServiceV1 {

    private AddressRepository addressRepository;
    //private OAuth2RestTemplate oAuth2RestTemplate;

    @Autowired
    public AddressServiceV1(AddressRepository addressRepository,
                          @LoadBalanced OAuth2RestTemplate oAuth2RestTemplate) {
        this.addressRepository = addressRepository;
        //this.oAuth2RestTemplate = oAuth2RestTemplate;
    }

    public Address createAddress(Address address) {
//        Account[] accounts = oAuth2RestTemplate.getForObject("http://account-service/v1/accounts", Account[].class);
//
//        Account defaultAccount = Arrays.asList(accounts).stream()
//                .filter(Account::getDefaultAccount)
//                .findFirst().orElse(null);
//
//        if (defaultAccount == null) {
//            return null;
//        }

//        Order newOrder = new Order(defaultAccount.getAccountNumber(), defaultAccount.getAddresses().stream()
//                .filter(address -> address.getAddressType() == AddressType.SHIPPING)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Default account does not have a shipping address")));
//
//        newOrder.setLineItems(lineItems.stream().collect(Collectors.toSet()));
//
//        newOrder = orderRepository.save(newOrder);
    	return addressRepository.save(address);
    }

//    public Boolean addOrderEvent(OrderEvent orderEvent, Boolean validate) throws Exception {
//        // Get the order for the event
//        Order order = orderRepository.findOne(orderEvent.getOrderId());
//
//        if (validate) {
//            // Validate the account number of the event's order belongs to the user
//            validateAccountNumber(order.getAccountNumber());
//        }
//
//        // Save the order event
//        orderEventRepository.save(orderEvent);
//
//        return true;
//    }

    public Address getAddress(String addressId, Boolean validate) {
        // Get the address for the event
    	Address address = addressRepository.findById(Long.valueOf(addressId));

        if (validate) {
//            try {
//                // Validate the account number of the event's order belongs to the user
//                validateAccountNumber(order.getAccountNumber());
//            } catch (Exception ex) {
//                return null;
//            }
        }
        return address;
//        Flux<OrderEvent> orderEvents =
//                Flux.fromStream(orderEventRepository.findOrderEventsByOrderId(order.getOrderId()));
//
//        // Aggregate the state of order
//        return orderEvents
//                .takeWhile(orderEvent -> orderEvent.getType() != OrderEventType.DELIVERED)
//                .reduceWith(() -> order, Order::incorporate)
//                .get();
    }

//    public List<Address> getAddressesForAccount(String accountNumber) throws Exception {
//        List<Address> addresses;
//        validateAccountNumber(accountNumber);
//
//        addresses = addressRepository.findByAccountNumber(accountNumber);
//        return addresses;
////        return addresses.stream()
////                .map(addresses -> getOrder(order.getOrderId(), true))
////                .filter(order -> order != null)
////                .collect(Collectors.toList());
//    }
    public void deleteAddress(String addressId) {
    	addressRepository.deleteById(Long.valueOf(addressId));
    }
    public boolean validateAccountNumber(String accountNumber) throws Exception {
//        Account[] accounts = oAuth2RestTemplate.getForObject("http://account-service/v1/accounts", Account[].class);
//
//        // Ensure account number is owned by the authenticated user
//        if (accounts != null &&
//                !Arrays.asList(accounts).stream().anyMatch(acct ->
//                        Objects.equals(acct.getAccountNumber(), accountNumber))) {
//            throw new Exception("Account number invalid");
//        }

        return true;
    }
}
