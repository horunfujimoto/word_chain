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

    public Letter findLastLetter(String currentWord) {
        String word = currentWord;
        char lastChar = word.charAt(word.length() - 1);
        if (String.valueOf(lastChar).equals("ー")) {
            lastChar  = word.charAt(word.length() - 2);
         }
        String letter = String.valueOf(lastChar);
        List<Letter> letters = service.getAllLetters();
        for (Letter l : letters) {
            if (l.getLetter().equals(letter)) {
                return l;
            }
        }
 
        return null;
    }

    public Letter findFirstLetter(String currentWord) {
        String word = currentWord;
        char firstChar = word.charAt(0);
        String letter = String.valueOf(firstChar);
        List<Letter> letters = service.getAllLetters();
        for (Letter l : letters) {
            if (l.getLetter().equals(letter)) {
                return l;
            }
        }

        return null;
    }
}