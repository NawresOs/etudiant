package com.example.etudiant.student.imp;
import com.example.etudiant.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;
    @Override
    public void save(StudentRequest s) {
        Student student = mapper.toStudent(s);
        this.studentRepository.save(student);

    }

    @Override
    public StudentResponse findById(Integer id) {
        return this.studentRepository.findById(id)
                .map(mapper::toStudentDto)
                .orElse(new StudentResponse());

    }

    @Override
    public List<StudentResponse> findAll() {
        return this.studentRepository.findAll()
                .stream()
                .map(mapper::toStudentDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);

    }
}