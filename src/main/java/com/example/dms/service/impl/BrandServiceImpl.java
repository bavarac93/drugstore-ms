package com.example.dms.service.impl;

import com.example.dms.dao.BrandRepository;
import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandRequestPatch;
import com.example.dms.dto.BrandResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.BrandMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.service.BrandService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class BrandServiceImpl implements BrandService {

    public static final String AUTHOR = "Muki";
    private static final String BRAND_DOES_NOT_EXIST = "Brand with id: {0} does not exist.";
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(final BrandRepository brandRepository, final BrandMapper brandMapper) {
        this.brandRepository = Objects.requireNonNull(brandRepository, "brandRepository cannot be null");
        this.brandMapper = Objects.requireNonNull(brandMapper, "brandMapper cannot be null");
    }

    @Override
    public BrandResponse create(final BrandRequest brandRequest) {
        final BrandEntity brandEntity = brandMapper.dtoToEntity(brandRequest);
        brandEntity.setCreatedAt(LocalDateTime.now());
        brandEntity.setCreatedBy(AUTHOR);
        final BrandEntity persistedBrandEntity = brandRepository.save(brandEntity);
        return brandMapper.entityToDto(persistedBrandEntity);
    }

    @Override
    public List<BrandResponse> findAll() {
        final List<BrandEntity> brandEntityList = brandRepository.findAll();
        return brandMapper.entitiesToDto(brandEntityList);
    }

    @Override
    public BrandResponse findById(final Long id) {
        final BrandEntity brandEntity = this.getBrandEntityById(id);
        return brandMapper.entityToDto(brandEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!brandRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(BRAND_DOES_NOT_EXIST, id));
        }
        brandRepository.deleteById(id);
    }

    @Override
    public BrandResponse updateById(final Long id, final BrandRequest brandRequest) {
        final BrandEntity brandEntity = getBrandEntityById(id);
        brandMapper.updateBrand(brandRequest, brandEntity);
        brandEntity.setModifiedAt(LocalDateTime.now());
        brandEntity.setModifiedBy(AUTHOR);
        final BrandEntity updateBrandEntity = brandRepository.save(brandEntity);
        return brandMapper.entityToDto(updateBrandEntity);
    }

    @Override
    public BrandResponse updateBrandDescById(final Long id, final @NotNull BrandRequestPatch brandRequestPatch) {
        final BrandEntity brandEntity = getBrandEntityById(id);
        brandEntity.setBrandDesc(brandRequestPatch.getBrandDesc());
        brandEntity.setModifiedAt(LocalDateTime.now());
        brandEntity.setModifiedBy(AUTHOR);
        final BrandEntity updateBrandEntity = brandRepository.save(brandEntity);
        return brandMapper.entityToDto(updateBrandEntity);
    }

    @Override
    public List<BrandResponse> findAllBrandsBySomeName(final String brandName) {
        List<BrandEntity> brandEntities = brandRepository.findAllBrandsBySomeName(brandName);
        return brandMapper.entitiesToDto(brandEntities);
    }

    @Override
    public BrandEntity getBrandEntityById(final Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException(MessageFormat.format(BRAND_DOES_NOT_EXIST, id)));
    }
}

