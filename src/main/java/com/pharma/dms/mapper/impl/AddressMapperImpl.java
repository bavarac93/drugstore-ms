package com.pharma.dms.mapper.impl;

import com.pharma.dms.dto.AddressRequest;
import com.pharma.dms.dto.AddressResponse;
import com.pharma.dms.mapper.AddressMapper;
import com.pharma.dms.model.AddressEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressMapperImpl implements AddressMapper {
    @Override
    public AddressEntity dtoToEntity(final @NotNull AddressRequest addressRequest) {
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber(addressRequest.getBuildingNumber());
        addressEntity.setCity(addressRequest.getCity());
        addressEntity.setCountry(addressRequest.getCountry());
        addressEntity.setPostcode(addressRequest.getPostcode());
        addressEntity.setStreet(addressRequest.getStreet());
        return addressEntity;
    }

    @Override
    public AddressResponse entityToDto(final @NotNull AddressEntity addressEntity) {
        final AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressEntity.getId());
        addressResponse.setCity(addressEntity.getCity());
        addressResponse.setBuildingNumber(addressEntity.getBuildingNumber());
        addressResponse.setStreet(addressEntity.getStreet());
        addressResponse.setCountry(addressEntity.getCountry());
        addressResponse.setPostcode(addressEntity.getPostcode());
        addressResponse.setCreatedAt(addressEntity.getCreatedAt());
        return addressResponse;
    }

    @Override
    public List<AddressResponse> entitiesToDto(final @NotNull List<AddressEntity> addressEntities) {
        return addressEntities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateAddress(@NotNull final AddressRequest addressRequest, @NotNull final AddressEntity addressEntity) {
        addressEntity.setCity(addressRequest.getCity());
        addressEntity.setStreet(addressRequest.getStreet());
        addressEntity.setPostcode(addressRequest.getPostcode());
        addressEntity.setBuildingNumber(addressRequest.getBuildingNumber());
        addressEntity.setCountry(addressRequest.getCountry());
    }
}
