package com.example.dms.service.impl;

import com.example.dms.dao.OrdersRepository;
import com.example.dms.mapper.OrdersMapper;
import com.example.dms.mapper.impl.OrdersMapperImpl;
import com.example.dms.service.CustomerService;
import com.example.dms.service.InventoryService;
import com.example.dms.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrdersServiceImplTest {
    @Mock
    private OrdersRepository ordersRepository;
    private OrdersService underTest;
    private OrdersMapper mapper = new OrdersMapperImpl();
    @Mock private CustomerService customerService;
    @Mock private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        underTest = new OrdersServiceImpl(ordersRepository, mapper, customerService, inventoryService);
    }

    @Test
    void canFindAllOrders() {
        //when
        underTest.findAllOrders();
        //then
        verify(ordersRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void canCreateOrders() {
    }

    @Test
    @Disabled
    void canFindById() {
    }

    @Test
    @Disabled
    void canDeleteById() {
    }

    @Test
    @Disabled
    void canUpdateById() {
    }

    @Test
    @Disabled
    void canGetOrdersEntityById() {
    }

    @Test
    @Disabled
    void canFindOrdersMadeOnSomeDate() {
    }

    @Test
    @Disabled
    void canFindOrdersMadeBySameCustomer() {
    }
}