package com.example.dms.service;

import com.example.dms.dto.UsersRequest;
import com.example.dms.dto.UsersResponse;

import java.util.List;

/**
 * Methods used to manipulate user data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #addRoleToUser}</li>
 *     <li>{@link #findUserByUsername}</li>
 *     <li>{@link #deleteById}</li>
 * </ul>
 */
public interface UsersService {

    /**
     * Create a user based on request data.
     *
     * @param usersRequest {@link UsersRequest}
     * @return userResponse {@link UsersResponse}
     */
    UsersResponse create(final UsersRequest usersRequest);

    /**
     * Add role to a user.
     *
     * @param username {@link String}
     * @param roleName {@link String}
     */
    void addRoleToUser(final String username, final String roleName);

    /**
     * Find user by username.
     *
     * @param username {@link String}
     * @return {@link String}
     */
    UsersResponse findUserByUsername(final String username);

    /**
     * Get a list of users.
     *
     * @return userResponse {@link UsersResponse}
     */
    List<UsersResponse> findAll();

    /**
     * Delete a user by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
