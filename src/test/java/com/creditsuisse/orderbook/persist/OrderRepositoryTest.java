package com.creditsuisse.orderbook.persist;

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
public class OrderRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository repository;

    @Test
    public void whenFindAll_thenReturnOrders()
    {
        // given
        Order order = new Order();
        order.setQuantity(5);

        entityManager.persist(order);
        entityManager.flush();

        List<Order> expected = Collections.singletonList(order);

        // when
        List<Order> actual = repository.findAll();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
