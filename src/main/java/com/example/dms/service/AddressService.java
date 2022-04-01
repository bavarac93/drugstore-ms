package com.example.dms.service;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;

import java.util.List;

/**
 * Methods used to manipulate address data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #getById}</li>
 *     <li>{@link #getAll()}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updateStreetAndBuildingNumberById}</li>
 * </ul>
 *
 */
public interface AddressService {
    /**
     * Create a new address based on a request model.
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
    List<AddressResponse> getAll();

    /**
     * Get an address by id.
     *
     * @param id {@link Long}
     * @return {@link AddressResponse}
     */
    AddressResponse getById(final Long id);

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
     * @param buildingNumber {@link String}
     * @param street {@link String}
     * @return {@link AddressResponse}
     */
    AddressResponse updateStreetAndBuildingNumberById(Long id, String buildingNumber, String street);
}


