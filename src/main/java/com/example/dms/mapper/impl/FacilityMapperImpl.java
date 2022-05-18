package com.example.dms.mapper.impl;

import com.example.dms.dto.FacilityRequest;
import com.example.dms.dto.FacilityResponse;
import com.example.dms.mapper.FacilityMapper;
import com.example.dms.model.FacilityEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityMapperImpl implements FacilityMapper {
    @Override
    public FacilityEntity dtoToEntity(final @NotNull FacilityRequest facilityRequest) {
        final FacilityEntity facilityEntity = new FacilityEntity();
        facilityEntity.setFacilityName(facilityRequest.getFacilityName());
        facilityEntity.setEmail(facilityRequest.getEmail());
        facilityEntity.setWebsite(facilityRequest.getWebsite());
        facilityEntity.setPhoneNumber(facilityRequest.getPhoneNumber());
        facilityEntity.setDateOpened(facilityRequest.getDateOpened());
        return facilityEntity;
    }

    @Override
    public FacilityResponse entityToDto(final @NotNull FacilityEntity persistedFacilityEntity) {
        final FacilityResponse facilityResponse = new FacilityResponse();
        facilityResponse.setId(persistedFacilityEntity.getId());
        facilityResponse.setFacilityName(persistedFacilityEntity.getFacilityName());
        facilityResponse.setEmail(persistedFacilityEntity.getEmail());
        facilityResponse.setPhoneNumber(persistedFacilityEntity.getPhoneNumber());
        facilityResponse.setWebsite(persistedFacilityEntity.getWebsite());
        facilityResponse.setDateOpened(persistedFacilityEntity.getDateOpened());
        facilityResponse.setAddressId(persistedFacilityEntity.getAddressEntity().getId());
        facilityResponse.setInventoryId(persistedFacilityEntity.getInventoryEntity().getId());
        facilityResponse.setOrdersId(persistedFacilityEntity.getOrdersEntity().getId());
        facilityResponse.setCreatedAt(persistedFacilityEntity.getCreatedAt());
        return facilityResponse;
    }

    @Override
    public List<FacilityResponse> entitiesToDto(final @NotNull List<FacilityEntity> facilityEntityList) {
        final List<FacilityResponse > facilityResponseList = new ArrayList<>();
        for (FacilityEntity facilityEntity : facilityEntityList) {
            facilityResponseList.add(entityToDto(facilityEntity));
        }
        return facilityResponseList;
    }
}
