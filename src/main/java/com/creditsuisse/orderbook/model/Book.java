package com.creditsuisse.orderbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stuart Shannon
 */
@Data
@Entity
public class Book
{
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String financialInstrumnentId;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    private List<Execution> executions = new ArrayList<>();

    public Book() { }

    public Book(String financialInstrumnentId)
    {
        this.financialInstrumnentId = financialInstrumnentId;
    }
}
