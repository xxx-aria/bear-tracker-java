package com.example.tracker.bear_tracker;

import com.example.tracker.bear_tracker.entity.ShopItem;
import com.example.tracker.bear_tracker.repo.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ShopItemRepository shopItemRepository;

    @Override
    public void run(String... args) {
        if (shopItemRepository.count() > 0) return;

        add("Ставлю с тобой парную аватарку в тг на неделю", 25);
        add("Постону в гс (короткое гс)", 45);
        add("Купон-отмена на пропуск любого задания", 5);
        add("Напишу тебе комплименты реально что мне нрав но не прям много ибо нужно дозированно", 17);
        add("Могу попробовать тебе что-то нарисовать (если одобрю запрос), но без 18+", 15);
        add("Объясню тебе тему для НМТ, которую не понимаешь", 1);
        add("Играю с тобой в какой-то режим в роблоксе примерно час", 20);
        add("Можешь выбрать мне какое-то платье юбку одежду", 35);
        add("Можешь выбрать мне какой-то аксессуар (напр бантик, ожерелье, головной убор, браслет) или обувь", 15);
        add("Составляешь мне плейлист под который я буду ходить бегать", 10);
    }

    private void add(String title, Integer price) {
        ShopItem item = new ShopItem();
        item.setTitle(title);
        item.setPrice(price);
        shopItemRepository.save(item);
    }
}