package com.example.dms.mapper;


import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.model.InventoryEntity;

public interface InventoryMapper {
    InventoryEntity dtoToEntity(final InventoryRequest inventoryRequest);

    InventoryResponse entityToDto(final InventoryEntity persistedInventoryEntity, final Long brandId);
}
