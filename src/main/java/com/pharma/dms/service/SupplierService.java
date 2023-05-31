package com.pharma.dms.service;

import com.pharma.dms.dto.SupplierRequestPatch;
import com.pharma.dms.dto.SupplierRequest;
import com.pharma.dms.dto.SupplierResponse;
import com.pharma.dms.model.SupplierEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * Methods used to manipulate supplier data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateContractExpiresById}</li>
 *     <li>{@link #findAllWithContractSignedOn}</li>
 *     <li>{@link #findAllWithContractExpiresOn}</li>
 * </ul>
 */
public interface SupplierService {

    /**
     * Create a supplier based on request data.
     *
     * @param supplierRequest {@link SupplierRequest}
     * @return supplierResponse {@link SupplierResponse}
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
     */
    void deleteById(final Long id);

    /**
     * Update a supplier by id.
     *
     * @param id {@link Long}
     */
    SupplierResponse updateById(final Long id, final SupplierRequest supplierRequest);

    /**
     * Update contractExpires by id.
     *
     * @param id                   {@link Long}
     * @param supplierRequestPatch {@link SupplierRequestPatch}
     * @return {@link SupplierResponse}
     */
    SupplierResponse updateContractExpiresById(final Long id, final SupplierRequestPatch supplierRequestPatch);

    /**
     * Get a supplier entity by id.
     *
     * @param id {@link Long}
     * @return {@link SupplierEntity}
     */
    SupplierEntity getSupplierEntityById(final Long id);

    /**
     * Get suppliers that signed a contract on some date.
     *
     * @param contractSigned {@link LocalDate}
     * @return {@link SupplierResponse}
     */
    List<SupplierResponse> findAllWithContractSignedOn(final LocalDate contractSigned);

    /**
     * Get suppliers whose contract expires on some date.
     *
     * @param contractExpires {@link LocalDate}
     * @return {@link SupplierResponse}
     */
    List<SupplierResponse> findAllWithContractExpiresOn(final LocalDate contractExpires);
}
