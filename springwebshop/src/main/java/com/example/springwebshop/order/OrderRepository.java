package com.example.springwebshop.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository
        extends JpaRepository<Orders, Long> {

    Optional<Orders> findOrderByItemId(Long itemId);

    //Making an optional with a list of orders
    Optional<List<Orders>> findAllByCustomerId(Long customerId);

}
