package com.pharma.dms.mapper;


import com.pharma.dms.dto.OrdersRequest;
import com.pharma.dms.dto.OrdersResponse;
import com.pharma.dms.model.OrdersEntity;

import java.util.List;

public interface OrdersMapper {

    OrdersEntity dtoToEntity(final OrdersRequest ordersRequest);

    OrdersResponse entityToDto(final OrdersEntity persistedOrdersEntity);

    List<OrdersResponse> entitiesToDto(final List<OrdersEntity> ordersEntityList);

    void updateOrder(final OrdersEntity ordersEntity, final OrdersRequest ordersRequest);
}
