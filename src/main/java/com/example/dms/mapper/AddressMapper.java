package com.example.dms.mapper;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.model.AddressEntity;

import java.util.List;

public interface AddressMapper {
     AddressEntity dtoToEntity(final AddressRequest addressRequest);

     AddressResponse entityToDto(final AddressEntity persistedAddressEntity);

     List<AddressResponse> entitiesToDto(final List<AddressEntity> addressEntities);

     void updateAddress(final AddressRequest addressRequest, final AddressEntity addressEntity);
}
