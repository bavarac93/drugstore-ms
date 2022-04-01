package com.example.dms.mapper;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.model.AddressEntity;

public interface AddressMapper {
     AddressEntity dtoToEntity(AddressRequest addressRequest);

     AddressResponse entityToDto(AddressEntity persistedAddressEntity);
}
