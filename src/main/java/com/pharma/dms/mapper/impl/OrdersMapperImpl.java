package com.pharma.dms.mapper.impl;

import com.pharma.dms.dto.OrdersRequest;
import com.pharma.dms.dto.OrdersResponse;
import com.pharma.dms.mapper.OrdersMapper;
import com.pharma.dms.model.OrdersEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersMapperImpl implements OrdersMapper {
    @Override
    public OrdersEntity dtoToEntity(final @NotNull OrdersRequest ordersRequest) {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setInstructionsToCustomer(ordersRequest.getInstructionsToCustomer());
        ordersEntity.setDateTimeOrdered(ordersRequest.getDateTimeOrdered());
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
        ordersResponse.setDateTimeOrdered(persistedOrdersEntity.getDateTimeOrdered());
        return ordersResponse;
    }

    @Override
    public List<OrdersResponse> entitiesToDto(final @NotNull List<OrdersEntity> ordersEntities) {
        return ordersEntities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateOrder(final @NotNull OrdersEntity ordersEntity, final @NotNull OrdersRequest ordersRequest) {
        ordersEntity.setDateTimeOrdered(ordersRequest.getDateTimeOrdered());
        ordersEntity.setInstructionsToCustomer(ordersRequest.getInstructionsToCustomer());
    }
}
