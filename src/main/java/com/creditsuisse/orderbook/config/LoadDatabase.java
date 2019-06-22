package com.creditsuisse.orderbook.config;

import com.creditsuisse.orderbook.model.Execution;
import com.creditsuisse.orderbook.model.Order;
import com.creditsuisse.orderbook.model.OrderBook;
import com.creditsuisse.orderbook.persist.OrderBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

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
            OrderBook orderBook = new OrderBook("finiancialInstrumentId-1");

            Order order = new Order();
            Execution execution = new Execution();

//            order.setOrderBook(orderBook);
//            execution.setOrderBook(orderBook);

            orderBook.setOrders(Arrays.asList(order));
            orderBook.setExecutions(Arrays.asList(execution));


            log.info("Preloading " + repository.save(orderBook));
            log.info("Preloading " + repository.save(new OrderBook("finiancialInstrumentId-2")));
        };
    }
}
