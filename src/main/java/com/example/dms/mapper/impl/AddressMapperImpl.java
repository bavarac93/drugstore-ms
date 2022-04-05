package com.example.dms.mapper.impl;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.model.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity dtoToEntity(final AddressRequest addressRequest) {
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber(addressRequest.getBuildingNumber());
        addressEntity.setCity(addressRequest.getCity());
        addressEntity.setCountry(addressRequest.getCountry());
        addressEntity.setPostcode(addressRequest.getPostcode());
        addressEntity.setStreet(addressRequest.getStreet());
        return addressEntity;
    }

    @Override
    public AddressResponse entityToDto(final AddressEntity addressEntity) {
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
    public List<AddressResponse> entityToDto(final List<AddressEntity> addressEntities) {
        final List<AddressResponse> responseList = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities) {
            responseList.add(entityToDto(addressEntity));
        }
        return responseList;
    }

    @Override
    public void updateAddress(AddressRequest addressRequest, AddressEntity addressEntity) {
        addressEntity.setCity(addressRequest.getCity());
        addressEntity.setStreet(addressRequest.getStreet());
        addressEntity.setPostcode(addressRequest.getPostcode());
        addressEntity.setBuildingNumber(addressRequest.getBuildingNumber());
        addressEntity.setCountry(addressRequest.getCountry());
    }
}
