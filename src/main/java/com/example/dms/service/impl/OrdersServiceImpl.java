package com.example.dms.service.impl;

import com.example.dms.dao.OrdersRepository;
import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.OrdersMapper;
import com.example.dms.model.CustomerEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.model.OrdersEntity;
import com.example.dms.service.CustomerService;
import com.example.dms.service.InventoryService;
import com.example.dms.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@EnableTransactionManagement
@Service
public class OrdersServiceImpl implements OrdersService {

    private static final String AUTHOR = "Muki";
    private static final String ORDER_NOT_FOUND = "Order with this id {0} does not exist.";

    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final CustomerService customerService;
    private final InventoryService inventoryService;

    public OrdersServiceImpl(
            final OrdersRepository ordersRepository,
            final OrdersMapper ordersMapper,
            final CustomerService customerService,
            final InventoryService inventoryService) {
        this.ordersRepository = Objects.requireNonNull(ordersRepository, "ordersRepository cannot be null");
        this.ordersMapper = Objects.requireNonNull(ordersMapper, "ordersMapper cannot be null");
        this.customerService = Objects.requireNonNull(customerService, "customerService cannot be null");
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService cannot be null");
    }

    @Override
    public OrdersResponse create(final OrdersRequest ordersRequest) {
        final OrdersEntity ordersEntity = ordersMapper.dtoToEntity(ordersRequest);
        ordersEntity.setCreatedAt(LocalDateTime.now());
        ordersEntity.setCreatedBy(AUTHOR);
        final CustomerEntity customerEntity = customerService.getCustomerEntityById(ordersRequest.getCustomerId());
        ordersEntity.setCustomerEntity(customerEntity);
        final InventoryEntity inventoryEntity = inventoryService.getInventoryEntityById(ordersRequest.getInventoryId());
        ordersEntity.setInventoryEntity(inventoryEntity);
        final OrdersEntity persistedOrdersEntity = ordersRepository.save(ordersEntity);
        return ordersMapper.entityToDto(persistedOrdersEntity);
    }

    @Override
    public List<OrdersResponse> findAllOrders() {
        List<OrdersEntity> ordersEntityList = ordersRepository.findAll();
        return ordersMapper.entitiesToDto(ordersEntityList);
    }

    @Override
    public OrdersResponse findById(final Long id) {
        final OrdersEntity ordersEntity = getOrdersEntityById(id);
        return ordersMapper.entityToDto(ordersEntity);
    }

    @Transactional
    @Override
    public void deleteById(final Long id) {
        if (!ordersRepository.existsById(id)) {
            throw new ApiRequestException(MessageFormat.format(ORDER_NOT_FOUND, id));
        }
        ordersRepository.deleteById(id);
    }

    @Override
    public OrdersResponse updateById(final Long id, final OrdersRequest ordersRequest) {
        OrdersEntity ordersEntity = getOrdersEntityById(id);
        ordersMapper.updateOrder(ordersEntity, ordersRequest);
        ordersEntity.setModifiedAt(LocalDateTime.now());
        ordersEntity.setModifiedBy(AUTHOR);
        final OrdersEntity updateOrder = ordersRepository.save(ordersEntity);
        return ordersMapper.entityToDto(updateOrder);
    }

    @Override
    public OrdersEntity getOrdersEntityById(final Long id) {
        final Optional<OrdersEntity> optionalProductTypeEntity = ordersRepository.findById(id);
        if (optionalProductTypeEntity.isEmpty()) {
            throw new ApiRequestException(
                    MessageFormat.format(ORDER_NOT_FOUND, id));
        }
        return optionalProductTypeEntity.get();
    }
}
