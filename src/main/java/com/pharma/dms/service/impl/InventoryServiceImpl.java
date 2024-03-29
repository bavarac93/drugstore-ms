package com.pharma.dms.service.impl;

import com.pharma.dms.dao.InventoryRepository;
import com.pharma.dms.mapper.InventoryMapper;
import com.pharma.dms.dto.InventoryRequest;
import com.pharma.dms.dto.InventoryRequestPatch;
import com.pharma.dms.dto.InventoryResponse;
import com.pharma.dms.exception.ApiRequestException;
import com.pharma.dms.model.BrandEntity;
import com.pharma.dms.model.InventoryEntity;
import com.pharma.dms.model.ProductTypeEntity;
import com.pharma.dms.model.SupplierEntity;
import com.pharma.dms.service.BrandService;
import com.pharma.dms.service.InventoryService;
import com.pharma.dms.service.ProductTypeService;
import com.pharma.dms.service.SupplierService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
            final SupplierService supplierService) {
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
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(ITEM_DOES_NOT_EXIST, id)));
    }

    @Override
    public List<InventoryResponse> findAllWithExpiryTimeBefore(final LocalDate expiryDate) {
        List<InventoryEntity> inventoryEntityList = inventoryRepository.findAllWithExpiryTimeBefore(expiryDate);
        return inventoryMapper.entitiesToDto(inventoryEntityList);
    }

    @Override
    public List<InventoryResponse> findItemsMadeByTheSameBrand(final @NotNull Long brandId) {
        List<InventoryEntity> inventoryEntities = inventoryRepository.findItemsMadeByTheSameBrand(brandId);
        return inventoryMapper.entitiesToDto(inventoryEntities);
    }

    @Override
    public String countItemsMadeByTheSameBrand(final Long brandId) {
        List<InventoryEntity> inventoryEntityList = inventoryRepository.findItemsMadeByTheSameBrand(brandId);
        inventoryMapper.entitiesToDto(inventoryEntityList);
        return "There is/are " + inventoryEntityList.size() + " item(s) of the same brand id " + brandId;
    }

    @Override
    public List<InventoryResponse> findItemsOfTheSameType(final Long productTypeId) {
        List<InventoryEntity> list = inventoryRepository.findItemsOfTheSameType(productTypeId);
        return inventoryMapper.entitiesToDto(list);
    }

    @Override
    public List<InventoryResponse> findItemsFromTheSameSupplier(final Long supplierId) {
        List<InventoryEntity> entities = inventoryRepository.findItemsFromTheSameSupplier(supplierId);
        return inventoryMapper.entitiesToDto(entities);
    }

    @Override
    public String countItemsOfTheSameType(final Long productTypeId) {
        List<InventoryEntity> list = inventoryRepository.findItemsOfTheSameType(productTypeId);
        inventoryMapper.entitiesToDto(list);
        return "There is/are " + list.size() + " item(s) of the type id " + productTypeId;
    }

    @Override
    public String countItemsFromTheSameSupplier(final Long supplierId) {
        List<InventoryEntity> list = inventoryRepository.findItemsFromTheSameSupplier(supplierId);
        inventoryMapper.entitiesToDto(list);
        return "There is/are " + list.size() + " item(s) from the same supplier id " + supplierId;
    }

    @Override
    public List<InventoryResponse> findItemByName(final String itemName) {
        List<InventoryEntity> list = inventoryRepository.findItemByName(itemName);
        return inventoryMapper.entitiesToDto(list);
    }
}
