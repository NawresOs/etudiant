package com.example.etudiant.subject;

import java.util.List;

public interface SubjectService {

 public void save(Subject sub);
    void save(SubjectResponse s);
    SubjectResponse findById(Integer id);
    List<SubjectResponse> findAll ();
    void deleteById(Integer id);


}
