package com.example.dms.mapper;


import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.model.InventoryEntity;

import java.util.List;

public interface InventoryMapper {
    InventoryEntity dtoToEntity(final InventoryRequest inventoryRequest);

    InventoryResponse entityToDto(final InventoryEntity persistedInventoryEntity);

    List<InventoryResponse> entitiesToDto(final List<InventoryEntity> inventoryEntities);

    void updateInventory(final InventoryRequest inventoryRequest, final InventoryEntity inventoryEntity);
}
