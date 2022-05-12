package com.example.dms.service;

import com.example.dms.dto.RoleRequest;
import com.example.dms.dto.RoleResponse;

import java.util.List;

/**
 * Methods used to manipulate role data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #deleteById}</li>
 * </ul>
 */
public interface RoleService {

    /**
     * Create a role based on request data.
     *
     * @param roleRequest {@link RoleRequest}
     * @return roleResponse {@link RoleResponse}
     */
    RoleResponse create(final RoleRequest roleRequest);

    /**
     * Get a list of roles.
     *
     * @return roleResponse {@link RoleResponse}
     */
    List<RoleResponse> findAll();

    /**
     * Delete a role by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
