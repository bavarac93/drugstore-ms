package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.model.AddressEntity;
import com.example.dms.service.AddressService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    public static final String AUTHOR = "Muki";

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(final AddressMapper addressMapper, final AddressRepository addressRepository) {
        this.addressMapper = Objects.requireNonNull(addressMapper, "addressMapper cannot be null");
        this.addressRepository = Objects.requireNonNull(addressRepository,"addressRepository cannot be null");
    }

    @Override
    public AddressResponse create(final AddressRequest addressRequest) {
        final AddressEntity addressEntity = addressMapper.dtoToEntity(addressRequest);
        addressEntity.setCreatedBy(AUTHOR);
        addressEntity.setCreatedAt(LocalDateTime.now());
        final AddressEntity persistedContactEntity = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(persistedContactEntity);
    }

    @Override
    public List<AddressResponse> findAll() {
        final List<AddressEntity> addressEntities = addressRepository.findAll();
        return addressMapper.entityToDto(addressEntities);
    }

    @Override
    public AddressResponse findById(final Long id) {
        final Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(id);
        if (optionalAddressEntity.isEmpty()) {
            throw new ApiRequestException("Address with id: " + id + " does not exist.");
        }
        final AddressEntity addressEntity = optionalAddressEntity.get();
        return addressMapper.entityToDto(addressEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ApiRequestException("Address with this id: " + id + " does not exist.");
        }
        addressRepository.deleteById(id);
    }

    @Override
    public  AddressResponse updateById(final Long id, final AddressRequest addressRequest) {
        if (!addressRepository.existsById(id)) {
            throw new ApiRequestException("Address with this id: " + id + " does not exist.");
        }
        final AddressEntity addressEntity = addressRepository.findById(id).get();
        addressMapper.updateAddress(addressRequest, addressEntity);
        addressEntity.setModifiedBy(AUTHOR);
        addressEntity.setModifiedAt(LocalDateTime.now());
        final AddressEntity updateAddressEntity = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(updateAddressEntity);
    }

    @Override
    public AddressResponse updateStreetAndBuildingNumberById(final Long id, final String buildingNumber, final String street) {
        if (!addressRepository.existsById(id)) {
            throw new ApiRequestException("Address with id: " + id + " does not exist.");
        }
        final AddressEntity addressEntity = addressRepository.findById(id).get();
        addressEntity.setStreet(street);
        addressEntity.setBuildingNumber(buildingNumber);
        addressEntity.setModifiedBy(AUTHOR);
        addressEntity.setModifiedAt(LocalDateTime.now());
        final AddressEntity updateAddressEntity = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(updateAddressEntity);
    }


}
