package com.pharma.dms.service.impl;

import com.pharma.dms.dao.FacilityRepository;
import com.pharma.dms.mapper.FacilityMapper;
import com.pharma.dms.dto.FacilityRequest;
import com.pharma.dms.dto.FacilityResponse;
import com.pharma.dms.exception.ApiRequestException;
import com.pharma.dms.model.AddressEntity;
import com.pharma.dms.model.FacilityEntity;
import com.pharma.dms.model.InventoryEntity;
import com.pharma.dms.model.OrdersEntity;
import com.pharma.dms.service.AddressService;
import com.pharma.dms.service.FacilityService;
import com.pharma.dms.service.InventoryService;
import com.pharma.dms.service.OrdersService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class FacilityServiceImpl implements FacilityService {
    public static final String AUTHOR = "Muki";
    private static final String FACILITY_DOES_NOT_EXIST = "Facility with id: {0} does not exist.";


    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;
    private final AddressService addressService;
    private final InventoryService inventoryService;
    private final OrdersService ordersService;

    public FacilityServiceImpl(
            final FacilityRepository facilityRepository,
            final FacilityMapper facilityMapper,
            final AddressService addressService,
            final InventoryService inventoryService,
            final OrdersService ordersService) {
        this.facilityRepository = Objects.requireNonNull(facilityRepository, "facilityRepository cannot be null");
        this.facilityMapper = Objects.requireNonNull(facilityMapper, "facilityMapper cannot be null");
        this.addressService = Objects.requireNonNull(addressService, "addressService cannot be null");
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService cannot be null");
        this.ordersService = Objects.requireNonNull(ordersService, "ordersService cannot be null");
    }

    @Override
    public FacilityResponse create(final FacilityRequest facilityRequest) {
        final FacilityEntity facilityEntity = facilityMapper.dtoToEntity(facilityRequest);
        facilityEntity.setCreatedAt(LocalDateTime.now());
        facilityEntity.setCreatedBy(AUTHOR);
        final AddressEntity addressEntity = addressService.getAddressEntityById(facilityRequest.getAddressId());
        facilityEntity.setAddressEntity(addressEntity);
        final InventoryEntity inventoryEntity = inventoryService.getInventoryEntityById(facilityRequest.getInventoryId());
        facilityEntity.setInventoryEntity(inventoryEntity);
        final OrdersEntity ordersEntity = ordersService.getOrdersEntityById(facilityRequest.getOrdersId());
        facilityEntity.setOrdersEntity(ordersEntity);
        final FacilityEntity persistedFacilityEntity = facilityRepository.save(facilityEntity);
        return facilityMapper.entityToDto(persistedFacilityEntity);
    }

    @Override
    public FacilityResponse findById(final Long id) {
        final FacilityEntity facilityEntity = getFacilityEntityById(id);
        return facilityMapper.entityToDto(facilityEntity);
    }

    @Override
    public List<FacilityResponse> findAll() {
        final List<FacilityEntity> facilityEntityList = facilityRepository.findAll();
        return facilityMapper.entitiesToDto(facilityEntityList);
    }

    @Override
    public void deleteById(final Long id) {
        if (!facilityRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(FACILITY_DOES_NOT_EXIST, id));
        }
        facilityRepository.deleteById(id);
    }

    public @NotNull FacilityEntity getFacilityEntityById(final Long id) {
        return facilityRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(FACILITY_DOES_NOT_EXIST, id)));
    }
}
