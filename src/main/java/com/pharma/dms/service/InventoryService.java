package com.pharma.dms.service;


import com.pharma.dms.dto.InventoryRequest;
import com.pharma.dms.dto.InventoryResponse;
import com.pharma.dms.dto.InventoryRequestPatch;
import com.pharma.dms.model.InventoryEntity;

import java.time.LocalDate;
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
 *     <li>{@link #findItemsOfTheSameType}</li>
 *     <li>{@link #countItemsOfTheSameType}</li>
 *     <li>{@link #findItemByName}</li>
 *     <li>{@link #findAllWithExpiryTimeBefore}</li>
 *     <li>{@link #findItemsMadeByTheSameBrand}</li>
 *     <li>{@link #countItemsMadeByTheSameBrand}</li>
 *     <li>{@link #findItemsFromTheSameSupplier}</li>
 *     <li>{@link #countItemsFromTheSameSupplier}</li>
 * </ul>
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
     * @param id               {@link Long}
     * @param inventoryRequest {@link InventoryRequest}
     * @return {@link InventoryResponse}
     */
    InventoryResponse updateById(final Long id, final InventoryRequest inventoryRequest);

    /**
     * Update the description of an item by id.
     *
     * @param id                    {@link Long}
     * @param inventoryRequestPatch {@link InventoryRequestPatch}
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
     * Get a list of inventory items with expiry date before.
     *
     * @param expiryDate {@link LocalDate}
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findAllWithExpiryTimeBefore(final LocalDate expiryDate);

    /**
     * Get a list of inventory items made by the same brand.
     *
     * @param brandId {@link Long}
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findItemsMadeByTheSameBrand(final Long brandId);

    /**
     * Count items made by the same brand.
     *
     * @param brandId {@link Long}
     * @return {@link String}
     */
    String countItemsMadeByTheSameBrand(final Long brandId);

    /**
     * Get a list of items made of the same type.
     *
     * @param productTypeId {@link Long}
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findItemsOfTheSameType(final Long productTypeId);

    /**
     * Get a list of items made by the same supplier.
     *
     * @param supplierId {@link Long}
     * @return {@link InventoryResponse}
     */
    List<InventoryResponse> findItemsFromTheSameSupplier(final Long supplierId);

    /**
     * Count items of the same type.
     *
     * @param productTypeId {@link Long}
     * @return {@link String}
     */
    String countItemsOfTheSameType(final Long productTypeId);

    /**
     * Count items from the same supplier.
     *
     * @param supplierId {@link Long}
     * @return {@link String}
     */
    String countItemsFromTheSameSupplier(final Long supplierId);

    /**
     * Find items by some name.
     *
     * @param itemName {@link String}
     * @return {@link String}
     */
    List<InventoryResponse> findItemByName(final String itemName);
}
