package com.example.word_chain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.word_chain.entity.Letter;

public interface LetterRepository  extends JpaRepository<Letter, Integer>{}