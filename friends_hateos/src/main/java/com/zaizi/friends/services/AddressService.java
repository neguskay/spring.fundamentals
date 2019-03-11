package com.zaizi.friends.services;

import com.zaizi.friends.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressService  extends CrudRepository<Address, Integer> {
}
