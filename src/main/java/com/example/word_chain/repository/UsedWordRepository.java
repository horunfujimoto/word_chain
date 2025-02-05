package com.example.word_chain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.word_chain.entity.UsedWord;

@Repository
public interface UsedWordRepository extends JpaRepository<UsedWord, Integer>{
    @Query("SELECT uw FROM UsedWord uw WHERE uw.isUsed = true")
    public List<UsedWord> getAll();

    @Query("SELECT CASE WHEN COUNT(uw) > 0 THEN true ELSE false END FROM UsedWord uw WHERE uw.wordId = :id")
    public boolean existsById(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE UsedWord uw SET uw.isUsed = true WHERE uw.wordId = :id AND uw.isUsed = false")
    public void toUsed(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE UsedWord uw SET uw.isUsed = false AND uw.isUsed = false")
    public void toUnused();
}