package com.example.dms.mapper.impl;

import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.mapper.OrdersMapper;
import com.example.dms.model.OrdersEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OrdersResponse> entitiesToDto(final @NotNull List<OrdersEntity> ordersEntities) {
        final List<OrdersResponse> ordersResponseList = new ArrayList<>();
        for (OrdersEntity ordersEntity : ordersEntities) {
            ordersResponseList.add(entityToDto(ordersEntity));
        }
        return ordersResponseList;
    }

    @Override
    public void updateOrder(final @NotNull OrdersEntity ordersEntity, final @NotNull OrdersRequest ordersRequest) {
        ordersEntity.setDateOrdered(ordersRequest.getDateOrdered());
        ordersEntity.setInstructionsToCustomer(ordersRequest.getInstructionsToCustomer());
    }
}
