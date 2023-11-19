package com.example.etudiant.subject;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponse {
    private String name;
    private Integer sub_id;
    private Integer std_id;
}
