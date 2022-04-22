package com.example.dms.mapper;


import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.model.OrdersEntity;

import java.util.List;

public interface OrdersMapper {

    OrdersEntity dtoToEntity(final OrdersRequest ordersRequest);

    OrdersResponse entityToDto(final OrdersEntity persistedOrdersEntity);

    List<OrdersResponse> entitiesToDto(final List<OrdersEntity> ordersEntityList);
}
