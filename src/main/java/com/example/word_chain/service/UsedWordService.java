package com.example.word_chain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.word_chain.entity.UsedWord;
import com.example.word_chain.entity.Word;
import com.example.word_chain.repository.UsedWordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsedWordService {
    private final UsedWordRepository repository;

    public List<UsedWord> getUsedWords() {
        return repository.getAll();
    }

    public void addUsedWord(Word word) {
        Integer wordId = word.getId(); 
        Boolean res = repository.existsById(wordId);
        if (res == true) {
            repository.toUsed(wordId);
        } else {
            UsedWord used = new UsedWord();
            used.setWordId(wordId);
            used.setWord(word.getWord());
            used.setIsUsed(true);
            repository.save(used);
        }
    }

    public void resetWord() {
        repository.toUnused();
    }
}