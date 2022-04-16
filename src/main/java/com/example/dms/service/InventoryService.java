package com.example.dms.service;


import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;

import java.util.List;

/**
 * Methods used to manipulate inventory data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #findAll()}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 * </ul>
 *
 */
public interface InventoryService {

    /**
     * Create a new inventory item based on a request model.
     *
     * @param inventoryRequest {@link InventoryRequest}
     * @param brandId {@link Long}
     * @return {@link InventoryResponse}
     */
    InventoryResponse create(final InventoryRequest inventoryRequest, final Long brandId);

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
     * @@param id {@link Long}
     */
    void deleteById(final Long id);
}
