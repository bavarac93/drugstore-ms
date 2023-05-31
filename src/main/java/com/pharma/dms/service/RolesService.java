package com.pharma.dms.service;

import com.pharma.dms.dto.RolesResponse;
import com.pharma.dms.dto.RolesRequest;

import java.util.List;

/**
 * Methods used to manipulate role data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #findAllRolesByName}</li>
 * </ul>
 */
public interface RolesService {

    /**
     * Create a role based on request data.
     *
     * @param rolesRequest {@link RolesRequest}
     * @return roleResponse {@link RolesResponse}
     */
    RolesResponse create(final RolesRequest rolesRequest);

    /**
     * Get a list of roles.
     *
     * @return roleResponse {@link RolesResponse}
     */
    List<RolesResponse> findAll();

    /**
     * Find all roles by same name.
     *
     * @param name {@link String}
     */
    List<RolesResponse> findAllRolesByName(final String name);

    /**
     * Delete a role by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
