package com.pharma.dms.service.impl;

import com.pharma.dms.dao.FacilityRepository;
import com.pharma.dms.mapper.FacilityMapper;
import com.pharma.dms.mapper.impl.FacilityMapperImpl;
import com.pharma.dms.service.AddressService;
import com.pharma.dms.service.FacilityService;
import com.pharma.dms.service.InventoryService;
import com.pharma.dms.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FacilityServiceImplTest {
    @Mock private FacilityRepository facilityRepository;
    private FacilityService underTest;
    private FacilityMapper mapper = new FacilityMapperImpl();
    @Mock private AddressService addressService;
    @Mock private  InventoryService inventoryService;
    @Mock private  OrdersService ordersService;

    @BeforeEach
    void setUp() {
        underTest = new FacilityServiceImpl(facilityRepository, mapper, addressService,inventoryService,ordersService);
    }


    @Test
    void canFindAllFacilities() {
        //when
        underTest.findAll();
        //then
        verify(facilityRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void canCreateFacility() {
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
    void canGetFacilityEntityById() {
    }
}