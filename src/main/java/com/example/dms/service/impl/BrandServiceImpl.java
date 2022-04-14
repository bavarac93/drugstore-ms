package com.example.dms.service.impl;

import com.example.dms.dao.BrandRepository;
import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.BrandMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.service.BrandService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private static final String BRAND_DOES_NOT_EXIST = "Brand with id: {0} does not exist.";
    public static final String AUTHOR = "Muki";
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(final BrandRepository brandRepository, final BrandMapper brandMapper) {
        this.brandRepository = Objects.requireNonNull(brandRepository, "brandRepository cannot be null");
        this.brandMapper = Objects.requireNonNull(brandMapper, "brandMapper cannot be null");
    }


//    public String create() {
//        final BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandName("EIP");
//        brandEntity.setBrandDesc("Najbolja medresa u gradu");
//        brandEntity.setCreatedBy("AUTHOR");
//        brandEntity.setCreatedAt(LocalDateTime.now());
//
//        brandRepository.save(brandEntity);
//        return "upisano";
//    }


    @Override
    public BrandResponse create(final BrandRequest brandRequest) {
        final BrandEntity brandEntity = brandMapper.dtoToEntity(brandRequest);
        brandEntity.setCreatedAt(LocalDateTime.now());
        brandEntity.setCreatedBy(AUTHOR);
        final BrandEntity persistedBrandEntity = brandRepository.save(brandEntity);
        return brandMapper.entityToDto(persistedBrandEntity);
    }

    @Override
    public BrandEntity getBrandEntityById(final Long id) {
        final Optional<BrandEntity> optionalBrandEntity = brandRepository.findById(id);
        if (optionalBrandEntity.isEmpty()) {
            throw new ApiRequestException(
                    MessageFormat.format(BRAND_DOES_NOT_EXIST, id));
        }
        return optionalBrandEntity.get();
    }

    @Override
    public List<BrandResponse> findAll() {
        final List<BrandEntity> brandEntityList = brandRepository.findAll();
        return brandMapper.entityToDto(brandEntityList);
    }


}

