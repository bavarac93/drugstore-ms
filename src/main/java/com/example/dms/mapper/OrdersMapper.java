package com.example.dms.mapper;


import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.model.OrdersEntity;

public interface OrdersMapper {

    OrdersEntity dtoToEntity(final OrdersRequest ordersRequest);

    OrdersResponse entityToDto(final OrdersEntity persistedOrdersEntity);
}
