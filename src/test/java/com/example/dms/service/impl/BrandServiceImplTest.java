package com.example.dms.service.impl;

import com.example.dms.dao.BrandRepository;
import com.example.dms.mapper.BrandMapper;
import com.example.dms.mapper.impl.BrandMapperImpl;
import com.example.dms.service.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {
    @Mock
    private BrandRepository brandRepository;
    private BrandService underTest;
    private BrandMapper mapper = new BrandMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new BrandServiceImpl(brandRepository, mapper);
    }


    @Test
    void canFindAllBrands() {
        //when
        underTest.findAll();
        //then
        verify(brandRepository, times(1)).findAll();
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
    void updateBrandDescById() {
    }

    @Test
    @Disabled
    void findAllBrandsBySomeName() {
    }

    @Test
    @Disabled
    void getBrandEntityById() {
    }
}