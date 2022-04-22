package com.example.dms.service;


import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;

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
 * </ul>
 *
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
}
