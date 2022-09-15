package com.example.dms.service.impl;

import com.example.dms.dao.SupplierRepository;
import com.example.dms.mapper.SupplierMapper;
import com.example.dms.mapper.impl.SupplierMapperImpl;
import com.example.dms.service.SupplierService;
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
    void canFindAll() {
        //when
        underTest.findAll();
        //then
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void deleteById() {
    }

    @Test
    @Disabled
    void updateById() {
    }

    @Test
    @Disabled
    void updateContractExpiresById() {
    }

    @Test
    @Disabled
    void getSupplierEntityById() {
    }

    @Test
    @Disabled
    void findAllWithContractSignedOn() {
    }

    @Test
    @Disabled
    void findAllWithContractExpiresOn() {
    }
}