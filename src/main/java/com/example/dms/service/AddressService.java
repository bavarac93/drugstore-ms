package com.example.dms.service;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressRequestPatch;
import com.example.dms.dto.AddressResponse;
import com.example.dms.model.AddressEntity;

import java.util.List;

/**
 * Methods used to manipulate address data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateStreetAndBuildingNumberById}</li>
 * </ul>
 *
 */
public interface AddressService {
    /**
     * Create a new brand based on a request model.
     *
     * @param addressRequest {@link AddressRequest}
     * @return {@link AddressResponse}
     */
    AddressResponse create(final AddressRequest addressRequest);

    /**
     * Get a list of addresses.
     *
     * @return {@link AddressResponse}
     */
    List<AddressResponse> findAll();

    /**
     * Get an address by id.
     *
     * @param id {@link Long}
     * @return {@link AddressResponse}
     */
    AddressResponse findById(final Long id);

    /**
     * Delete an address by id.
     *
     * @param id {@link Long}
     */
    void deleteById(Long id);

    /**
     * Update an address by id.
     *
     * @param id {@link Long}
     * @param addressRequest {@link AddressRequest}
     * @return {@link AddressResponse}
     */
    AddressResponse updateById(final Long id, final AddressRequest addressRequest);

    /**
     * Update the buildingNumber and street by id.
     *
     * @param id {@link Long}
     * @param addressRequestPatch {@link AddressRequestPatch}
     * @return {@link AddressResponse}
     */
    AddressResponse updateStreetAndBuildingNumberById(final Long id, final AddressRequestPatch addressRequestPatch);

    /**
     * Get an address entity by id.
     *
     * @param id {@link Long}
     * @return {@link AddressEntity}
     */
    AddressEntity getAddressEntityById(final Long id);
}


