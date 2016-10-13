package com.zyhao.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class AddressControllerV1 {
	 @RequestMapping(path = "/accounts")

	    public String getUserAccount() throws Exception {
	        return "asdfasdf";
	    }
//    private AddressServiceV1 addressService;
//
//    @Autowired
//    public AddressControllerV1(AddressServiceV1 addressService) {
//        this.addressService = addressService;
//    }
 
//  @RequestMapping(path = "/address/{addressId}")
//  public Address getAddress(@PathVariable("addressId") String addressId) throws Exception {
//	  return addressService.getAddress(addressId,false);
////      return Optional.ofNullable(addressService.getAddress(addressId,false))
////              .map(a -> new ResponseEntity<List<com.zyhao.address.Address>>(a, HttpStatus.OK))
////              .orElseThrow(() -> new Exception("addressId for address do not exist"));
//  }
//@RequestMapping(path = "/address/create", method = RequestMethod.GET)//RequestBody
//public ResponseEntity createAddress(Address address) throws Exception {
//	System.out.println(address);
//	return new ResponseEntity<Address>(addressService.createAddress(address), HttpStatus.OK);
//}
//@RequestMapping(path = "/address/delete/{addressId}", method = RequestMethod.GET)
//public ResponseEntity deleteAddress(@PathVariable("addressId") String addressId) throws Exception {
//	System.out.println(addressId);
//	addressService.deleteAddress(addressId);
//	return new ResponseEntity(HttpStatus.OK);
//}

}
