package com.example.dms.service;

import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.model.SupplierEntity;

import java.util.List;

/** Methods used to manipulate supplier data.
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
 * */
public interface SupplierService {

    /**
     * Create a supplier based on request data.
     *
     * @param supplierRequest {@link SupplierRequest}
     * @return supplierResponse {@link SupplierResponse}
     *
     */
    SupplierResponse create(final SupplierRequest supplierRequest);

    /**
     * Get a list of suppliers.
     *
     * @return supplierResponse {@link SupplierResponse}
     */
    List<SupplierResponse> findAll();

    /**
     * Get a supplier by id.
     *
     * @param id {@link Long}
     * @return {@link SupplierResponse}
     */
    SupplierResponse findById(final Long id);

    /**
     * Delete a supplier by id.
     *
     * @param id {@link Long}
     *
     */
    void deleteById(final Long id);

    /**
     * Update a supplier by id.
     *
     * @param id {@link Long}
     *
     */
    SupplierResponse updateById(final Long id, final SupplierRequest supplierRequest);

    /**
     * Get a supplier entity by id.
     *
     * @param id {@link Long}
     * @return {@link SupplierEntity}
     */
    SupplierEntity getSupplierEntityById(final Long id);


}
