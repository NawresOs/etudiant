package com.example.etudiant.address.impl;

import com.example.etudiant.address.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddresService {

    private final AdressRepository adressRepository;
    private final AdderssMapper mapper;


    @Override
    public void save(Address addr) {

    }

    @Override
    public void save(AddressRequest addr ) {
        Address address = mapper.toAddress(addr);
        this.adressRepository.save(address);
    }

    @Override
    public AddressResponse findById(Integer id) {
        return this.adressRepository.findById(id)
                .map(mapper::toAddressDto)
                .orElse(new AddressResponse());
    }

    @Override
    public List<AddressResponse> findAll() {
        return this.adressRepository.findAll()
                .stream()
                .map(mapper::toAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.adressRepository.deleteById(id);
    }
}
