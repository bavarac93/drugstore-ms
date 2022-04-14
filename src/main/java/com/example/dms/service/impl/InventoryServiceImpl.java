package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.mapper.InventoryMapper;
import com.example.dms.model.BrandEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final String AUTHOR = "Muki";


    private final InventoryRepository inventoryRepository;
    private final BrandService brandService;
    private final InventoryMapper inventoryMapper;

    public InventoryServiceImpl(final InventoryRepository inventoryRepository, final BrandService brandService, final InventoryMapper inventoryMapper) {
        this.inventoryRepository = Objects.requireNonNull(inventoryRepository, "inventoryRepository cannot be null");
        this.brandService = Objects.requireNonNull(brandService, "brandService cannot be null");
        this.inventoryMapper = Objects.requireNonNull(inventoryMapper, "inventoryMapper cannot be null");
    }

    @Override
    public InventoryResponse create(final InventoryRequest inventoryRequest, final Long brandId) {
        final InventoryEntity inventoryEntity = inventoryMapper.dtoToEntity(inventoryRequest);
        inventoryEntity.setCreatedAt(LocalDateTime.now());
        inventoryEntity.setCreatedBy(AUTHOR);
        final BrandEntity brandEntity = brandService.getBrandEntityById(brandId);
        inventoryEntity.setBrandEntity(brandEntity);
        final InventoryEntity persistedInventoryEntity = inventoryRepository.save(inventoryEntity);
        return inventoryMapper.entityToDto(persistedInventoryEntity);
    }

//    @Override
//    public String create(Long brandId) {
//        InventoryEntity i = new InventoryEntity();
//        i.setItemName("kurban");
//        i.setQuantity(400L);
//        i.setAvailable(400L);
//        i.setCreatedAt(LocalDateTime.now());
//        i.setDescription(213L);
//        i.setPrice(400L);
//        i.setExpiryDate(String.valueOf(LocalDateTime.now().plusDays(123L)));
//        i.setSku("387214324u13251234");
//        i.setSold(200L);
//        //======================================
//        final BrandEntity brandEntity = brandService.getBrandEntityById(brandId);
//        i.setBrandEntity(brandEntity);
//
//        inventoryRepository.save(i);
//        return "inventori kreiran ofrlje";
//    }
}
