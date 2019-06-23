package com.creditsuisse.orderbook.persist;

import com.creditsuisse.orderbook.model.Book;
import com.creditsuisse.orderbook.model.Execution;
import com.creditsuisse.orderbook.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Stuart Shannon
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void whenFindAll_thenReturnOrders()
    {
        // given
        Book book = new Book("test-financial-instrument-id");

        Order order = new Order();
        order.setQuantity(5);

        Execution execution = new Execution();
        execution.setQuantity(4);

        book.setOrders(Collections.singletonList(order));
        book.setExecutions(Collections.singletonList(execution));

        entityManager.persist(book);
        entityManager.flush();

        List<Book> expected = Collections.singletonList(book);

        // when
        List<Book> actual = repository.findAll();

        // then
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}
