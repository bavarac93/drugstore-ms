package com.example.dms.mapper;

import com.example.dms.dto.FacilityRequest;
import com.example.dms.dto.FacilityResponse;
import com.example.dms.model.FacilityEntity;

import java.util.List;

public interface FacilityMapper {
    FacilityEntity dtoToEntity(final FacilityRequest facilityRequest);

    FacilityResponse entityToDto(final FacilityEntity persistedFacilityEntity);

    List<FacilityResponse> entitiesToDto(final List<FacilityEntity> facilityEntityList);
}
