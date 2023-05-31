package com.pharma.dms.mapper.impl;

import com.pharma.dms.dto.ProductTypeRequest;
import com.pharma.dms.dto.ProductTypeResponse;
import com.pharma.dms.mapper.ProductTypeMapper;
import com.pharma.dms.model.ProductTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductTypeMapperImpl implements ProductTypeMapper {
    @Override
    public ProductTypeEntity dtoToEntity(final @NotNull ProductTypeRequest productTypeRequest) {
        final ProductTypeEntity productTypeEntity = new ProductTypeEntity();
        productTypeEntity.setProductType(productTypeRequest.getProductType());
        productTypeEntity.setProductTypeDesc(productTypeRequest.getProductTypeDesc());
        return productTypeEntity;
    }

    @Override
    public ProductTypeResponse entityToDto(final @NotNull ProductTypeEntity persistedProductTypeEntity) {
        final ProductTypeResponse productTypeResponse = new ProductTypeResponse();
        productTypeResponse.setId(persistedProductTypeEntity.getId());
        productTypeResponse.setProductType(persistedProductTypeEntity.getProductType());
        productTypeResponse.setProductTypeDesc(persistedProductTypeEntity.getProductTypeDesc());
        productTypeResponse.setCreatedAt(persistedProductTypeEntity.getCreatedAt());
        return productTypeResponse;
    }

    @Override
    public List<ProductTypeResponse> entitiesToDto(final @NotNull List<ProductTypeEntity> productTypeEntityList) {
        return productTypeEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateProductType(final @NotNull ProductTypeRequest productTypeRequest, final @NotNull ProductTypeEntity productTypeEntity) {
        productTypeEntity.setProductType(productTypeRequest.getProductType());
        productTypeEntity.setProductTypeDesc(productTypeRequest.getProductTypeDesc());
    }
}
