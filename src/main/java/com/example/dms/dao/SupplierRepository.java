package com.example.dms.dao;

import com.example.dms.model.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository <SupplierEntity, Long> {
}
