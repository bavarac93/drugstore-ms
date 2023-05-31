package com.pharma.dms.service.impl;

import com.pharma.dms.dao.BrandRepository;
import com.pharma.dms.dto.BrandRequest;
import com.pharma.dms.dto.BrandResponse;
import com.pharma.dms.mapper.BrandMapper;
import com.pharma.dms.mapper.impl.BrandMapperImpl;
import com.pharma.dms.model.BrandEntity;
import com.pharma.dms.service.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setBrandName("Zada Pharm");
        brandRequest.setEmail("zada@gmail.com");
        brandRequest.setBrandDesc("A company that comes from Tuzla.");
        brandRequest.setWebsite("www.zada.ba");
        brandRequest.setPhoneNumber("035895231");
    }


    @Test
    void canFindAllBrands() {
        //when
        underTest.findAll();
        //then
        verify(brandRepository, times(1)).findAll();
    }

    @Test
    void canCreateBrand() {
        // Given
        BrandRequest brandRequest = new BrandRequest();

        // When
        Mockito.when(brandRepository.save(Mockito.any(BrandEntity.class))).thenReturn(mapper.dtoToEntity(brandRequest));
        underTest.create(brandRequest);

        // Then
        ArgumentCaptor<BrandEntity> brandEntityArgumentCaptor = ArgumentCaptor.forClass(BrandEntity.class);
        Mockito.verify(brandRepository).save(brandEntityArgumentCaptor.capture());

        BrandEntity brandEntity = brandEntityArgumentCaptor.getValue();
        assertThat(brandEntity.getBrandName()).isEqualTo(brandRequest.getBrandName());
        assertThat(brandEntity.getBrandDesc()).isEqualTo(brandRequest.getBrandDesc());
        assertThat(brandEntity.getEmail()).isEqualTo(brandRequest.getEmail());
        assertThat(brandEntity.getWebsite()).isEqualTo(brandRequest.getWebsite());
        assertThat(brandEntity.getPhoneNumber()).isEqualTo(brandRequest.getPhoneNumber());
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
    void canUpdateBrandDescById() {
    }

    @Test
    void canFindAllBrandsBySomeName() {
        //given
        String brand = "Zenica";

        //when
        List<BrandResponse> responseList = underTest.findAllBrandsBySomeName(brand);

        //then
        Mockito.verify(brandRepository, Mockito.times(1)).findAllBrandsBySomeName(brand);
    }

    @Test
    @Disabled
    void canGetBrandEntityById() {
    }
}