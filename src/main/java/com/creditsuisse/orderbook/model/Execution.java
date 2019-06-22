package com.creditsuisse.orderbook.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Stuart Shannon
 */
@Data
@Entity
public class Execution
{
    @Id
    @Column(name = "EXECUTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long quantity;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;


    public Execution() { }

}
