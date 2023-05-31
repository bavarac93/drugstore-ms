package com.pharma.dms.dao;

import com.pharma.dms.model.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @Query("SELECT t FROM BrandEntity t WHERE t.brandName = :brandName")
    List<BrandEntity> findAllBrandsBySomeName(@Param("brandName") final String brandName);
}
