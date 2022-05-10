package com.example.dms.service;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerRequestPhoneNumberPatch;
import com.example.dms.dto.CustomerRequestVerifiedPatch;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.model.CustomerEntity;

import java.util.List;

/**
 * Methods used to manipulate customer data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAll}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #updatePhoneNumberById}</li>
 *     <li>{@link #updateVerifiedStatus}</li>
 *     <li>{@link #findAllergicCustomers}</li>
 *     <li>{@link #countAllergicCustomersToSomeDrug}</li>
 * </ul>
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
     * Get a list of customers.
     *
     * @return {@link CustomerResponse}
     */
    List<CustomerResponse> findAll();

    /**
     * Get a customer by id.
     *
     * @param id {@link Long}
     * @return {@link CustomerResponse}
     */
    CustomerResponse findById(final Long id);

    /**
     * Delete a customer by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);

    /**
     * Update a customer by id.
     *
     * @param id {@link Long}
     * @param customerRequest {@link CustomerRequest}
     * @return {@link CustomerResponse}
     */
    CustomerResponse updateById(final Long id, final CustomerRequest customerRequest);

    /**
     * Update a phoneNumber by id.
     *
     * @param id {@link Long}
     * @param customerRequestPhoneNumberPatch {@link CustomerRequestPhoneNumberPatch}
     * @return {@link CustomerResponse}
     */
    CustomerResponse updatePhoneNumberById(final Long id, final CustomerRequestPhoneNumberPatch customerRequestPhoneNumberPatch);

    /**
     * Get a customer entity by id.
     *
     * @param id {@link Long}
     * @return {@link CustomerEntity}
     */
    CustomerEntity getCustomerEntityById(final Long id);

    /**
     * Get a list of verified customers.
     *
     * @return {@link CustomerResponse}
     */
    List<CustomerResponse> findVerifiedCustomers();

    /**
     * Update isVerified by id.
     *
     * @param id {@link Long}
     * @param customerRequestVerifiedPatch {@link CustomerRequestVerifiedPatch}
     * @return {@link CustomerResponse}
     */
    CustomerResponse updateVerifiedStatus(final Long id, final CustomerRequestVerifiedPatch customerRequestVerifiedPatch);

    /**
     * Get a list of allergic customers.
     *
     * @param drugAllergicTo {@link String}
     * @return {@link CustomerResponse}
     */
    List<CustomerResponse> findAllergicCustomers(final String drugAllergicTo);

    /**
     * Count allergic customers.
     *
     * @param drugAllergicTo {@link String}
     * @return {@link String}
     */
    String countAllergicCustomersToSomeDrug(final String drugAllergicTo);
}
