package com.example.dms.service.impl;

import com.example.dms.dao.InventoryRepository;
import com.example.dms.model.BrandEntity;
import com.example.dms.model.InventoryEntity;
import com.example.dms.service.BrandService;
import com.example.dms.service.InventoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final BrandService brandService;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, BrandService brandService) {
        this.inventoryRepository = inventoryRepository;
        this.brandService = brandService;
    }

    @Override
    public String create(Long brandId) {
        InventoryEntity i = new InventoryEntity();
        i.setItemName("kurban");
        i.setQuantity(400L);
        i.setAvailable(400L);
        i.setCreatedAt(LocalDateTime.now());
        i.setDescription(213L);
        i.setPrice(400L);
        i.setExpiryDate(String.valueOf(LocalDateTime.now().plusDays(123L)));
        i.setSku("387214324u13251234");
        i.setSold(200L);
        //======================================
        final BrandEntity brandEntity = brandService.getBrandEntityById(brandId);
        i.setBrandEntity(brandEntity);

        inventoryRepository.save(i);
        return "inventori kreiran ofrlje";
    }
}
