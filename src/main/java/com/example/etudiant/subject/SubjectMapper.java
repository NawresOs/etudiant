package com.example.etudiant.subject;

import com.example.etudiant.chapter.ChapterResponse;
import com.example.etudiant.student.Student;
import com.example.etudiant.student.StudentRequest;
import com.example.etudiant.student.StudentResponse;

public class SubjectMapper {

    /*public StudentResponse toStudentDto(Student std) {
        return StudentResponse.builder()
                .firstname(std.getFirstname())
                .lastname(std.getLastname())
                .age(std.getAge())
                .nbrSubjects(std.getSubjects().size())
                .build();
    }
    public Student toStudent(StudentRequest s) {
        Student student = new Student();
        student.setId(s.getId());
        student.setFirstname(s.getFirstname());
        student.setLastname(s.getLastname());
        student.setAge(s.getAge());
        return student;
    }*/

    public SubjectResponse toSubjectDto(Subject sub){
        return SubjectResponse.builder()
                .name(sub.getName())
                .build();
    }

    public Subject toSubject(SubjectRequest sb){
        Subject subject=new Subject();
        subject.setId(sb.getId());
        //subject.setChapters();
       // subject.getStudents(sb.getStd_id());
        return subject;
    }
}
