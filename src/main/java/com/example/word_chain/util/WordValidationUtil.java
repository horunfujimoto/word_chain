package com.example.word_chain.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.word_chain.entity.UsedWord;

@Component
public class WordValidationUtil {
    public Boolean isLastCharacterMatch(String previousWord, String currentWord) {
        char firstChar = currentWord.charAt(0);
        char lastChar = previousWord.charAt(previousWord.length() - 1);
        if (firstChar == lastChar) {
            return true;
        }
        return false;
    }

    public Boolean isWordAlreadyUsed(String currentWord, List<UsedWord>usedWords) {
        for(UsedWord w : usedWords) {
            String used = w.getWord();
            if(used.equals(currentWord)) {
                return true;
            }
        }
        return false;
    }
}
