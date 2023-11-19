package com.example.etudiant.address;

import jakarta.validation.constraints.NotNull;

public class AddressRequest {



    private Integer id;
    @NotNull(message = "homeAddress must not be null")
    private String homeAddress;
    private Integer student_id;


}
