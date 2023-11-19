package com.example.etudiant.chapter.impl;

import com.example.etudiant.chapter.*;
import com.example.etudiant.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final ChapterMapper mapper;




    @Override
    public void save(ChapterResponse c) {
        Chapter chapter = mapper.toChapter(c);
        this.chapterRepository.save(chapter);

    }

    @Override
    public ChapterResponse findById(Integer id) {
        return this.chapterRepository.findById(id)
                .map(mapper::toChapterDto)
                .orElse(new ChapterResponse());
    }

    @Override
    public List<ChapterResponse> findAll() {
        return this.chapterRepository.findAll()
                .stream()
                .map(mapper::toChapterDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.chapterRepository.deleteById(id);

    }
}
