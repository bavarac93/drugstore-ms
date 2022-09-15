package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.mapper.impl.AddressMapperImpl;
import com.example.dms.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {
    @Mock private AddressRepository addressRepository;
    private AddressService underTest;
    private AddressMapper mapper = new AddressMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new AddressServiceImpl(mapper, addressRepository);
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    void canFindAllAddresses() {
        //when
        underTest.findAll();
        //then
        verify(addressRepository, times(1)).findAll();
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
    void updateStreetAndBuildingNumberById() {
    }

    @Test
    @Disabled
    void getAddressEntityById() {
    }

    @Test
    @Disabled
    void findAddressesInTheSameCity() {
    }
}