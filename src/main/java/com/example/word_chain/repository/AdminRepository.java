package com.example.word_chain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.word_chain.entity.Word;

public interface AdminRepository extends JpaRepository<Word, Integer>{
     List<Word> findByLetterId(Integer letterId);
}