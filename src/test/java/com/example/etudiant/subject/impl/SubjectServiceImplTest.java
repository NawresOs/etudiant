package com.example.etudiant.subject.impl;

import com.example.etudiant.exception.StudentAssignmentException;
import com.example.etudiant.student.Student;
import com.example.etudiant.student.StudentRepository;
import com.example.etudiant.student.StudentService;
import com.example.etudiant.subject.Subject;
import com.example.etudiant.subject.SubjectMapper;
import com.example.etudiant.subject.SubjectRepository;
import com.example.etudiant.subject.SubjectRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.xmlunit.util.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubjectServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private SubjectRepository subjectRepository;
    @Mock
    private SubjectMapper mapper;

@InjectMocks
    private SubjectServiceImpl subjectService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);


    }
    @Test
    public void should_save_subject_successfuly(){
           SubjectRequest request= new SubjectRequest();
            request.setId(null);
            request.setName("Java");

            Subject subject=Subject.builder()
                            .id(null)
                            .name("nawres")
                                    .build();

            when (mapper.toSubject(request)).thenReturn(subject);


            subjectService.save(request);

        verify(subjectRepository, times(1)).save(subject);


    }
@Test
    public void sould_assign_subject_to_student(){
//Given
        Integer subjectId=1;
        Integer studentId=1;

        Subject subject=new Subject();
        subject.setId(subjectId);
        subject.setStudents(new ArrayList<>());

        Student student=new Student();
        student.setId(studentId);
        student.setSubjects(new ArrayList<>());

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));

        when(subjectRepository.findById(subjectId))
                .thenReturn(Optional.of(subject));

        //when
        subjectService.assignSubjectToStudent(subjectId,studentId);

        //THEN (VERIFICATION)
        assertTrue(student.getSubjects().contains(subject));
        assertTrue(subject.getStudents().contains(student));
        verify(subjectRepository,times(1)).save(subject);
        verify(studentRepository,times(1)).save(student);

    }

    @Test
    public void should_throw_StudentAssignmentException_when_student_is_assigned_to_3_subjects() {

        // GIVEN
        Integer subjectId = 1;
        Integer studentId = 2;

        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setStudents(new ArrayList<>());

        Student student = new Student();
        student.setId(studentId);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.builder().id(10).build());
        subjects.add(Subject.builder().id(20).build());
        subjects.add(Subject.builder().id(30).build());

        student.setSubjects(subjects);

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        // THEN
        var exp = assertThrows(StudentAssignmentException.class, () -> subjectService.assignSubjectToStudent(subjectId, studentId));
        assertEquals(exp.getMessage(), "Student cannot be assigned to more than 3 subjects");
    }

    @Test
    public void Student_is_already_assigned_to_this_subject(){
        //Given
        Integer studentId=10;
        Integer subjectid=11;

        Subject subject = new Subject();
        subject.setId(subjectid);
        Student student= new Student();
        student.setId(studentId);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.builder().id(subjectid).build());
        student.setSubjects(subjects);

    Mockito.when(subjectRepository.findById(subjectid)).thenReturn(Optional.of(subject));
    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));


    //THEN
        var test=assertThrows(StudentAssignmentException.class, () ->subjectService.assignSubjectToStudent(subjectid, studentId));
        assertEquals(test.getMessage(),"Student is already assigned to this subject");
    }

    @Test
    public void sould_assign_student_to_subject(){
        Integer studentId=14;
        Integer subjectid=11;


        Subject subject=new Subject();
        subject.setId(subjectid);
        subject.setStudents((new ArrayList<>()));


        Student student=new Student();
        student.setId(studentId);
        subject.setStudents(new ArrayList<>());

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));

        when(subjectRepository.findById(subjectid))
                .thenReturn(Optional.of(subject));

        when(subjectRepository.findById(subjectid)).thenReturn(Optional.of(subject));
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        //WHEN
        //subjectService.assignSubjectToStudent(subjectid,studentId);
        //Then
        assertTrue(subject.getStudents().contains(subject));
        assertTrue(student.getSubjects().contains(student));
        verify(studentRepository,times(1)).save(student);
    }
}

