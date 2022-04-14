package com.example.dms.mapper;


import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandResponse;
import com.example.dms.model.BrandEntity;

public interface BrandMapper {
    BrandEntity dtoToEntity(final BrandRequest brandRequest);

    BrandResponse entityToDto(final BrandEntity persistedBrandEntity);
}
