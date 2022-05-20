package com.example.dms.service;

import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;

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
public interface UserService {

    /**
     * Create a user based on request data.
     *
     * @param userRequest {@link UserRequest}
     * @return userResponse {@link UserResponse}
     */
    UserResponse create(final UserRequest userRequest);

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
    UserResponse findUserByUsername(final String username);

    /**
     * Get a list of users.
     *
     * @return userResponse {@link UserResponse}
     */
    List<UserResponse> findAll();

    /**
     * Delete a user by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
