package com.example.dms.service.impl;

import com.example.dms.dao.ProductTypeRepository;
import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeRequestPatch;
import com.example.dms.dto.ProductTypeResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.ProductTypeMapper;
import com.example.dms.model.ProductTypeEntity;
import com.example.dms.service.ProductTypeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private static final String PRODUCT_TYPE_DOES_NOT_EXIST = "Product type with this id: {0} does not exist.";
    private static final String AUTHOR = "Muki";
    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;

    public ProductTypeServiceImpl(final ProductTypeRepository productTypeRepository, final ProductTypeMapper productTypeMapper) {
        this.productTypeRepository = Objects.requireNonNull(productTypeRepository, "productTypeRepository cannot be null.");
        this.productTypeMapper = Objects.requireNonNull(productTypeMapper, "productTypeMapper cannot be null.");
    }

    @Override
    public ProductTypeResponse create(final ProductTypeRequest productTypeRequest) {
        final ProductTypeEntity productTypeEntity = productTypeMapper.dtoToEntity(productTypeRequest);
        productTypeEntity.setCreatedAt(LocalDateTime.now());
        productTypeEntity.setCreatedBy(AUTHOR);
        final ProductTypeEntity saveProductTypeEntity = productTypeRepository.save(productTypeEntity);
        return productTypeMapper.entityToDto(saveProductTypeEntity);
    }

    @Override
    public List<ProductTypeResponse> findAll() {
        List<ProductTypeEntity> productTypeEntityList = productTypeRepository.findAll();
        return productTypeMapper.entitiesToDto(productTypeEntityList);
    }

    @Override
    public ProductTypeResponse findById(final Long id) {
        final ProductTypeEntity productTypeEntity = getProductTypeEntityById(id);
        return productTypeMapper.entityToDto(productTypeEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!productTypeRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(PRODUCT_TYPE_DOES_NOT_EXIST, id));
        }
        productTypeRepository.deleteById(id);
    }

    @Override
    public ProductTypeResponse updateById(final Long id, final ProductTypeRequest productTypeRequest) {
        final ProductTypeEntity productTypeEntity = getProductTypeEntityById(id);
        productTypeMapper.updateProductType(productTypeRequest, productTypeEntity);
        productTypeEntity.setModifiedAt(LocalDateTime.now());
        productTypeEntity.setModifiedBy(AUTHOR);
        final ProductTypeEntity updateProductTypeEntity = productTypeRepository.save(productTypeEntity);
        return productTypeMapper.entityToDto(updateProductTypeEntity);
    }

    @Override
    public ProductTypeResponse updateProductTypeDescById(final Long id, final @NotNull ProductTypeRequestPatch productTypeRequestPatch) {
        final ProductTypeEntity productTypeEntity = getProductTypeEntityById(id);
        productTypeEntity.setProductTypeDesc(productTypeRequestPatch.getProductTypeDesc());
        productTypeEntity.setModifiedBy(AUTHOR);
        productTypeEntity.setModifiedAt(LocalDateTime.now());
        final ProductTypeEntity updateProductTypeEntity = productTypeRepository.save(productTypeEntity);
        return productTypeMapper.entityToDto(updateProductTypeEntity);
    }

    @Override
    public @NotNull ProductTypeEntity getProductTypeEntityById(final Long id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(PRODUCT_TYPE_DOES_NOT_EXIST, id)));
    }
}
