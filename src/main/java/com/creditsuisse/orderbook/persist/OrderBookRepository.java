package com.creditsuisse.orderbook.persist;

import com.creditsuisse.orderbook.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stuart Shannon
 */
public interface OrderBookRepository extends JpaRepository<OrderBook, Long>
{
}
