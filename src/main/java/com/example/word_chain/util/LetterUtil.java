package com.example.word_chain.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.word_chain.entity.Letter;
import com.example.word_chain.form.WordChainForm;
import com.example.word_chain.service.LetterService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LetterUtil {
    private final LetterService service;

    public Letter findLastLetter(WordChainForm form) {
        String word = form.getWord();
        char lastChar = word.charAt(word.length() - 1);
        String letter = String.valueOf(lastChar);
        List<Letter> letters = service.getAllLetters();
        for (Letter l : letters) {
            if (l.getLetter().equals(letter)) {
                return l;
            }
        }
 
        return null;
    }

    public Letter findFirstLetter(WordChainForm form) {
        String word = form.getWord();
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