package com.pharma.dms.service.impl;

import com.pharma.dms.dao.OrdersRepository;
import com.pharma.dms.mapper.OrdersMapper;
import com.pharma.dms.dto.OrdersRequest;
import com.pharma.dms.dto.OrdersResponse;
import com.pharma.dms.exception.ApiRequestException;
import com.pharma.dms.model.CustomerEntity;
import com.pharma.dms.model.InventoryEntity;
import com.pharma.dms.model.OrdersEntity;
import com.pharma.dms.service.CustomerService;
import com.pharma.dms.service.InventoryService;
import com.pharma.dms.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        return ordersRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(ORDER_NOT_FOUND, id)));
    }

    @Override
    public List<OrdersResponse> findOrdersMadeOnSomeDate(final LocalDateTime dateTimeOrdered) {
        List<OrdersEntity> list = ordersRepository.findOrdersMadeOnSomeDate(dateTimeOrdered);
        return ordersMapper.entitiesToDto(list);
    }

    @Override
    public List<OrdersResponse> findOrdersMadeBySameCustomer(final Long customerId) {
        List<OrdersEntity> ordersEntityList = ordersRepository.findOrdersMadeBySameCustomer(customerId);
        return ordersMapper.entitiesToDto(ordersEntityList);
    }
}
