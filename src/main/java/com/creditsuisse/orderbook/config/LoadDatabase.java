package com.creditsuisse.orderbook.config;

import com.creditsuisse.orderbook.model.Book;
import com.creditsuisse.orderbook.model.Execution;
import com.creditsuisse.orderbook.model.Order;
import com.creditsuisse.orderbook.persist.BookRepository;
import com.creditsuisse.orderbook.persist.OrderRepository;
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
    CommandLineRunner initDatabase(
            BookRepository bookRepository,
            OrderRepository orderRepository)
    {
        return args -> {
            Book book = new Book("finiancialInstrumentId-1");

            Order order = new Order();
            order.setQuantity(5);
//            log.info("Preloading " + orderRepository.save(order));
            Execution execution = new Execution();
            execution.setQuantity(6);

            book.getOrders().add(order);
            book.getExecutions().add(execution);

            log.info("Preloading " + bookRepository.save(book));
//            log.info("Preloading " + bookRepository.save(new Book("finiancialInstrumentId-2")));
        };
    }
}
