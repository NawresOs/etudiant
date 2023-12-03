package com.example.etudiant.address;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
    private Integer id;

    private String homeAddress;
    private Integer std_id;
}