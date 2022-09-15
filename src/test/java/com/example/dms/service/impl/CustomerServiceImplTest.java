package com.example.dms.service.impl;

import com.example.dms.dao.CustomerRepository;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.mapper.impl.CustomerMapperImpl;
import com.example.dms.service.AddressService;
import com.example.dms.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
        @Mock
        private CustomerRepository customerRepository;
        private CustomerService underTest;
        private CustomerMapper mapper = new CustomerMapperImpl();

        @Mock private AddressService addressService;

        @BeforeEach
        void setUp() {
            underTest = new CustomerServiceImpl(customerRepository,mapper, addressService);
        }


        @Test
        void canFindAllCustomers() {
            //when
            underTest.findAll();
            //then
            verify(customerRepository, times(1)).findAll();
        }
    @Test
    @Disabled
    void create() {
    }


    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void deleteById() {
    }

    @Test
    @Disabled
    void updateById() {
    }

    @Test
    @Disabled
    void updatePhoneNumberById() {
    }

    @Test
    @Disabled
    void updateVerifiedStatus() {
    }

    @Test
    @Disabled
    void findAllergicCustomers() {
    }

    @Test
    @Disabled
    void countAllergicCustomersToSomeDrug() {
    }

    @Test
    @Disabled
    void getCustomerEntityById() {
    }

    @Test
    @Disabled
    void findVerifiedCustomers() {
    }
}