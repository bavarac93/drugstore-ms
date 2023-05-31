package com.pharma.dms.mapper;

import com.pharma.dms.dto.AddressRequest;
import com.pharma.dms.dto.AddressResponse;
import com.pharma.dms.model.AddressEntity;

import java.util.List;

public interface AddressMapper {
    AddressEntity dtoToEntity(final AddressRequest addressRequest);

    AddressResponse entityToDto(final AddressEntity persistedAddressEntity);

    List<AddressResponse> entitiesToDto(final List<AddressEntity> addressEntities);

    void updateAddress(final AddressRequest addressRequest, final AddressEntity addressEntity);
}
