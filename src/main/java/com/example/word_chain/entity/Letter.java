package com.example.word_chain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "letters")
public class Letter {
    @Id
    private Integer id;
    private String letter;
}
