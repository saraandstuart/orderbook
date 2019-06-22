package com.creditsuisse.orderbook.persist;

import com.creditsuisse.orderbook.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stuart Shannon
 */
public interface OrderRepository extends JpaRepository<Order, Long>
{
}
