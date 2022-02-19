package com.inventorysystem.inventorysystem.Item;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository){
        return args -> {
            Item yogurt = new Item("1101554", "Blueberry Yogurt", "High protein blueberry yogurt.", 13.0, 12, "Cow Farm Farms", "Random Co United LTD Inc");
            Item milk = new Item("1004463", "Milk", "Moo Juice", 48.0, 8, "Cow Farm Farms", "Random Co United LTD Inc");
            repository.saveAll(List.of(yogurt,milk));
        };
    }
}
