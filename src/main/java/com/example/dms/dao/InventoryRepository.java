package com.example.dms.dao;

import com.example.dms.model.CustomerEntity;
import com.example.dms.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    @Query("SELECT t FROM InventoryEntity t WHERE t.expiryDate <= :expiryDate")
    List<InventoryEntity> findItemsWithSpecificExpiryDate(@Param("expiryDate") LocalDate expiryDate);

}
