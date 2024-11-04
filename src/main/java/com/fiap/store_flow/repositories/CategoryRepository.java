package com.fiap.store_flow.repositories;

import com.fiap.store_flow.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}