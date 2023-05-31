package com.pharma.dms.service.impl;

import com.pharma.dms.dao.SupplierRepository;
import com.pharma.dms.mapper.SupplierMapper;
import com.pharma.dms.mapper.impl.SupplierMapperImpl;
import com.pharma.dms.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {
    @Mock
    private SupplierRepository supplierRepository;
    private SupplierService underTest;
    private SupplierMapper mapper = new SupplierMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new SupplierServiceImpl(supplierRepository, mapper);
    }

    @Test
    void canFindAllSuppliers() {
        //when
        underTest.findAll();
        //then
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void canCreateSupplier() {
    }

    @Test
    @Disabled
    void canFindById() {
    }

    @Test
    @Disabled
    void canDeleteById() {
    }

    @Test
    @Disabled
    void canUpdateById() {
    }

    @Test
    @Disabled
    void canUpdateContractExpiresById() {
    }

    @Test
    @Disabled
    void canGetSupplierEntityById() {
    }

    @Test
    @Disabled
    void canFindAllWithContractSignedOn() {
    }

    @Test
    @Disabled
    void canFindAllWithContractExpiresOn() {
    }
}