package com.example.dms.service.impl;

import com.example.dms.dao.CustomerRepository;
import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.model.CustomerEntity;
import com.example.dms.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String AUTHOR = "Muki";

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(final CustomerRepository customerRepository, final CustomerMapper customerMapper) {
        this.customerRepository = Objects.requireNonNull(customerRepository, "customerRepository cannot be null");
        this.customerMapper = Objects.requireNonNull(customerMapper, "customerMapper cannot be null");
    }

    @Override
    public CustomerResponse create(final CustomerRequest customerRequest) {
        final CustomerEntity customerEntity = customerMapper.dtoToEntity(customerRequest);
        customerEntity.setCreatedAt(LocalDateTime.now());
        customerEntity.setCreatedBy(AUTHOR);
        customerEntity.setDateJoined(Date.from(Instant.now()));
        if ((customerRequest.getEmail() != null) && !(customerRequest.getEmail().isEmpty()))
            customerEntity.setVerified(true);
        final CustomerEntity persistedCustomerEntity = customerRepository.save(customerEntity);
        return customerMapper.entityToDto(persistedCustomerEntity);
    }

    @Override
    public List<CustomerResponse> findAll() {
        final List<CustomerEntity> customerEntityList = customerRepository.findAll();
        return customerMapper.entityToDto(customerEntityList);
    }

    @Override
    public CustomerResponse findById(final Long id) {
        final Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isEmpty()) {
            throw new ApiRequestException("Customer with this id " + id + " does not exist.");
        }
        final CustomerEntity customerEntity = optionalCustomerEntity.get();
        return customerMapper.entityToDto(customerEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ApiRequestException("The customer with this id " + id + "does not exist.");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse updateById(final Long id, final CustomerRequest customerRequest) {
        if (!customerRepository.existsById(id)) {
            throw new ApiRequestException("The customer with this id " + id + "cannot be found.");
        }
        final CustomerEntity customerEntity = customerRepository.findById(id).get();
        customerMapper.updateCustomer(customerRequest, customerEntity);
        customerEntity.setModifiedBy(AUTHOR);
        customerEntity.setModifiedAt(LocalDateTime.now());
        final CustomerEntity updateCustomerEntity = customerRepository.save(customerEntity);
        return customerMapper.entityToDto(updateCustomerEntity);
    }

    @Override
    public CustomerResponse updatePhoneNumberById(final Long id, final String phoneNumber) {
        if (!customerRepository.existsById(id)) {
            throw new ApiRequestException("The customer with this id " + id + " does not exist.");
        }
        final CustomerEntity customerEntity = customerRepository.findById(id).get();
        customerEntity.setPhoneNumber(phoneNumber);
        customerEntity.setModifiedBy(AUTHOR);
        customerEntity.setModifiedAt(LocalDateTime.now());
        final CustomerEntity updateCustomerEntity = customerRepository.save(customerEntity);
        return customerMapper.entityToDto(updateCustomerEntity);
    }
}
