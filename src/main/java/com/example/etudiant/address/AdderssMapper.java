package com.example.etudiant.address;

import com.example.etudiant.student.Student;
import com.example.etudiant.student.StudentRequest;
import com.example.etudiant.student.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public class AdderssMapper {

    public AddressResponse toAddressDto(Address adr) {
        return AddressResponse.builder()
                .id(adr.getId())
                .homeAddress(adr.getHomeAddress())
                .firstname(adr.getStudent().getFirstname())
                .build();
    }


    public Address toAddress(AddressRequest a) {
        Address address=new Address();
        address.setId(address.getId());
        address.setHomeAddress(address.getHomeAddress());
      
        return address;
    }

}
