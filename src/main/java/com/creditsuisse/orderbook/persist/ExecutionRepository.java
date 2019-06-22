package com.creditsuisse.orderbook.persist;

import com.creditsuisse.orderbook.model.Execution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stuart Shannon
 */
public interface ExecutionRepository extends JpaRepository<Execution, Long>
{
}
