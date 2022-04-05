package com.example.dms.mapper.impl;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.model.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity dtoToEntity(final CustomerRequest customerRequest) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerRequest.getFirstName());
        customerEntity.setLastName(customerRequest.getLastName());
        customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
        customerEntity.setEmail(customerRequest.getEmail());
        customerEntity.setDrugAllergicTo(customerRequest.getDrugAllergicTo());
        return customerEntity;
    }

    @Override
    public CustomerResponse entityToDto(final CustomerEntity persistedCustomerEntity) {
        final CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(persistedCustomerEntity.getId());
        customerResponse.setFirstName(persistedCustomerEntity.getFirstName());
        customerResponse.setLastName(persistedCustomerEntity.getLastName());
        customerResponse.setEmail(persistedCustomerEntity.getEmail());
        customerResponse.setPhoneNumber(persistedCustomerEntity.getPhoneNumber());
        customerResponse.setVerified(persistedCustomerEntity.isVerified());
        customerResponse.setDateJoined(persistedCustomerEntity.getDateJoined());
        customerResponse.setDrugAllergicTo(persistedCustomerEntity.getDrugAllergicTo());
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> entityToDto(final List<CustomerEntity> customerEntities) {
        final List<CustomerResponse> responseList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            responseList.add(entityToDto(customerEntity));
        }
        return responseList;
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest, CustomerEntity customerEntity) {
        customerEntity.setFirstName(customerRequest.getFirstName());
        customerEntity.setLastName(customerRequest.getLastName());
        customerEntity.setEmail(customerRequest.getEmail());
        customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
        customerEntity.setDrugAllergicTo(customerRequest.getDrugAllergicTo());
    }
}
