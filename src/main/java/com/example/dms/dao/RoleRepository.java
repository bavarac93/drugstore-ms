package com.example.dms.dao;

import com.example.dms.security.Role;
import com.example.dms.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(final String name);
}
