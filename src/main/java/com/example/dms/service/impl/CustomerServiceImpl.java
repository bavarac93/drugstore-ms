package com.example.dms.service.impl;

import com.example.dms.dao.CustomerRepository;
import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.mapper.CustomerMapper;
import com.example.dms.model.CustomerEntity;
import com.example.dms.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String AUTHOR = "Muki";

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = Objects.requireNonNull(customerRepository, "customerRepository cannot be null");
        this.customerMapper = Objects.requireNonNull(customerMapper, "customerMapper cannot be null");
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        final CustomerEntity customerEntity = customerMapper.dtoToEntity(customerRequest);
        customerEntity.setCreatedAt(LocalDateTime.now());
        customerEntity.setCreatedBy(AUTHOR);
        customerEntity.setDateJoined(Date.from(Instant.now()));
        if ((customerRequest.getEmail() != null) && !(customerRequest.getEmail().isEmpty()))
            customerEntity.setVerified(true);
        final CustomerEntity persistedCustomerEntity = customerRepository.save(customerEntity);
        final CustomerResponse customerResponse = customerMapper.entityToDto(persistedCustomerEntity);
        return customerResponse;
    }
}
