package com.example.dms.dao;

import com.example.dms.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    @Query("SELECT t FROM InventoryEntity t WHERE t.expiryDate <= :expiryDate")
    List<InventoryEntity> findAllWithExpiryTimeBefore(@Param("expiryDate") LocalDate expiryDate);

    @Query("SELECT t FROM InventoryEntity t WHERE t.brandEntity.id = :brandId")
    List<InventoryEntity> findItemsMadeByTheSameBrand(@Param("brandId") final Long brandId);

    @Query("SELECT COUNT(t) FROM InventoryEntity t WHERE t.brandEntity.id = :brandId")
    int countItemsMadeByTheSameBrand(@Param("brandId") final Long brandId);

    @Query("SELECT t FROM InventoryEntity t WHERE t.productTypeEntity.id = :productTypeId")
    List<InventoryEntity> findItemsOfTheSameType(@Param("productTypeId") final Long productTypeId);

    @Query("SELECT COUNT(t) FROM InventoryEntity t WHERE t.productTypeEntity.id = :productTypeId")
    int countItemsOfTheSameType(@Param("productTypeId") final Long productTypeId);

    @Query("SELECT t FROM InventoryEntity t WHERE t.supplierEntity.id = :supplierId")
    List<InventoryEntity> findItemsFromTheSameSupplier(@Param("supplierId") final Long supplierId);

    @Query("SELECT COUNT(t) FROM InventoryEntity t WHERE t.supplierEntity.id = :supplierId")
    int countItemsFromTheSameSupplier(@Param("supplierId") final Long supplierId);
}
