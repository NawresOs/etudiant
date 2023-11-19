package com.example.etudiant.subject;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequest {

    private Integer id;
    @NotNull(message = "name must not be null")
    private String name;
    private Integer sub_id;
    private Integer std_id;

}
