package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.AddressMapper;
import com.example.dms.mapper.impl.AddressMapperImpl;
import com.example.dms.model.AddressEntity;
import com.example.dms.service.AddressService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {
    @Mock private AddressRepository addressRepository;
    private AddressService realAddressService;
    private AddressMapper mapper = new AddressMapperImpl();

    @BeforeEach
    void setUp() {
        realAddressService = new AddressServiceImpl(mapper, addressRepository);
    }

    @Test // fix
    void canCreateAddress() {
        // Given
        final AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity("Zenica");
        addressRequest.setCountry("Bosna i Hercegovina");
        addressRequest.setPostcode("72000");
        addressRequest.setBuildingNumber("2A");
        addressRequest.setStreet("Makovi");

        // When
        Mockito.when(addressRepository.save(any(AddressEntity.class))).thenReturn(new AddressEntity());
        final AddressResponse actual = realAddressService.create(addressRequest);

        // Then
        assertThat(actual.getCity()).isEqualTo(addressRequest.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressRequest.getCountry());
        assertThat(actual.getPostcode()).isEqualTo(addressRequest.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressRequest.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressRequest.getBuildingNumber());
    }

    @Test
    void canFindAllAddresses() {
        //when
        realAddressService.findAll();
        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAll();
    }

    @Test // fix
    @Disabled
    void canDeleteAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Long checkId = 35L;
        addressRepository.deleteById(checkId);

        //then
        assertThat(addressEntity.getId()).isNotNull();
        assertThat(addressEntity.getId()).isEqualTo(checkId);
    }


    @Test
    void canFindAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Mockito.when(addressRepository.findById(anyLong())).thenReturn(Optional.of(addressEntity));

        //then
        final AddressResponse actual = realAddressService.findById(1L);

        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressEntity.getBuildingNumber());
    }
    @Test
    void willThrowExceptionIfIdDoesNotExist() {
        // when
        Mockito.when(addressRepository.findById(anyLong())).thenThrow(ApiRequestException.class);

        // then
        assertThatThrownBy(() -> realAddressService.findById(1L)).isInstanceOf(ApiRequestException.class);
    }

    @Test
    void willThrowExceptionWithSpecificMessageIfIdDoesNotExist() {
        //when
        Mockito.when(addressRepository.findById(anyLong())).thenThrow(new ApiRequestException("Address with id: {0} does not exist."));

        //then
        assertThatThrownBy(() -> realAddressService.findById(3L)).hasMessage("Address with id: {0} does not exist.");
    }

    @Test
    @Disabled
    void canUpdateAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Mockito.when(addressRepository.findById(anyLong())).thenReturn(Optional.of(addressEntity));

        //then
        final AddressResponse actual = realAddressService.findById(1L);

        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressEntity.getBuildingNumber());
    }

    @Test
    @Disabled
    void canUpdateStreetAndBuildingNumberOfAddressEntityById() {
    }

    @Test // fix
    void canGetAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Mockito.when(addressRepository.findById(anyLong())).thenReturn(Optional.of(addressEntity));

        //then
        final AddressEntity actual = realAddressService.getAddressEntityById(222L);

        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressEntity.getBuildingNumber());
    }
    @Test // fix
    void cannotGetAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Mockito.when(addressRepository.findById(anyLong())).thenReturn(Optional.of(addressEntity));

        //then
        final AddressEntity actual = realAddressService.getAddressEntityById(24L);

        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressEntity.getBuildingNumber());
    }

    @Test // fix
    void canFindAddressesInTheSameCity() {
        //given
        String city = "Zenica";
        List<AddressEntity> responseList = new ArrayList<>();

        //when
        Mockito.when(addressRepository.findAddressesInTheSameCity(anyString())).thenReturn(responseList);
        final List<AddressResponse> actual = realAddressService.findAddressesInTheSameCity(city);

        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAddressesInTheSameCity(city);
        assertThat(actual.size()).isEqualTo(responseList.size());
    }
    @Test // fix
    void cannotFindAddressesInTheSameCity() {
        //given
        String city = "Tuzla";
        List<AddressEntity> responseList = new ArrayList<>();

        //when
        Mockito.when(addressRepository.findAddressesInTheSameCity(anyString())).thenReturn(responseList);
        final List<AddressResponse> actual = realAddressService.findAddressesInTheSameCity(city);

        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAddressesInTheSameCity(city);
        assertThat(actual.size()).isEqualTo(responseList.size());
//        assertThat(actual.contains(city)).isEqualTo(responseList.contains(city));
    }

    @NotNull
    private static AddressEntity prepareMockAddressEntity() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBuildingNumber("2A");
        addressEntity.setCity("Zenica");
        addressEntity.setCountry("Bosna i Hercegovina");
        addressEntity.setPostcode("72000");
        addressEntity.setStreet("Makovi");
        addressEntity.setId(1L);
        return addressEntity;
    }
}