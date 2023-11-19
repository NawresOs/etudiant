package com.example.etudiant.address;

import java.util.List;

public interface AddresService {


    public void save(Address addr);

    void save(AddressRequest a);

    AddressResponse findById(Integer id);
    List<AddressResponse> findAll ();
    void deleteById(Integer id);







}
