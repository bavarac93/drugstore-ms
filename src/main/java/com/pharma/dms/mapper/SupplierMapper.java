package com.pharma.dms.mapper;

import com.pharma.dms.dto.SupplierRequest;
import com.pharma.dms.dto.SupplierResponse;
import com.pharma.dms.model.SupplierEntity;

import java.util.List;

public interface SupplierMapper {

    SupplierEntity dtoToEntity(final SupplierRequest supplierRequest);

    SupplierResponse entityToDto(final SupplierEntity supplierEntity);

    List<SupplierResponse> entitiesToDto(final List<SupplierEntity> supplierEntityList);

    void updateSupplier(final SupplierRequest supplierRequest, final SupplierEntity supplierEntity);
}
