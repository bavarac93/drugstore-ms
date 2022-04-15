package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final String AUTHOR = "Muki";
    private static final String ITEM_DOES_NOT_EXIST = "Item with id: {0} does not exist.";


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
        final BrandEntity brandEntity = brandService.getBrandEntityById(brandId);
        inventoryEntity.setBrandEntity(brandEntity);
        final InventoryEntity persistedInventoryEntity = inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(persistedInventoryEntity);
    }

    @Override
    public InventoryResponse findById(final Long id) {
        final InventoryEntity inventoryEntity = getInventoryEntityById(id);
        return inventoryMapper.entityToDto(inventoryEntity);
    }

    @Override
    public List<InventoryResponse> findAll() {
        return null;
    }

    private @NotNull InventoryEntity getInventoryEntityById(final Long id) {
        final Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findById(id);
        if (optionalInventoryEntity.isEmpty()) {
            throw new ApiRequestException(
                    MessageFormat.format(ITEM_DOES_NOT_EXIST, id));
        }
        return optionalInventoryEntity.get();
    }
}
