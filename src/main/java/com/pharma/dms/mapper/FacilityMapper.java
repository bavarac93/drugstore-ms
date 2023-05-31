package com.pharma.dms.mapper;

import com.pharma.dms.dto.FacilityRequest;
import com.pharma.dms.dto.FacilityResponse;
import com.pharma.dms.model.FacilityEntity;

import java.util.List;

public interface FacilityMapper {
    FacilityEntity dtoToEntity(final FacilityRequest facilityRequest);

    FacilityResponse entityToDto(final FacilityEntity persistedFacilityEntity);

    List<FacilityResponse> entitiesToDto(final List<FacilityEntity> facilityEntityList);
}
