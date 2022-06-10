package com.example.dms.service.impl;

import com.example.dms.dao.SupplierRepository;
import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierRequestPatch;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.SupplierMapper;
import com.example.dms.model.SupplierEntity;
import com.example.dms.service.SupplierService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIER_DOES_NOT_EXIST = "Supplier with this id: {0} does not exist.";
    private static final String AUTHOR = "Muki";

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(final SupplierRepository supplierRepository, final SupplierMapper supplierMapper) {
        this.supplierRepository = Objects.requireNonNull(supplierRepository, "supplierRepository cannot be null");
        this.supplierMapper = Objects.requireNonNull(supplierMapper, "supplierMapper cannot be null");
    }


    @Override
    public SupplierResponse create(final SupplierRequest supplierRequest) {
        SupplierEntity supplierEntity = supplierMapper.dtoToEntity(supplierRequest);
        supplierEntity.setCreatedAt(LocalDateTime.now());
        supplierEntity.setCreatedBy(AUTHOR);
        final SupplierEntity saveSupplierEntity = supplierRepository.save(supplierEntity);
        return supplierMapper.entityToDto(saveSupplierEntity);
    }

    @Override
    public List<SupplierResponse> findAll() {
        List<SupplierEntity> supplierEntityList = supplierRepository.findAll();
        return supplierMapper.entitiesToDto(supplierEntityList);
    }

    @Override
    public SupplierResponse findById(final Long id) {
        final SupplierEntity supplierEntity = getSupplierEntityById(id);
        return supplierMapper.entityToDto(supplierEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(SUPPLIER_DOES_NOT_EXIST, id));
        }
        supplierRepository.deleteById(id);
    }

    @Override
    public SupplierResponse updateById(final Long id, final SupplierRequest supplierRequest) {
        final SupplierEntity supplierEntity = getSupplierEntityById(id);
        supplierEntity.setModifiedAt(LocalDateTime.now());
        supplierEntity.setModifiedBy(AUTHOR);
        supplierMapper.updateSupplier(supplierRequest, supplierEntity);
        final SupplierEntity updateSupplierEntity = supplierRepository.save(supplierEntity);
        return supplierMapper.entityToDto(updateSupplierEntity);
    }

    @Override
    public SupplierResponse updateContractExpiresById(final Long id, final @NotNull SupplierRequestPatch supplierRequestPatch) {
        final SupplierEntity supplierEntity = getSupplierEntityById(id);
        supplierEntity.setModifiedAt(LocalDateTime.now());
        supplierEntity.setModifiedBy(AUTHOR);
        supplierEntity.setContractExpires(supplierRequestPatch.getContractExpires());
        final SupplierEntity updateSupplierEntity = supplierRepository.save(supplierEntity);
        return supplierMapper.entityToDto(updateSupplierEntity);
    }

    @Override
    public SupplierEntity getSupplierEntityById(final Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(SUPPLIER_DOES_NOT_EXIST, id)));
    }

    @Override
    public List<SupplierResponse> findAllWithContractSignedOn(final LocalDate contractSigned) {
        List<SupplierEntity> list = supplierRepository.findAllWithContractSignedOn(contractSigned);
        return supplierMapper.entitiesToDto(list);
    }

    @Override
    public List<SupplierResponse> findAllWithContractExpiresOn(final LocalDate contractExpires) {
        List<SupplierEntity> list = supplierRepository.findAllWithContractExpiresOn(contractExpires);
        return supplierMapper.entitiesToDto(list);
    }
}
