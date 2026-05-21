package com.example.tracker.bear_tracker.repo;

import com.example.tracker.bear_tracker.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}