package com.example.tracker.bear_tracker.repo;

import com.example.tracker.bear_tracker.entity.BalanceState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceStateRepository
        extends JpaRepository<BalanceState, Long> {
}