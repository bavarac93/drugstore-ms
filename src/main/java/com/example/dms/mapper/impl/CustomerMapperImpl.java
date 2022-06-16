package com.example.dms.mapper.impl;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.model.CustomerEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerEntity dtoToEntity(final @NotNull CustomerRequest customerRequest) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerRequest.getFirstName());
        customerEntity.setLastName(customerRequest.getLastName());
        customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
        customerEntity.setEmail(customerRequest.getEmail());
        customerEntity.setDrugAllergicTo(customerRequest.getDrugAllergicTo());
        return customerEntity;
    }

    @Override
    public CustomerResponse entityToDto(final @NotNull CustomerEntity persistedCustomerEntity) {
        final CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(persistedCustomerEntity.getId());
        customerResponse.setFirstName(persistedCustomerEntity.getFirstName());
        customerResponse.setLastName(persistedCustomerEntity.getLastName());
        customerResponse.setEmail(persistedCustomerEntity.getEmail());
        customerResponse.setPhoneNumber(persistedCustomerEntity.getPhoneNumber());
        customerResponse.setVerified(persistedCustomerEntity.isVerified());
        customerResponse.setDateJoined(persistedCustomerEntity.getDateJoined());
        customerResponse.setDrugAllergicTo(persistedCustomerEntity.getDrugAllergicTo());
        customerResponse.setAddressId(persistedCustomerEntity.getAddressEntity().getId());
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> entitiesToDto(final @NotNull List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void updateCustomer(final @NotNull CustomerRequest customerRequest, final @NotNull CustomerEntity customerEntity) {
        customerEntity.setFirstName(customerRequest.getFirstName());
        customerEntity.setLastName(customerRequest.getLastName());
        customerEntity.setEmail(customerRequest.getEmail());
        customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
        customerEntity.setDrugAllergicTo(customerRequest.getDrugAllergicTo());
    }
}
