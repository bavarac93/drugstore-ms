package com.example.dms.dao;

import com.example.dms.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(final String name);

    @Query("SELECT t FROM RoleEntity t WHERE t.name = :name")
    List<RoleEntity> findAllRolesByName(@Param("name") String name);
}
