package com.example.dms.dao;

import com.example.dms.model.SupplierEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository <SupplierEntity, Long> {

    @Query("SELECT t FROM SupplierEntity t WHERE t.contractSigned = :contractSigned")
    List<SupplierEntity> findAllWithContractSignedOn (@Param("contractSigned") @JsonFormat(pattern="yyyy-MM-dd") LocalDate contractSigned);
}
