package com.pharma.dms.mapper;

import com.pharma.dms.dto.CustomerRequest;
import com.pharma.dms.dto.CustomerResponse;
import com.pharma.dms.model.CustomerEntity;

import java.util.List;

public interface CustomerMapper {
    CustomerEntity dtoToEntity(final CustomerRequest customerRequest);

    CustomerResponse entityToDto(final CustomerEntity persistedCustomerEntity);

    List<CustomerResponse> entitiesToDto(final List<CustomerEntity> customerEntities);

    void updateCustomer(final CustomerRequest customerRequest, final CustomerEntity customerEntity);
}
