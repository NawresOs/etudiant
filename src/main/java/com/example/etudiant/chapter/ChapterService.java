package com.example.etudiant.chapter;

import com.example.etudiant.student.StudentRequest;
import com.example.etudiant.student.StudentResponse;

import java.util.List;

public interface ChapterService {

    void save(ChapterResponse c);
    ChapterResponse findById(Integer id);
    List<ChapterResponse> findAll();
    void deleteById(Integer id);
}
