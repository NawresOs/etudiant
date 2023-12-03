package com.example.etudiant.subject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectMapperTest {

    private final SubjectMapper mapper=new SubjectMapper();
@Test
    public void Should_Successfully_Transform_Subject_Request_to_Subject(){
        SubjectRequest request= new SubjectRequest();
        request.setId(null);
        request.setName("Java");
        Subject subject=mapper.toSubject(request);

        assertNull(subject.getId());
        assertEquals("Java",subject.getName());

    }

    @Test
    public void Should_Successfully_Transform_Null_Subject_Request_to_Subject(){
        Subject subject=mapper.toSubject(null);
        assertNotNull(subject);


    }

}