package com.example.word_chain.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.word_chain.entity.Letter;
import com.example.word_chain.service.LetterService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LetterUtil {
    private final LetterService service;

    public Letter findLetter(String currentWord, String position) {
        String word = currentWord;
        char charValue;

        if (position.equals("first")) {
             charValue  = word.charAt(0);
        } else {
             charValue  = word.charAt(word.length() - 1);
             if (String.valueOf(charValue).equals("ー")) {
                charValue  = word.charAt(word.length() - 2);
             }
        }
        
        String letter = String.valueOf(charValue);
        List<Letter> letters = service.getAllLetters();
        for (Letter l : letters) {
            if (l.getLetter().equals(letter)) {
                return l;
            }
        }
        return null;
    }
}