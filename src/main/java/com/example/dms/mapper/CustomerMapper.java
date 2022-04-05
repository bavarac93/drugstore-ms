package com.example.dms.mapper;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.model.CustomerEntity;

import java.util.List;

public interface CustomerMapper {
    CustomerEntity dtoToEntity(final CustomerRequest customerRequest);

    CustomerResponse entityToDto(final CustomerEntity persistedCustomerEntity);

    List<CustomerResponse> entityToDto (final List<CustomerEntity> customerEntities);
}
