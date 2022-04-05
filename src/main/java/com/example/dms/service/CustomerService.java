package com.example.dms.service;

import com.example.dms.dto.AddressResponse;
import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;

import java.util.List;

/**
 * Methods used to manipulate customer data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #findAll()}</li>
 *     <li>{@link #deleteById}</li>
 * </ul>
 *
 */
public interface CustomerService {

    /**
     * Create a new customer based on a request model.
     *
     * @param customerRequest {@link CustomerRequest}
     * @return {@link CustomerResponse}
     */
    CustomerResponse create(final CustomerRequest customerRequest);

    /**
     * Get a customer by id.
     *
     * @param id {@link Long}
     * @return {@link CustomerResponse}
     */
    CustomerResponse findById(final Long id);

    /**
     * Get a list of customers.
     *
     * @return {@link CustomerResponse}
     */
    List<CustomerResponse> findAll();

    /**
     * Delete a customer by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);
}
