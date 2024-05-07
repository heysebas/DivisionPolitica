package com.example.divisionpolitica.model.service.Address;

import com.example.divisionpolitica.model.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> findAll();

    public Address getById(long id);

    public Address save(Address address);

    public void delete(Address address);

}
