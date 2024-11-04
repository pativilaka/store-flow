package com.fiap.store_flow.repositories;

import com.fiap.store_flow.entities.OrderItem;
import com.fiap.store_flow.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {


}
