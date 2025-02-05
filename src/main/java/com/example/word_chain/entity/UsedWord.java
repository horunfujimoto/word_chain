package com.example.word_chain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "used_words")
public class UsedWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer wordId;

    private String word;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isUsed;
}
