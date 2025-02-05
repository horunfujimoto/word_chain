package com.example.word_chain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.word_chain.entity.UsedWord;
import com.example.word_chain.entity.Word;
import com.example.word_chain.form.WordChainForm;
import com.example.word_chain.repository.WordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository repository;
    private final UsedWordService service;

    public String getWord(Integer id) {
        List<Word> words = repository.findUnusedWord(id);
        Word word = words.getFirst();
        String ret = word.getWord();
        service.addUsedWord(word);
        return ret;
    }

    public List<UsedWord> getUsedWords() {
        return service.getUsedWords();
    }

    public void setUsedWord(WordChainForm form) {
        Word res = repository.findByWord(form.getWord());
        if (res != null ) {
            service.addUsedWord(res);
        }
    }

    public void setNewWord(Integer id, String word) {
        Word res = repository.findByWord(word);
        if (res == null ) {
            Word newWord = new Word();
            newWord.setLetterId(id);
            newWord.setWord(word);
            repository.save(newWord);
            service.addUsedWord(newWord);
        }
    }

    public void resetWord() {
        service.resetWord();
    }
}