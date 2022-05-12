package com.example.dms.service;


import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.model.OrdersEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Methods used to manipulate orders data.
 * List of implemented APIs with links:
 *
 * <ul>
 *     <li>{@link #create}</li>
 *     <li>{@link #findAllOrders}</li>
 *     <li>{@link #findById}</li>
 *     <li>{@link #deleteById}</li>
 *     <li>{@link #updateById}</li>
 *     <li>{@link #findOrdersMadeOnSomeDate}</li>
 *     <li>{@link #findOrdersMadeBySameCustomer}</li>
 * </ul>
 */
public interface OrdersService {

    /**
     * Create a new order based on a request model.
     *
     * @param ordersRequest {@link OrdersRequest}
     * @return {@link OrdersResponse}
     */
    OrdersResponse create(final OrdersRequest ordersRequest);

    /**
     * Get a list of orders.
     *
     * @return {@link OrdersResponse}
     */
    List<OrdersResponse> findAllOrders();

    /**
     * Find an order by id.
     *
     * @param id {@link Long}
     * @return {@link OrdersResponse}
     */
    OrdersResponse findById(final Long id);

    /**
     * Delete an order by id.
     *
     * @param id {@link Long}
     */
    void deleteById(final Long id);

    /**
     * Update an order by id.
     *
     * @param id            {@link Long}
     * @param ordersRequest {@link OrdersRequest}
     * @return {@link OrdersResponse}
     */
    OrdersResponse updateById(final Long id, final OrdersRequest ordersRequest);

    /**
     * Get orders entity by id.
     *
     * @param id {@link Long}
     * @return {@link OrdersEntity}
     */
    OrdersEntity getOrdersEntityById(final Long id);

    /**
     * Get orders made on some date.
     *
     * @param dateTimeOrdered {@link LocalDateTime}
     * @return {@link OrdersResponse}
     */
    List<OrdersResponse> findOrdersMadeOnSomeDate(final LocalDateTime dateTimeOrdered);

    /**
     * Get orders made on some date.
     *
     * @param customerId {@link Long}
     * @return {@link OrdersResponse}
     */
    List<OrdersResponse> findOrdersMadeBySameCustomer(final Long customerId);
}
