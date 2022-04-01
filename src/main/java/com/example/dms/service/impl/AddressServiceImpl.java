package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.model.AddressEntity;
import com.example.dms.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

private final AddressMapper addressMapper;
private final AddressRepository addressRepository;

    public AddressServiceImpl(final AddressMapper addressMapper, final AddressRepository addressRepository) {
        this.addressMapper = Objects.requireNonNull(addressMapper, "addressMapper cannot be null");
        this.addressRepository = Objects.requireNonNull(addressRepository,"addressRepository cannot be null");
    }

    @Override
    public AddressResponse create(final AddressRequest addressRequest) {
        final AddressEntity addressEntity = addressMapper.dtoToEntity(addressRequest);
        final AddressEntity persistedAddressEntity = addressRepository.save(addressEntity);
        final AddressResponse addressResponse = addressMapper.entityToDto(persistedAddressEntity);
        return addressResponse;
    }

    @Override
    public List<AddressResponse> getAll() {
        return null;
    }

    @Override
    public AddressResponse getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public AddressResponse updateById(Long id, AddressRequest addressRequest) {
        return null;
    }

    @Override
    public AddressResponse updateStreetAndBuildingNumberById(Long id, String buildingNumber, String street) {
        return null;
    }
}
