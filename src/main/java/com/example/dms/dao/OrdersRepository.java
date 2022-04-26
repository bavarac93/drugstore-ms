package com.example.dms.dao;

import com.example.dms.model.OrdersEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    @Query("SELECT t FROM OrdersEntity t WHERE t.dateTimeOrdered = :dateTimeOrdered")
    List<OrdersEntity> findOrdersMadeOnSomeDate(@Param("dateTimeOrdered") @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime dateTimeOrdered);

    @Query("SELECT t FROM OrdersEntity t WHERE t.customerEntity.id = :customerId")
    List<OrdersEntity> findOrdersMadeBySameCustomer(@Param("customerId") final Long customerId);
}
