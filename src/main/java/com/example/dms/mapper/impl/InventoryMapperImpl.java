package com.example.dms.mapper.impl;

import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.model.InventoryEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public InventoryEntity dtoToEntity(final @NotNull InventoryRequest inventoryRequest) {
        InventoryEntity inventoryEntity = new InventoryEntity();
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
        inventoryResponse.setCreatedAt(persistedInventoryEntity.getCreatedAt());
        return inventoryResponse;
    }
}
