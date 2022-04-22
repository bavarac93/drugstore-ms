package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryRequestPatch;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.model.ProductTypeEntity;
import com.example.dms.model.SupplierEntity;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import com.example.dms.service.ProductTypeService;
import com.example.dms.service.SupplierService;
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
    private final ProductTypeService productTypeService;
    private final SupplierService supplierService;

    public InventoryServiceImpl(
            final InventoryRepository inventoryRepository,
            final BrandService brandService,
            final InventoryMapper inventoryMapper,
            final ProductTypeService productTypeService,
            final SupplierService supplierService
    ) {
        this.inventoryRepository = Objects.requireNonNull(inventoryRepository, "inventoryRepository cannot be null");
        this.brandService = Objects.requireNonNull(brandService, "brandService cannot be null");
        this.inventoryMapper = Objects.requireNonNull(inventoryMapper, "inventoryMapper cannot be null");
        this.productTypeService = Objects.requireNonNull(productTypeService, "productTypeService cannot be null");
        this.supplierService = Objects.requireNonNull(supplierService, "supplierService cannot be null");
    }

    @Override
    public InventoryResponse create(final InventoryRequest inventoryRequest) {
        final InventoryEntity inventoryEntity = inventoryMapper.dtoToEntity(inventoryRequest);
        inventoryEntity.setCreatedAt(LocalDateTime.now());
        inventoryEntity.setCreatedBy(AUTHOR);
        final BrandEntity brandEntity = brandService.getBrandEntityById(inventoryRequest.getBrandId());
        inventoryEntity.setBrandEntity(brandEntity);
        final ProductTypeEntity productTypeEntity = productTypeService.getProductTypeEntityById(inventoryRequest.getProductTypeId());
        inventoryEntity.setProductTypeEntity(productTypeEntity);
        final SupplierEntity supplierEntity = supplierService.getSupplierEntityById(inventoryRequest.getSupplierId());
        inventoryEntity.setSupplierEntity(supplierEntity);
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
        List<InventoryEntity> inventoryEntityList = inventoryRepository.findAll();
        return inventoryMapper.entitiesToDto(inventoryEntityList);
    }

    @Override
    public void deleteById(final Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new ApiRequestException(
            MessageFormat.format(ITEM_DOES_NOT_EXIST, id));
        }
        inventoryRepository.deleteById(id);
    }

    @Override
    public InventoryResponse updateById(final Long id, final InventoryRequest inventoryRequest) {
        final InventoryEntity inventoryEntity = getInventoryEntityById(id);
        inventoryMapper.updateInventory(inventoryRequest, inventoryEntity);
        inventoryEntity.setModifiedAt(LocalDateTime.now());
        inventoryEntity.setModifiedBy(AUTHOR);
        final InventoryEntity updateInventory = inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(updateInventory);
    }

    @Override
    public InventoryResponse updateDescriptionById(final Long id, final @NotNull InventoryRequestPatch inventoryRequestPatch) {
        final InventoryEntity inventoryEntity = getInventoryEntityById(id);
        inventoryEntity.setModifiedBy(AUTHOR);
        inventoryEntity.setModifiedAt(LocalDateTime.now());
        inventoryEntity.setDescription(inventoryRequestPatch.getDescription());
        final InventoryEntity updateInventory = inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(updateInventory);
    }

    public @NotNull InventoryEntity getInventoryEntityById(final Long id) {
        final Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findById(id);
        if (optionalInventoryEntity.isEmpty()) {
            throw new ApiRequestException(
                    MessageFormat.format(ITEM_DOES_NOT_EXIST, id));
        }
        return optionalInventoryEntity.get();
    }
}
