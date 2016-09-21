package com.zyhao.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<com.zyhao.address.Address, String> {
	 public Address findById(long id);
	 public void deleteById(long addressId);
}
