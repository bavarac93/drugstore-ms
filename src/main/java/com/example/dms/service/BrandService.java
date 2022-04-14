package com.example.dms.service;

import com.example.dms.dto.*;
import com.example.dms.model.BrandEntity;

import java.util.List;

/**
 * Methods used to manipulate brand data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll()}</li>
 *     <li>{@link  #getBrandEntityById(Long)}</li>
 * </ul>
 *
 */
public interface BrandService {
//
//    String create();

    /**
     * Create a new brand based on a request model.
     *
     * @param brandRequest {@link BrandRequest}
     * @return {@link BrandResponse}
     */
    BrandResponse create(final BrandRequest brandRequest);

    /**
     * Get a  brand entity by id.
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



}
