package com.pharma.dms.mapper;


import com.pharma.dms.dto.InventoryRequest;
import com.pharma.dms.dto.InventoryResponse;
import com.pharma.dms.model.InventoryEntity;

import java.util.List;

public interface InventoryMapper {
    InventoryEntity dtoToEntity(final InventoryRequest inventoryRequest);

    InventoryResponse entityToDto(final InventoryEntity persistedInventoryEntity);

    List<InventoryResponse> entitiesToDto(final List<InventoryEntity> inventoryEntities);

    void updateInventory(final InventoryRequest inventoryRequest, final InventoryEntity inventoryEntity);
}
