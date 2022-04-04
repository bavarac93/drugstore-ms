package com.example.dms.service;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;

/**
 * Methods used to manipulate customer data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 * </ul>
 *
 */
public interface CustomerService {

    CustomerResponse create(final CustomerRequest customerRequest);
}
