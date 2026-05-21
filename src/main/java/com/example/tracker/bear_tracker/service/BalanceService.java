package com.example.tracker.bear_tracker.service;

import com.example.tracker.bear_tracker.entity.BalanceState;
import com.example.tracker.bear_tracker.repo.BalanceStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceStateRepository balanceRepo;

    public BalanceState getBalanceState() {
        return balanceRepo.findById(1L)
                .orElseGet(() -> balanceRepo.save(new BalanceState()));
    }

    public Integer getBalance() {
        return getBalanceState().getAmount();
    }

    public void updateBalance(Integer amount) {
        BalanceState balance = getBalanceState();
        balance.setAmount(amount);
        balanceRepo.save(balance);
    }
}