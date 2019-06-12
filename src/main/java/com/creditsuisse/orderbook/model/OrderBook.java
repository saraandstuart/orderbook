package com.creditsuisse.orderbook.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Stuart Shannon
 */
@Data
@Entity
public class OrderBook
{
    @Id
    @GeneratedValue
    private Long id;
    private String financialInstrumnentId;
    @OneToMany(mappedBy="orderBook")
    private List<Order> orders;
    @OneToMany(mappedBy="orderBook")
    private List<Execution> executions;

    public OrderBook() { }

    public OrderBook(String financialInstrumnentId)
    {
        this.financialInstrumnentId = financialInstrumnentId;
    }
}
