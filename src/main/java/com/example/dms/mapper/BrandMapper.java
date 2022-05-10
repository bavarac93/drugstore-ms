package com.example.dms.mapper;


import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandResponse;
import com.example.dms.model.BrandEntity;

import java.util.List;

public interface BrandMapper {
    BrandEntity dtoToEntity(final BrandRequest brandRequest);

    BrandResponse entityToDto(final BrandEntity persistedBrandEntity);

    List<BrandResponse> entitiesToDto(final List<BrandEntity> brandEntities);

    void updateBrand(final BrandRequest brandRequest, final BrandEntity brandEntity);
}
