package com.example.dms.service.impl;

import com.example.dms.dao.SupplierRepository;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.model.SupplierEntity;
import com.example.dms.service.SupplierService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIER_DOES_NOT_EXIST = "Supplier with this id: {0} does not exist.";
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(final SupplierRepository supplierRepository) {
        this.supplierRepository = Objects.requireNonNull(supplierRepository, "supplierRepository cannot be null");
    }


    @Override
    public SupplierEntity getSupplierEntityById(final Long id) {
        final Optional<SupplierEntity> optionalSupplierEntity = supplierRepository.findById(id);
            if (optionalSupplierEntity.isEmpty()) {
                throw new ApiRequestException(
                        MessageFormat.format(SUPPLIER_DOES_NOT_EXIST, id));
            }
            return optionalSupplierEntity.get();
    }
}
