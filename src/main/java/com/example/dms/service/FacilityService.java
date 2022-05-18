package com.example.dms.service;

import com.example.dms.dto.FacilityRequest;
import com.example.dms.dto.FacilityResponse;

import java.util.List;

/**
 * Methods used to manipulate facility data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 * </ul>
 */
public interface FacilityService {
    /**
     * Create a new facility based on a request model.
     *
     * @param facilityRequest {@link FacilityRequest}
     * @return {@link FacilityResponse}
     */
    FacilityResponse create(final FacilityRequest facilityRequest);

    /**
     * Get a facility by id.
     *
     * @param id {@link Long}
     * @return {@link FacilityResponse}
     */
    FacilityResponse findById(final Long id);

    /**
     * Get a list of facilities.
     *
     * @return {@link FacilityResponse}
     */
    List<FacilityResponse> findAll();

    /**
     * Delete a facility by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
