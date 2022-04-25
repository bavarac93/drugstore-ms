package com.example.dms.dao;


import com.example.dms.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT t FROM AddressEntity t WHERE t.city = :city")
    List<AddressEntity> findAddressesInTheSameCity(@Param("city") final String city);

}
