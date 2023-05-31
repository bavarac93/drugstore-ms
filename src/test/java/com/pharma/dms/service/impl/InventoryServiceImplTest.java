package com.pharma.dms.service.impl;

import com.pharma.dms.dao.InventoryRepository;
import com.pharma.dms.dto.InventoryResponse;
import com.pharma.dms.mapper.InventoryMapper;
import com.pharma.dms.mapper.impl.InventoryMapperImpl;
import com.pharma.dms.service.BrandService;
import com.pharma.dms.service.InventoryService;
import com.pharma.dms.service.ProductTypeService;
import com.pharma.dms.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
    void canCreateInventoryItems() {
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
    void canUpdateDescriptionById() {
    }

    @Test
    @Disabled
    void canGetInventoryEntityById() {
    }

    @Test
    @Disabled
    void canFindAllWithExpiryTimeBefore() {
    }

    @Test
    @Disabled
    void canFindItemsMadeByTheSameBrand() {
    }

    @Test
    @Disabled
    void canCountItemsMadeByTheSameBrand() {
    }

    @Test
    @Disabled
    void canFindItemsOfTheSameType() {
    }

    @Test
    @Disabled
    void canFindItemsFromTheSameSupplier() {
        //given
        String name = "Item";

        //when
        List<InventoryResponse> responseList = underTest.findItemByName(name);

        //then
        Mockito.verify(inventoryRepository, Mockito.times(1)).findItemByName(name);
    }

    @Test
    @Disabled
    void canCountItemsOfTheSameType() {
    }

    @Test
    @Disabled
    void canCountItemsFromTheSameSupplier() {
    }

    @Test
    void canFindItemByName() {
        //given
        String name = "Item";

        //when
        List<InventoryResponse> responseList = underTest.findItemByName(name);

        //then
        Mockito.verify(inventoryRepository, Mockito.times(1)).findItemByName(name);
    }
}