package com.example.word_chain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.word_chain.entity.Letter;
import com.example.word_chain.repository.LetterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository repository;

    public List<Letter> getAllLetters() {
        List<Letter> letters = repository.findAll();
        return letters;
    }
}