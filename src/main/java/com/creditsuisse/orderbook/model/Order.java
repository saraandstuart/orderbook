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
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;


    public Order() { }


}
