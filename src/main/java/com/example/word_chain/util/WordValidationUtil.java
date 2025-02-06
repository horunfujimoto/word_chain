package com.example.word_chain.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.word_chain.entity.UsedWord;

@Component
public class WordValidationUtil {
    public Boolean isLastCharacterMatch(String previousWord, String currentWord) {
        char firstChar = currentWord.charAt(0);
        String normalized = normalizeString(previousWord);
        char lastChar = normalized.charAt(previousWord.length() - 1);
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

    public Boolean isWordEndingWithN(String word) {
        char lastChar = word.charAt(word.length() - 1);
    
        if (Character.toString(lastChar).equals("ん")) {
            return true;
        }
        return false;
    }

    public String normalizeString(String word) {
        String[] VOICED_TO_UNVOICED = {
            "ご", "こ",   // ご → こ
            "ぎ", "き",   // ぎ → き
            "ぐ", "く",   // ぐ → く
            "げ", "け",   // げ → け
            "ご", "こ",   // ご → こ
            "ざ", "さ",   // ざ → さ
            "じ", "し",   // じ → し
            "ず", "す",   // ず → す
            "ぜ", "せ",   // ぜ → せ
            "ぞ", "そ",   // ぞ → そ
            "だ", "た",   // だ → た
            "ぢ", "ち",   // ぢ → ち
            "づ", "つ",   // づ → つ
            "で", "て",   // で → て
            "ど", "と",   // ど → と
            "ば", "は",   // ば → は
            "び", "ひ",   // び → ひ
            "ぶ", "ふ",   // ぶ → ふ
            "べ", "へ",   // べ → へ
            "ぼ", "ほ",   // ぼ → ほ
            "ぱ", "は",   // ぱ → は
            "ぴ", "ひ",   // ぴ → ひ
            "ぷ", "ふ",   // ぷ → ふ
            "ぺ", "へ",   // ぺ → へ
            "ぽ", "ほ"    // ぽ → ほ
        };

        for (int i = 0; i < VOICED_TO_UNVOICED.length; i += 2) {
            word = word.replace(VOICED_TO_UNVOICED[i], VOICED_TO_UNVOICED[i + 1]);
        }
        return word;
    }
}
