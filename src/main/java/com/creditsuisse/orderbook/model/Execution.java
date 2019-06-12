package com.creditsuisse.orderbook.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Stuart Shannon
 */
@Data
@Entity
public class Execution
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private OrderBook orderBook;

    public Execution() { }

}
