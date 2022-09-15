package com.example.dms.service.impl;

import com.example.dms.dao.ProductTypeRepository;
import com.example.dms.mapper.ProductTypeMapper;
import com.example.dms.mapper.impl.ProductTypeMapperImpl;
import com.example.dms.service.ProductTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductTypeServiceImplTest {
    @Mock
    private ProductTypeRepository productTypeRepository;
    private ProductTypeService underTest;
    private ProductTypeMapper mapper = new ProductTypeMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new ProductTypeServiceImpl(productTypeRepository, mapper);
    }

    @Test
    void canFindAllOrders() {
        //when
        underTest.findAll();
        //then
        verify(productTypeRepository, times(1)).findAll();
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
    void updateProductTypeDescById() {
    }

    @Test
    @Disabled
    void getProductTypeEntityById() {
    }
}