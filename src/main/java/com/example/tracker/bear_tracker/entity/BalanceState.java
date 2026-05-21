package com.example.tracker.bear_tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BalanceState {

    @Id
    private Long id = 1L;

    private Integer amount = 0;
}