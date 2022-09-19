package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dao.CustomerRepository;
import com.example.dms.dto.CustomerRequest;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.mapper.impl.AddressMapperImpl;
import com.example.dms.mapper.impl.CustomerMapperImpl;
import com.example.dms.model.AddressEntity;
import com.example.dms.model.CustomerEntity;
import com.example.dms.service.AddressService;
import com.example.dms.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AddressRepository addressRepository;
    private CustomerService underTest;
    private CustomerMapper mapper = new CustomerMapperImpl();
    private AddressMapper addressMapper = new AddressMapperImpl();

    @Mock
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        underTest = new CustomerServiceImpl(customerRepository, mapper, addressService);
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(222L);
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressRepository.save(addressEntity);

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setAddressId(1L);
        customerRequest.setEmail("muki@gmail.com");
        customerRequest.setDrugAllergicTo("Paracetamol");
        customerRequest.setFirstName("Muharem");
        customerRequest.setLastName("Spica");
        customerRequest.setPhoneNumber("062325555");
    }

    @Test
    void canFindAllCustomers() {
        //when
        underTest.findAll();
        //then
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void canCreateCustomer() {
        // Given
        AddressEntity addressEntity = new AddressEntity();
        CustomerRequest customerRequest = new CustomerRequest();

        // When
        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(mapper.dtoToEntity(customerRequest));
        underTest.create(customerRequest);

        // Then
        ArgumentCaptor<CustomerEntity> customerEntityArgumentCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        Mockito.verify(customerRepository).save(customerEntityArgumentCaptor.capture());

        CustomerEntity customerEntity = customerEntityArgumentCaptor.getValue();
        assertThat(customerEntity.getAddressEntity().getId()).isEqualTo(customerRequest.getAddressId());
        assertThat(customerEntity.getEmail()).isEqualTo(customerRequest.getEmail());
        assertThat(customerEntity.getDrugAllergicTo()).isEqualTo(customerRequest.getDrugAllergicTo());
        assertThat(customerEntity.getFirstName()).isEqualTo(customerRequest.getFirstName());
        assertThat(customerEntity.getLastName()).isEqualTo(customerRequest.getLastName());
        assertThat(customerEntity.getPhoneNumber()).isEqualTo(customerRequest.getPhoneNumber());
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