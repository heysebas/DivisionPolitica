package com.example.divisionpolitica.model.service.Address;

import com.example.divisionpolitica.model.entity.Address;
import com.example.divisionpolitica.model.repository.Address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(long id) {
        return addressRepository.getById(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
