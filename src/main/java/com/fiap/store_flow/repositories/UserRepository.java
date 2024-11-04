package com.fiap.store_flow.repositories;

import com.fiap.store_flow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
