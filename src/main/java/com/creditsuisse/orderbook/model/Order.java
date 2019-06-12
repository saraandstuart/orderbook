package com.creditsuisse.orderbook.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Stuart Shannon
 */
@Data
@Entity
@Table(name = "BOOK_ORDER")
public class Order
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private OrderBook orderBook;

    public Order() { }


}
