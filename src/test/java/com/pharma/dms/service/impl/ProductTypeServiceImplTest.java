package com.pharma.dms.service.impl;

import com.pharma.dms.dao.ProductTypeRepository;
import com.pharma.dms.dto.ProductTypeRequest;
import com.pharma.dms.mapper.ProductTypeMapper;
import com.pharma.dms.mapper.impl.ProductTypeMapperImpl;
import com.pharma.dms.model.ProductTypeEntity;
import com.pharma.dms.service.ProductTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        ProductTypeRequest productTypeRequest = new ProductTypeRequest();
        productTypeRequest.setProductType("medicine");
        productTypeRequest.setProductTypeDesc("Used for inflammation");
    }

    @Test
    void canFindAllProductTypes() {
        //when
        underTest.findAll();
        //then
        verify(productTypeRepository, times(1)).findAll();
    }

    @Test
    void canCreateProductType() {
        // Given
        ProductTypeRequest productTypeRequest = new ProductTypeRequest();

        // When
        Mockito.when(productTypeRepository.save(Mockito.any(ProductTypeEntity.class))).thenReturn(mapper.dtoToEntity(productTypeRequest));
        underTest.create(productTypeRequest);

        // Then
        ArgumentCaptor<ProductTypeEntity> productTypeEntityArgumentCaptor = ArgumentCaptor.forClass(ProductTypeEntity.class);
        Mockito.verify(productTypeRepository).save(productTypeEntityArgumentCaptor.capture());

        ProductTypeEntity productTypeEntity = productTypeEntityArgumentCaptor.getValue();
        assertThat(productTypeEntity.getProductType()).isEqualTo(productTypeRequest.getProductType());
        assertThat(productTypeEntity.getProductTypeDesc()).isEqualTo(productTypeRequest.getProductTypeDesc());
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
    void canUpdateProductTypeDescById() {
    }

    @Test
    @Disabled
    void canGetProductTypeEntityById() {
    }
}