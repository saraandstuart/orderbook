package com.creditsuisse.orderbook.persist;

import com.creditsuisse.orderbook.model.Execution;
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
public class ExecutionRepostoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ExecutionRepository repository;

    @Test
    public void whenFindAll_thenReturnExecutions()
    {
        // given
        Execution execution = new Execution();
        execution.setQuantity(5);

        entityManager.persist(execution);
        entityManager.flush();

        List<Execution> expected = Collections.singletonList(execution);

        // when
        List<Execution> actual = repository.findAll();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
