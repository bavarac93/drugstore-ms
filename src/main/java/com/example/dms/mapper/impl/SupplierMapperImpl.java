package com.example.dms.mapper.impl;

import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.mapper.SupplierMapper;
import com.example.dms.model.SupplierEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapperImpl implements SupplierMapper {


    @Override
    public SupplierEntity dtoToEntity(final @NotNull SupplierRequest supplierRequest) {
        final SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setSupplierName(supplierRequest.getSupplierName());
        supplierEntity.setSupplierDesc(supplierRequest.getSupplierDesc());
        supplierEntity.setContractSigned(supplierRequest.getContractSigned());
        supplierEntity.setContractExpires(supplierRequest.getContractExpires());
        supplierEntity.setCreatedAt(supplierRequest.getCreatedAt());
        return supplierEntity;
    }

    @Override
    public SupplierResponse entityToDto(final @NotNull SupplierEntity persistedSupplierEntity) {
        final SupplierResponse supplierResponse = new SupplierResponse();
        supplierResponse.setId(persistedSupplierEntity.getId());
        supplierResponse.setSupplierName(persistedSupplierEntity.getSupplierName());
        supplierResponse.setSupplierDesc(persistedSupplierEntity.getSupplierDesc());
        supplierResponse.setContractSigned(persistedSupplierEntity.getContractSigned());
        supplierResponse.setContractExpires(persistedSupplierEntity.getContractExpires());
        supplierResponse.setCreatedAt(persistedSupplierEntity.getCreatedAt());
        return supplierResponse;
    }
}
