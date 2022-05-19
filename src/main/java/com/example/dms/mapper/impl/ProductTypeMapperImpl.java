package com.example.dms.mapper.impl;

import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeResponse;
import com.example.dms.mapper.ProductTypeMapper;
import com.example.dms.model.ProductTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        final List<ProductTypeResponse> productTypeResponses = new ArrayList<>();
        for (ProductTypeEntity productTypeEntity : productTypeEntityList) {
            productTypeResponses.add(entityToDto(productTypeEntity));
        }
        return productTypeResponses;
    }

    @Override
    public void updateProductType(final @NotNull ProductTypeRequest productTypeRequest, final @NotNull ProductTypeEntity productTypeEntity) {
        productTypeEntity.setProductType(productTypeRequest.getProductType());
        productTypeEntity.setProductTypeDesc(productTypeRequest.getProductTypeDesc());
    }
}
