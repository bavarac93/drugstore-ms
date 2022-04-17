package com.example.dms.service;

import com.example.dms.dto.InventoryResponse;
import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeResponse;

import java.util.List;
/**
 * Methods used to manipulate product type data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateProductTypeDescById}</li>
 * </ul>
 *
 */

public interface ProductTypeService {


    /**
     * Get a list of product types.
     *
     * @return {@link InventoryResponse}
     *
     */
    List<ProductTypeResponse> findAll();

    /**
     * Get a product type by id.
     *
     * @param id {@link Long}
     * @return productTypeResponse {@link ProductTypeResponse}
     *
     */
    ProductTypeResponse findById(final Long id);

    /**
     * Delete a product type by id.
     *
     * @param id {@link Long}
     *
     */
    void deleteById(final Long id);

    /**
     * Update a product type by id.
     *
     * @param id {@link Long}
     * @param productTypeRequest {@link ProductTypeRequest}
     * @return productTypeResponse {@link ProductTypeResponse}
     *
     */
    ProductTypeResponse updateById (final Long id, final ProductTypeRequest productTypeRequest);

    /**
     * Update a product desc by id.
     *
     * @param id {@link Long}
     * @param productTypeDesc {@link String}
     * @return productTypeResponse {@link ProductTypeResponse}
     *
     */
    ProductTypeResponse updateProductTypeDescById (final Long id, final String productTypeDesc);
}
