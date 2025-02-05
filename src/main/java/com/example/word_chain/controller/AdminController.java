package com.example.word_chain.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.word_chain.entity.Word;
import com.example.word_chain.form.WordForm;
import com.example.word_chain.service.AdminService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("/create")
    public String addWords(@ModelAttribute WordForm wordForm, Model model) {
        service.addWords(wordForm);
        String word = wordForm.getWord();
        return word + "の登録が完了しました";
    }

    @GetMapping("/word")
    public ResponseEntity<List<Word>> getAllWords() {
       List<Word> words =  service.getAllWords();
            return ResponseEntity.ok()
                    .body(words);  
    }
    

    @PostMapping("/search")
    public ResponseEntity<List<Word>> findWords(@RequestParam Integer letterId) {
        List<Word> words = service.findWords(letterId);
        return ResponseEntity.ok()
                .body(words);
    }
    
    
}
