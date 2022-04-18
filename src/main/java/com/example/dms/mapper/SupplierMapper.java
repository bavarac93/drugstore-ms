package com.example.dms.mapper;

import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.model.SupplierEntity;

import java.util.List;

public interface SupplierMapper {

    SupplierEntity dtoToEntity(final SupplierRequest supplierRequest);

    SupplierResponse entityToDto(final SupplierEntity supplierEntity);

    List<SupplierResponse> entitiesToDto(final List<SupplierEntity> supplierEntityList);
}
