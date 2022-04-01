package com.example.dms.service.impl;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {



    @Override
    public AddressResponse create(AddressRequest addressRequest) {
        return null;
    }

    @Override
    public List<AddressResponse> getAll() {
        return null;
    }

    @Override
    public AddressResponse getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public AddressResponse updateById(Long id, AddressRequest addressRequest) {
        return null;
    }

    @Override
    public AddressResponse updateStreetAndBuildingNumberById(Long id, String buildingNumber, String street) {
        return null;
    }
}
