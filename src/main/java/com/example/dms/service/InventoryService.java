package com.example.dms.service;


import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryRequestPatch;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.model.InventoryEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Methods used to manipulate inventory data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateDescriptionById}</li>
 * </ul>
 *
 */
public interface InventoryService {

    /**
     * Create a new inventory item based on a request model.
     *
     * @param inventoryRequest {@link InventoryRequest}
     * @return {@link InventoryResponse}
     */
    InventoryResponse create(final InventoryRequest inventoryRequest);

    /**
     * Get an inventory item by id.
     *
     * @param id {@link Long}
     * @return {@link InventoryResponse}
     */
    InventoryResponse findById(final Long id);

    /**
     * Get a list of inventory items.
     *
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findAll();

    /**
     * Delete an inventory item by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);

    /**
     * Update an item by id.
     *
     * @param id {@link Long}
     * @param inventoryRequest {@link InventoryRequest}
     *
     * @return {@link InventoryResponse}
     */
    InventoryResponse updateById(final Long id, final InventoryRequest inventoryRequest);
    
    /**
     * Update the description of an item by id.
     *
     * @param id {@link Long}
     * @param inventoryRequestPatch {@link InventoryRequestPatch}
     *
     * @return {@link InventoryResponse}
     */
    InventoryResponse updateDescriptionById(final Long id, final InventoryRequestPatch inventoryRequestPatch);

    /**
     * Get an inventory entity by id.
     *
     * @param id {@link Long}
     * @return {@link InventoryEntity}
     */
    InventoryEntity getInventoryEntityById(final Long id);

    /**
     * Get a list of inventory items by specific date.
     *
     * @param expiryDate {@link LocalDate}
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findItemsWithSpecificExpiryDate(final LocalDate expiryDate);
}
