package com.example.etudiant.address;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddresService servicea;


    public AddressController(AddresService servicea) {
        this.servicea = servicea;
    }

    @PostMapping
    public void save(@RequestBody @Valid Address addr){
        servicea.save(addr);
    }
}

