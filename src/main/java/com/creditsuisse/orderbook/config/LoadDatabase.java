package com.creditsuisse.orderbook.config;

import com.creditsuisse.orderbook.persist.OrderBookRepository;
import com.creditsuisse.orderbook.model.OrderBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stuart Shannon
 */
@Configuration
@Slf4j
public class LoadDatabase
{
    @Bean
    CommandLineRunner initDatabase(OrderBookRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new OrderBook("finiancialInstrumentId-1")));
            log.info("Preloading " + repository.save(new OrderBook("finiancialInstrumentId-2")));
        };
    }
}
