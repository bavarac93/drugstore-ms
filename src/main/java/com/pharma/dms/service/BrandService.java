package com.pharma.dms.service;

import com.pharma.dms.dto.BrandRequest;
import com.pharma.dms.dto.BrandRequestPatch;
import com.pharma.dms.dto.BrandResponse;
import com.pharma.dms.model.BrandEntity;

import java.util.List;

/**
 * Methods used to manipulate brand data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateBrandDescById}</li>
 *     <li>{@link #findAllBrandsBySomeName}</li>
 * </ul>
 */
public interface BrandService {

    /**
     * Create a new brand based on a request model.
     *
     * @param brandRequest {@link BrandRequest}
     * @return {@link BrandResponse}
     */
    BrandResponse create(final BrandRequest brandRequest);

    /**
     * Get a brand entity by id.
     *
     * @param id {@link Long}
     * @return {@link BrandEntity}
     */
    BrandEntity getBrandEntityById(final Long id);

    /**
     * Get a list of brands.
     *
     * @return {@link BrandResponse}
     */
    List<BrandResponse> findAll();

    /**
     * Get a  brand by id.
     *
     * @param id {@link Long}
     * @return {@link BrandResponse}
     */
    BrandResponse findById(final Long id);

    /**
     * Delete a  brand by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);

    /**
     * Update a brand by id.
     *
     * @param id           {@link Long}
     * @param brandRequest {@link BrandRequest}
     * @return {@link BrandResponse}
     */
    BrandResponse updateById(final Long id, final BrandRequest brandRequest);

    /**
     * Update brandDesc by id.
     *
     * @param id                {@link Long}
     * @param brandRequestPatch {@link BrandRequestPatch}
     * @return {@link BrandResponse}
     */
    BrandResponse updateBrandDescById(final Long id, final BrandRequestPatch brandRequestPatch);

    /**
     * Get brands by brandName.
     *
     * @param brandName {@link String}
     * @return {@link BrandResponse}
     */
    List<BrandResponse> findAllBrandsBySomeName(final String brandName);
}
