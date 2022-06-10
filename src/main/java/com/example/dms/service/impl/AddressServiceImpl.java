package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressRequestPatch;
import com.example.dms.dto.AddressResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.model.AddressEntity;
import com.example.dms.service.AddressService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    public static final String AUTHOR = "Muki";
    public static final String ADDRESS_DOES_NOT_EXIST = "Address with id: {0} does not exist.";

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public AddressServiceImpl(final AddressMapper addressMapper, final AddressRepository addressRepository) {
        this.addressMapper = Objects.requireNonNull(addressMapper, "addressMapper cannot be null");
        this.addressRepository = Objects.requireNonNull(addressRepository, "addressRepository cannot be null");
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
        return addressMapper.entitiesToDto(addressEntities);
    }

    @Override
    public AddressResponse findById(final Long id) {
        final AddressEntity addressEntity = getAddressEntityById(id);
        return addressMapper.entityToDto(addressEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(ADDRESS_DOES_NOT_EXIST, id));
        }
        addressRepository.deleteById(id);
    }

    @Override
    public AddressResponse updateById(final Long id, final AddressRequest addressRequest) {
        final AddressEntity addressEntity = getAddressEntityById(id);
        addressMapper.updateAddress(addressRequest, addressEntity);
        addressEntity.setModifiedBy(AUTHOR);
        addressEntity.setModifiedAt(LocalDateTime.now());
        final AddressEntity updateAddressEntity = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(updateAddressEntity);
    }

    @Override
    public AddressResponse updateStreetAndBuildingNumberById(
            final Long id,
            final @NotNull AddressRequestPatch addressRequestPatch
    ) {
        final AddressEntity addressEntity = getAddressEntityById(id);
        addressEntity.setStreet(addressRequestPatch.setStreet(addressRequestPatch.getStreet()));
        addressEntity.setBuildingNumber(addressRequestPatch.setBuildingNumber(addressRequestPatch.getBuildingNumber()));
        addressEntity.setModifiedBy(AUTHOR);
        addressEntity.setModifiedAt(LocalDateTime.now());
        final AddressEntity updateAddressEntity = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(updateAddressEntity);
    }

    @NotNull
    public AddressEntity getAddressEntityById(final Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(ADDRESS_DOES_NOT_EXIST, id)));
    }

    @Override
    public List<AddressResponse> findAddressesInTheSameCity(final String city) {
        final List<AddressEntity> responseList = addressRepository.findAddressesInTheSameCity(city);
        return addressMapper.entitiesToDto(responseList);
    }
}
