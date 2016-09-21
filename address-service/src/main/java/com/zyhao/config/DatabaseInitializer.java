package com.zyhao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyhao.address.AddressRepository;

@Service
public class DatabaseInitializer {

    private AddressRepository addressRepository;

    @Autowired
    public DatabaseInitializer(AddressRepository orderRepository) {
        this.addressRepository = addressRepository;
    }

    public void populate() {
        // Clear existing data
//    	addressRepository.deleteAll();

//        // Create a new shipping address for the customer
//    	com.zyhao.address.Address shippingAddress = new com.zyhao.address.Address();
//
//        // Save the invoice
//        addressRepository.save(shippingAddress);
    }
}
