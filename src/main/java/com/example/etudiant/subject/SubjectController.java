package com.example.etudiant.subject;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService servicesub;

    public SubjectController(SubjectService servicesub) {
        this.servicesub = servicesub;
    }


    @PostMapping
    public void save(
            @RequestBody @Valid SubjectRequest subject
    ) {
        servicesub.save(subject);
    }


}
