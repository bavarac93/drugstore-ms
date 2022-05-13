package com.example.dms.dao;

import com.example.dms.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("SELECT t FROM CustomerEntity t WHERE t.isVerified = true")
    List<CustomerEntity> findVerifiedCustomers();

    @Query("SELECT t FROM CustomerEntity t WHERE t.drugAllergicTo = :drugAllergicTo")
    List<CustomerEntity> listAllergicCustomers(@Param("drugAllergicTo") final String drugAllergicTo);

    @Query("SELECT COUNT(t) FROM CustomerEntity t WHERE UPPER(t.drugAllergicTo) = :drugAllergicTo")
    int countAllergicCustomersToSomeMedication(@Param("drugAllergicTo") final String drugAllergicTo);

    CustomerEntity findByEmail(final String email);

}
