package com.example.word_chain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.word_chain.entity.Word;
import com.example.word_chain.form.WordForm;
import com.example.word_chain.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repository;

    public String addWords(WordForm wordForm) {
        Word word = new Word();
        word.setWord(wordForm.getWord());
        word.setLetterId(wordForm.getLetterId());
        repository.save(word);
        return "完了";
    }

    public List<Word> getAllWords() {
        List<Word> words = repository.findAll();
        return words;
    }

    public List<Word> findWords(Integer letterId) {
        List<Word> words = repository.findByLetterId(letterId);
        return words;
    }

}
