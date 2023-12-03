package com.example.etudiant.subject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequest {

    private Integer id;
    @NotNull(message = "Subject name is mandatory")
    @NotEmpty(message = "Subject name is mandatory")
    private String name;
}
