package com.pharma.dms.mapper;

import com.pharma.dms.dto.ProductTypeRequest;
import com.pharma.dms.dto.ProductTypeResponse;
import com.pharma.dms.model.ProductTypeEntity;

import java.util.List;

public interface ProductTypeMapper {

    ProductTypeEntity dtoToEntity(final ProductTypeRequest productTypeRequest);

    ProductTypeResponse entityToDto(final ProductTypeEntity persistedProductTypeEntity);

    List<ProductTypeResponse> entitiesToDto(final List<ProductTypeEntity> productTypeEntityList);

    void updateProductType(final ProductTypeRequest productTypeRequest, final ProductTypeEntity productTypeEntity);

}
