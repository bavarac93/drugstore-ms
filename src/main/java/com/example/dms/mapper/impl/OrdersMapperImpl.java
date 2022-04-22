package com.example.dms.mapper.impl;

import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.mapper.OrdersMapper;
import com.example.dms.model.OrdersEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapperImpl implements OrdersMapper {
    @Override
    public OrdersEntity dtoToEntity(final @NotNull OrdersRequest ordersRequest) {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setInstructionsToCustomer(ordersRequest.getInstructionsToCustomer());
        ordersEntity.setDateOrdered(ordersRequest.getDateOrdered());
        return ordersEntity;
    }

    @Override
    public OrdersResponse entityToDto(final @NotNull OrdersEntity persistedOrdersEntity) {
        final OrdersResponse ordersResponse = new OrdersResponse();
        ordersResponse.setId(persistedOrdersEntity.getId());
        ordersResponse.setCreatedAt(persistedOrdersEntity.getCreatedAt());
        ordersResponse.setInstructionsToCustomer(persistedOrdersEntity.getInstructionsToCustomer());
        ordersResponse.setCustomerId(persistedOrdersEntity.getCustomerEntity().getId());
        ordersResponse.setInventoryId(persistedOrdersEntity.getInventoryEntity().getId());
        ordersResponse.setDateOrdered(persistedOrdersEntity.getDateOrdered());
        return ordersResponse;
    }
}
