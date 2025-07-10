package com.tw.repo;

import com.tw.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerCustId(int custId);

    @Query("FROM Order WHERE payMode=:payMode AND customer.custId=:custId")
    List<Order> findByPayMode(String payMode, int custId);

    int countByCustomerCustId(int custId);

    @Query("FROM Order WHERE orderDate BETWEEN :start AND :end AND customer.custId=:custId")
    List<Order> findByDateRangeForCustomer(LocalDate start, LocalDate end, int custId);

    List<Order> findByProdCode(int code);
}
