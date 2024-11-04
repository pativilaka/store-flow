package com.fiap.store_flow.repositories;

import com.fiap.store_flow.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
