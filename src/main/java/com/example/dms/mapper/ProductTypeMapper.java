package com.example.dms.mapper;

import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeResponse;
import com.example.dms.model.ProductTypeEntity;

import java.util.List;

public interface ProductTypeMapper {

    ProductTypeEntity dtoToEntity(final ProductTypeRequest productTypeRequest);

    ProductTypeResponse entityToDto(final ProductTypeEntity persistedProductTypeEntity);

    List<ProductTypeResponse> entitiesToDto(final List<ProductTypeEntity> productTypeEntityList);

    void updateProductType(final ProductTypeRequest productTypeRequest, final ProductTypeEntity productTypeEntity);

}
