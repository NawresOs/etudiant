package com.example.etudiant.chapter;

import org.springframework.stereotype.Service;

@Service
public class ChapterMapper {



    public ChapterResponse toChapterDto (Chapter chapter){
        return ChapterResponse.builder()
                .name(chapter.getName())
                .sub_id(chapter.getSubject().getId())
                .build();

    }


    public Chapter toChapter(ChapterResponse c){
        Chapter chapter=new Chapter();
        chapter.setId(c.getId());
        chapter.setName(c.getName());
        chapter.setSubject(chapter.getSubject());
        return chapter;
    }


}
