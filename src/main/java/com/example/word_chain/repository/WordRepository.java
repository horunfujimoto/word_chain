package com.example.word_chain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.word_chain.entity.Word;


public interface WordRepository extends JpaRepository<Word, Integer>{

    @Query("SELECT w FROM Word w " +
       "LEFT JOIN UsedWord uw ON w.id = uw.wordId " +
       "WHERE w.letterId = :id AND (uw.wordId IS NULL OR uw.isUsed = false)") //これだとuwに入っていないものを取り出すけど、ゲームがリセットされた時にどうする？やっぱりuwにis_used持たせた方がよさそうだ
    public List<Word> findUnusedWord(Integer id);


    public Word findByWord(String word);

}