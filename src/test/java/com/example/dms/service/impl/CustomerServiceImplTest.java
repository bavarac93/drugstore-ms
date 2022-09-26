package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dao.CustomerRepository;
import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.mapper.CustomerMapper;
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

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    private CustomerService underTest;
    private CustomerMapper mapper = new CustomerMapperImpl();

    @Mock
    private AddressService addressService;
    @Mock
    private AddressRepository addressRepository;


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
        addressService.getAddressEntityById(222L);

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
        CustomerRequest customerRequest = new CustomerRequest();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(222L);
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressService.getAddressEntityById(222L);

        // When
        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(mapper.dtoToEntity(customerRequest));
        underTest.create(customerRequest);

        // Then
        ArgumentCaptor<CustomerEntity> customerEntityArgumentCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        Mockito.verify(customerRepository).save(customerEntityArgumentCaptor.capture());

        CustomerEntity customerEntity = customerEntityArgumentCaptor.getValue();
//        assertThat(customerEntity.getAddressEntity().getId()).isEqualTo(addressEntity.getId());
//        assertThat(customerEntity.getEmail()).isEqualTo(customerRequest.getEmail());
//        assertThat(customerEntity.getDrugAllergicTo()).isEqualTo(customerRequest.getDrugAllergicTo());
//        assertThat(customerEntity.getFirstName()).isEqualTo(customerRequest.getFirstName());
//        assertThat(customerEntity.getLastName()).isEqualTo(customerRequest.getLastName());
//        assertThat(customerEntity.getPhoneNumber()).isEqualTo(customerRequest.getPhoneNumber());
        Mockito.verify(underTest).create(customerRequest);

    }

    @Test
    @Disabled
    void canFindById() {
        CustomerRequest customerRequest = new CustomerRequest();
        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(mapper.dtoToEntity(customerRequest));
        underTest.create(customerRequest);
        Long id = 1L;
        underTest.findById(id);
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
    void canUpdatePhoneNumberById() {
    }

    @Test
    @Disabled
    void canUpdateVerifiedStatus() {
    }

    @Test
    void canFindAllergicCustomers() {
        //given
        String medicine = "Zenica";

        //when
        List<CustomerResponse> responseList = underTest.findAllergicCustomers(medicine);

        //then
        Mockito.verify(customerRepository, Mockito.times(1)).listAllergicCustomers(medicine);
    }

    @Test
    @Disabled
    void canCountAllergicCustomersToSomeDrug() {
    }

    @Test
    @Disabled
    void canGetCustomerEntityById() {
    }

    @Test
    void canFindVerifiedCustomers() {
        //given
        //when
        List<CustomerResponse> responseList = underTest.findVerifiedCustomers();

        //then
        Mockito.verify(customerRepository, Mockito.times(1)).findVerifiedCustomers();
    }
}