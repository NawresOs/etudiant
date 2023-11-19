package com.example.etudiant.chapter;

import com.example.etudiant.student.Student;
import com.example.etudiant.student.StudentRequest;
import com.example.etudiant.student.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public class ChapterMapper {



    public ChapterResponse toChapterDto (Chapter chapter){
        return ChapterResponse.builder()
                .name(chapter.getName())
                .sub_id(chapter.getSubject().getId())
                .build();

    }


    public Chapter toChapter(ChapterRequest c){
        Chapter chapter=new Chapter();
        chapter.setId(c.getId());
        chapter.setName(c.getName());
        chapter.setSubject(chapter.getSubject());
        return chapter;
    }


}
