package com.example.dms.dao;

import com.example.dms.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    RolesEntity findByName(final String name);

    @Query("SELECT t FROM RolesEntity t WHERE t.name = :name")
    List<RolesEntity> findAllRolesByName(@Param("name") String name);
}
