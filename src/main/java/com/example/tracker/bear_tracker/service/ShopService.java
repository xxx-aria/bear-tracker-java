package com.example.tracker.bear_tracker.service;

import com.example.tracker.bear_tracker.entity.ShopItem;
import com.example.tracker.bear_tracker.repo.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopItemRepository shopItemRepository;

    public List<ShopItem> getAllItems() {
        return shopItemRepository.findAll();
    }
}