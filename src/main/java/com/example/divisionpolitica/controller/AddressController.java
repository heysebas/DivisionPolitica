package com.example.divisionpolitica.controller;

import com.example.divisionpolitica.model.entity.Address;
import com.example.divisionpolitica.model.service.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/api/v1/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    //Obtiene una dirección por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") long id) {
        Address address = addressService.getById(id);
        if(address == null) {
            throw new NoSuchElementException();
        }else{
            return ResponseEntity.ok(address);
        }
    }

    //Obtiene todas las direcciones
    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAll() {
        List<Address>AddressList = addressService.findAll();
        if(AddressList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(AddressList);
        }
    }

    //Guarda una dirección
    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody Address address) {
        Address savedAddress = addressService.save(address);
        return ResponseEntity.ok(savedAddress);
    }

    //Elimina una dirección
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> delete(@PathVariable("id") long id) {
        Address address = addressService.getById(id);
        if(address == null) {
            throw new NoSuchElementException();
        }else {
            addressService.delete(address);
            return ResponseEntity.ok(address);
        }
    }

    //Actualiza una dirección
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> update(@PathVariable("id") long id, @RequestBody Address updatedAddress) {
        Address existingAddress = addressService.getById(id);
        if (existingAddress == null) {
            return ResponseEntity.notFound().build(); //estado 404
        }else{
            existingAddress.setAddress(updatedAddress.getAddress());
            existingAddress.setPostalCode(updatedAddress.getPostalCode());
            Address savedAddress = addressService.save(existingAddress);
            return ResponseEntity.ok(savedAddress); //estado 200
        }
    }
}
