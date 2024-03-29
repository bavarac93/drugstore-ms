package com.pharma.dms.mapper.impl;

import com.pharma.dms.dto.InventoryRequest;
import com.pharma.dms.dto.InventoryResponse;
import com.pharma.dms.mapper.InventoryMapper;
import com.pharma.dms.model.InventoryEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryMapperImpl implements InventoryMapper {
    @Override
    public InventoryEntity dtoToEntity(final @NotNull InventoryRequest inventoryRequest) {
        final InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setItemName(inventoryRequest.getItemName());
        inventoryEntity.setDescription(inventoryRequest.getDescription());
        inventoryEntity.setPrice(inventoryRequest.getPrice());
        inventoryEntity.setSku(inventoryRequest.getSku());
        inventoryEntity.setSold(inventoryRequest.getSold());
        inventoryEntity.setQuantity(inventoryRequest.getQuantity());
        inventoryEntity.setExpiryDate(inventoryRequest.getExpiryDate());
        return inventoryEntity;
    }

    @Override
    public InventoryResponse entityToDto(final @NotNull InventoryEntity persistedInventoryEntity) {
        final InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setId(persistedInventoryEntity.getId());
        inventoryResponse.setItemName(persistedInventoryEntity.getItemName());
        inventoryResponse.setDescription(persistedInventoryEntity.getDescription());
        inventoryResponse.setPrice(persistedInventoryEntity.getPrice());
        inventoryResponse.setQuantity(persistedInventoryEntity.getQuantity());
        inventoryResponse.setExpiryDate(persistedInventoryEntity.getExpiryDate());
        inventoryResponse.setSku(persistedInventoryEntity.getSku());
        inventoryResponse.setSold(persistedInventoryEntity.getSold());
        inventoryResponse.setCreatedAt(persistedInventoryEntity.getCreatedAt());
        inventoryResponse.setBrandId(persistedInventoryEntity.getBrandEntity().getId());
        inventoryResponse.setProductTypeId(persistedInventoryEntity.getProductTypeEntity().getId());
        inventoryResponse.setSupplierId(persistedInventoryEntity.getSupplierEntity().getId());
        return inventoryResponse;
    }

    @Override
    public List<InventoryResponse> entitiesToDto(final @NotNull List<InventoryEntity> inventoryEntities) {
        return inventoryEntities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateInventory(final @NotNull InventoryRequest inventoryRequest, final @NotNull InventoryEntity inventoryEntity) {
        inventoryEntity.setItemName(inventoryRequest.getItemName());
        inventoryEntity.setQuantity(inventoryRequest.getQuantity());
        inventoryEntity.setSold(inventoryRequest.getSold());
        inventoryEntity.setDescription(inventoryRequest.getDescription());
        inventoryEntity.setExpiryDate(inventoryRequest.getExpiryDate());
        inventoryEntity.setSku(inventoryRequest.getSku());
        inventoryEntity.setPrice(inventoryRequest.getPrice());
    }
}
