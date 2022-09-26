package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.mapper.impl.AddressMapperImpl;
import com.example.dms.model.AddressEntity;
import com.example.dms.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {
    @Mock private AddressRepository addressRepository;
    private AddressService underTest;
    private AddressMapper mapper = new AddressMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new AddressServiceImpl(mapper, addressRepository);
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setBuildingNumber("2A");
        addressRequest.setCity("Zenica");
        addressRequest.setCountry("Bosna i Hercegovina");
        addressRequest.setPostcode("72000");
        addressRequest.setStreet("Makovi");
    }

    @Test
    void canCreateAddress() {
        // Given
        AddressRequest addressRequest = new AddressRequest();

        // When
        Mockito.when(addressRepository.save(any(AddressEntity.class))).thenReturn(mapper.dtoToEntity(addressRequest));
        underTest.create(addressRequest);

        // Then
        ArgumentCaptor<AddressEntity> addressEntityArgumentCaptor = ArgumentCaptor.forClass(AddressEntity.class);
        Mockito.verify(addressRepository).save(addressEntityArgumentCaptor.capture());

        AddressEntity addressEntity = addressEntityArgumentCaptor.getValue();
        assertThat(addressEntity.getCity()).isEqualTo(addressRequest.getCity());
        assertThat(addressEntity.getCountry()).isEqualTo(addressRequest.getCountry());
        assertThat(addressEntity.getPostcode()).isEqualTo(addressRequest.getPostcode());
        assertThat(addressEntity.getStreet()).isEqualTo(addressRequest.getStreet());
        assertThat(addressEntity.getBuildingNumber()).isEqualTo(addressRequest.getBuildingNumber());
    }

    @Test
    void canFindAllAddresses() {
        //when
        underTest.findAll();
        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAll();
    }

    @Test
    @Disabled
    void willThrowIfIdDoesNotExist() {
        //given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);
        Long checkId = 3L;

        //when
        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findById(checkId).orElseThrow();
//        given(addressRepository.findById(checkId)).willThrow(ApiRequestException.class);

        assertThatThrownBy(() -> addressRepository.findById(checkId))
                .isInstanceOf(ApiRequestException.class)
                .hasMessage("Address with id: {0} does not exist.");
    }

    @Test
    void canDeleteById() {
        //given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);
        addressRepository.save(addressEntity);

        //when
        Long checkId = 1L;
        addressRepository.deleteById(checkId);

        //then
        assertThat(addressEntity.getId()).isNotNull();
        assertThat(addressEntity.getId()).isEqualTo(checkId);
    }

    @Test
    void canFindById() {
        //given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);

        //when
        Long checkId = 1L;
        addressRepository.findById(checkId);

        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findById(checkId);
    }
    @Test
    @Disabled
    void canUpdateById() {
        //given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setBuildingNumber("3D");
        addressRequest.setCity("Sarajevo");
        addressRequest.setCountry("Bosna i Hercegovina");
        addressRequest.setPostcode("71000");
        addressRequest.setStreet("Grbavica");

        //when
        Long checkId = 1L;
        addressRepository.findById(checkId);
        underTest.updateById(checkId, addressRequest);

        //then
        Mockito.verify(addressRepository).findById(checkId);
        ArgumentCaptor<AddressEntity> addressEntityArgumentCaptor = ArgumentCaptor.forClass(AddressEntity.class);
        Mockito.verify(addressRepository).save(addressEntityArgumentCaptor.capture());
        AddressEntity addressEntityRepo = addressEntityArgumentCaptor.getValue();
        assertThat(addressEntityRepo.getCity()).isEqualTo(addressRequest.getCity());
        assertThat(addressEntityRepo.getCountry()).isEqualTo(addressRequest.getCountry());
        assertThat(addressEntityRepo.getPostcode()).isEqualTo(addressRequest.getPostcode());
        assertThat(addressEntityRepo.getStreet()).isEqualTo(addressRequest.getStreet());
        assertThat(addressEntityRepo.getBuildingNumber()).isEqualTo(addressRequest.getBuildingNumber());

    }

    @Test
    @Disabled
    void canUpdateStreetAndBuildingNumberById() {
    }

    @Test
    void canGetAddressEntityById() {
        //given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);

        //when
        Long checkId = 1L;
        addressRepository.findById(checkId);

        //then
        Mockito.verify(addressRepository).findById(checkId);
    }

    @Test
    void canFindAddressesInTheSameCity() {
        //given
        String city = "Zenica";

        //when
        List<AddressResponse> responseList = underTest.findAddressesInTheSameCity(city);

        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAddressesInTheSameCity(city);
    }
}