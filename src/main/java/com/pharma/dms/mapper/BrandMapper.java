package com.pharma.dms.mapper;


import com.pharma.dms.dto.BrandResponse;
import com.pharma.dms.dto.BrandRequest;
import com.pharma.dms.model.BrandEntity;

import java.util.List;

public interface BrandMapper {
    BrandEntity dtoToEntity(final BrandRequest brandRequest);

    BrandResponse entityToDto(final BrandEntity persistedBrandEntity);

    List<BrandResponse> entitiesToDto(final List<BrandEntity> brandEntities);

    void updateBrand(final BrandRequest brandRequest, final BrandEntity brandEntity);
}
