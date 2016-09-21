package com.zyhao.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zyhao.address.Address;
import com.zyhao.service.AddressServiceV1;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1")
public class AddressControllerV1 {

    private AddressServiceV1 addressService;

    @Autowired
    public AddressControllerV1(AddressServiceV1 addressService) {
        this.addressService = addressService;
    }
 
  @RequestMapping(path = "/address/{addressId}")
  public Address getAddress(@PathVariable("addressId") String addressId) throws Exception {
	  return addressService.getAddress(addressId,false);
//      return Optional.ofNullable(addressService.getAddress(addressId,false))
//              .map(a -> new ResponseEntity<List<com.zyhao.address.Address>>(a, HttpStatus.OK))
//              .orElseThrow(() -> new Exception("addressId for address do not exist"));
  }
@RequestMapping(path = "/address/create", method = RequestMethod.GET)//RequestBody
public ResponseEntity createAddress(Address address) throws Exception {
	System.out.println(address);
	return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.OK);
}
@RequestMapping(path = "/address/delete/{addressId}", method = RequestMethod.GET)
public ResponseEntity deleteAddress(@PathVariable("addressId") String addressId) throws Exception {
	System.out.println(addressId);
	addressService.deleteAddress(addressId);
	return new ResponseEntity(HttpStatus.OK);
}

//    @RequestMapping(path = "/ddddddd")
//    public ResponseEntity getOrders(@PathVariable("accountNumber") String accountNumber) throws Exception {
////        return Optional.ofNullable(addressService.getOrdersForAccount(accountNumber))
////                .map(a -> new ResponseEntity<List<Order>>(a, HttpStatus.OK))
////                .orElseThrow(() -> new Exception("Accounts for user do not exist"));
//    }

//    @RequestMapping(path = "/orders/{orderId}/events", method = RequestMethod.POST)
//    public ResponseEntity addOrderEvent(@RequestBody address address,
//                                        @PathVariable("addressId") String orderId) throws Exception {
////        assert orderEvent != null;
////        assert orderId != null;
////        assert !Objects.equals(orderId, orderEvent.getOrderId());
////        return Optional.ofNullable(orderService.addOrderEvent(orderEvent, true))
////                .map(a -> new ResponseEntity<>(HttpStatus.NO_CONTENT))
////                .orElseThrow(() -> new Exception("Order event could not be applied to order"));
//    }
//
//    @RequestMapping(path = "/orders/{orderId}")
//    public ResponseEntity getOrder(@PathVariable("orderId") String orderId) throws Exception {
//        assert orderId != null;
//        return Optional.ofNullable(orderService.getOrder(orderId, true))
//                .map(a -> new ResponseEntity<Order>(a, HttpStatus.OK))
//                .orElseThrow(() -> new Exception("Could not retrieve order"));
//    }
//
//    @RequestMapping(path = "/orders", method = RequestMethod.POST)
//    public ResponseEntity createOrder(@RequestBody List<LineItem> lineItems) throws Exception {
//        assert lineItems != null;
//        assert lineItems.size() > 0;
//        return Optional.ofNullable(orderService.createOrder(lineItems))
//                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
//                .orElseThrow(() -> new Exception("Could not create the order"));
//    }
}
