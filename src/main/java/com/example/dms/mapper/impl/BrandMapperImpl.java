package com.example.dms.mapper.impl;

import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandResponse;
import com.example.dms.mapper.BrandMapper;
import com.example.dms.model.BrandEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrandMapperImpl implements BrandMapper {
    @Override
    public BrandEntity dtoToEntity(@NotNull final BrandRequest brandRequest) {
        final BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandName(brandRequest.getBrandName());
        brandEntity.setBrandDesc(brandRequest.getBrandDesc());
        brandEntity.setEmail(brandRequest.getEmail());
        brandEntity.setWebsite(brandRequest.getWebsite());
        brandEntity.setPhoneNumber(brandRequest.getPhoneNumber());
        return brandEntity;
    }

    @Override
    public BrandResponse entityToDto(final @NotNull BrandEntity persistedBrandEntity) {
        final BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(persistedBrandEntity.getId());
        brandResponse.setBrandName(persistedBrandEntity.getBrandName());
        brandResponse.setBrandDesc(persistedBrandEntity.getBrandDesc());
        brandResponse.setEmail(persistedBrandEntity.getEmail());
        brandResponse.setPhoneNumber(persistedBrandEntity.getPhoneNumber());
        brandResponse.setWebsite(persistedBrandEntity.getWebsite());
        brandResponse.setCreatedAt(persistedBrandEntity.getCreatedAt());
        return brandResponse;
    }

    @Override
    public List<BrandResponse> entitiesToDto(final @NotNull List<BrandEntity> brandEntities) {
        List<BrandResponse> brandResponseList = new ArrayList<>();
        for(BrandEntity brandEntity : brandEntities) {
            brandResponseList.add(entityToDto(brandEntity));
        }
        return brandResponseList;
    }

    @Override
    public void updateBrand(final @NotNull BrandRequest brandRequest, final @NotNull BrandEntity brandEntity) {
        brandEntity.setBrandName(brandRequest.getBrandName());
        brandEntity.setBrandDesc(brandRequest.getBrandDesc());
        brandEntity.setPhoneNumber(brandRequest.getPhoneNumber());
        brandEntity.setWebsite(brandRequest.getWebsite());
        brandEntity.setEmail(brandRequest.getEmail());
    }
}
