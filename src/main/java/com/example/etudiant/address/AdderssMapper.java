package com.example.etudiant.address;

import org.springframework.stereotype.Service;

@Service
public class AdderssMapper {

    public AddressResponse toAddresDto(Address address){
        return AddressResponse.builder()
                .id(address.getId())
                .homeAddress(address.getHomeAddress())
                .std_id(address.getStudent().getId())
                .build();
    }

    public Address toAddress(AddressRequest addressRequest){
        Address address=new Address();
        address.setId(address.getId());
        address.setHomeAddress(address.getHomeAddress());
        return  address;
    }
}
