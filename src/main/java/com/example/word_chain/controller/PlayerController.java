package com.example.word_chain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.word_chain.entity.UsedWord;
import com.example.word_chain.form.WordChainForm;
import com.example.word_chain.service.WordService;
import com.example.word_chain.util.LetterUtil;
import com.example.word_chain.util.WordValidationUtil;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class PlayerController {
    private final WordService service;
    private final LetterUtil letterUtil;
    private final WordValidationUtil validation;

    @PostMapping("/wordchain")
    public ResponseEntity<String> play(@ModelAttribute @Validated WordChainForm form, Model model, HttpSession session) {
        List<UsedWord> usedWords = service.getUsedWords();
        String previousWord = (String) session.getAttribute("previousWord");

        if (validation.isWordAlreadyUsed(form.getWord(), usedWords)) {
            return  ResponseEntity.ok()
                            .body("この単語はすでに使われています！");
        }
        if (previousWord != null) {
            if (!validation.isLastCharacterMatch(previousWord, form.getWord())) {
                return ResponseEntity.ok()
                            .body("前の言葉に続いていません！(前の言葉："+ previousWord + ")");
            }
        }
        Integer firstId = letterUtil.findFirstLetter(form).getId();
        Integer lastId = letterUtil.findLastLetter(form).getId();
        String word = service.getWord(lastId);
        session.setAttribute("previousWord", word);
        service.setUsedWord(form);
        service.setNewWord(firstId, form.getWord());
        return ResponseEntity.ok()
                    .body(word);  
    }

    @GetMapping("/reset")
    public String resetWord() {
        service.resetWord();
        return "リセットが完了しました";
    }
    
}
