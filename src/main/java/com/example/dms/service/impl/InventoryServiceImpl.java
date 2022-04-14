package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final String AUTHOR = "Muki";


    private final InventoryRepository inventoryRepository;
    private final BrandService brandService;
    private final InventoryMapper inventoryMapper;

    public InventoryServiceImpl(final InventoryRepository inventoryRepository, final BrandService brandService, final InventoryMapper inventoryMapper) {
        this.inventoryRepository = Objects.requireNonNull(inventoryRepository, "inventoryRepository cannot be null");
        this.brandService = Objects.requireNonNull(brandService, "brandService cannot be null");
        this.inventoryMapper = Objects.requireNonNull(inventoryMapper, "inventoryMapper cannot be null");
    }

    @Override
    public InventoryResponse create(final InventoryRequest inventoryRequest, final Long brandId) {
        final InventoryEntity inventoryEntity = inventoryMapper.dtoToEntity(inventoryRequest);
        inventoryEntity.setCreatedAt(LocalDateTime.now());
        inventoryEntity.setCreatedBy(AUTHOR);
        inventoryEntity.setExpiryDate(LocalDateTime.from(LocalDateTime.now()).plusYears(2));
        final BrandEntity brandEntity = brandService.getBrandEntityById(brandId);
        inventoryEntity.setBrandEntity(brandEntity);
        final InventoryEntity persistedInventoryEntity = inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(persistedInventoryEntity);
    }
}
