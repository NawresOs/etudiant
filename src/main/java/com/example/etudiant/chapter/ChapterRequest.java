package com.example.etudiant.chapter;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChapterRequest {

    private Integer id;
    @NotNull(message = "name must not be null")
    private String name;


}
