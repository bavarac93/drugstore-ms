package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.mapper.impl.InventoryMapperImpl;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import com.example.dms.service.ProductTypeService;
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
class InventoryServiceImplTest {
    @Mock private InventoryRepository inventoryRepository;
    private InventoryService underTest;
    private InventoryMapper mapper = new InventoryMapperImpl();
    @Mock private  BrandService brandService;
    @Mock private  ProductTypeService productTypeService;
    @Mock private  SupplierService supplierService;

    @BeforeEach
    void setUp() {
        underTest = new InventoryServiceImpl(inventoryRepository, brandService, mapper, productTypeService, supplierService);
    }

    @Test
    void canFindAllInventoryItems() {
        //when
        underTest.findAll();
        //then
        verify(inventoryRepository, times(1)).findAll();
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
    void findAll() {
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
    void updateDescriptionById() {
    }

    @Test
    @Disabled
    void getInventoryEntityById() {
    }

    @Test
    @Disabled
    void findAllWithExpiryTimeBefore() {
    }

    @Test
    @Disabled
    void findItemsMadeByTheSameBrand() {
    }

    @Test
    @Disabled
    void countItemsMadeByTheSameBrand() {
    }

    @Test
    @Disabled
    void findItemsOfTheSameType() {
    }

    @Test
    @Disabled
    void findItemsFromTheSameSupplier() {
    }

    @Test
    @Disabled
    void countItemsOfTheSameType() {
    }

    @Test
    @Disabled
    void countItemsFromTheSameSupplier() {
    }

    @Test
    @Disabled
    void findItemByName() {
    }
}