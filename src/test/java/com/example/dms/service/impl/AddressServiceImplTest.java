package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressRequestPatch;
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

    @Test
    void canCreateAddress() {
        // Given
        final AddressRequest addressRequest = new AddressRequest();
        addressRequest.setCity("Zenica");
        addressRequest.setCountry("Bosna i Hercegovina");
        addressRequest.setPostcode("72000");
        addressRequest.setBuildingNumber("2A");
        addressRequest.setStreet("Makovi");

        // Create AddressEntity from addressRequest
        final AddressEntity expectedAddressEntity = mapper.dtoToEntity(addressRequest);

        // When
        final AddressEntity anyAddressEntity = any(AddressEntity.class);
        Mockito.when(addressRepository.save(anyAddressEntity)).thenReturn(expectedAddressEntity);
        final AddressResponse actual = realAddressService.create(addressRequest);

        // Then
        assertThat(actual.getCity()).isEqualTo(expectedAddressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(expectedAddressEntity.getCountry());
        assertThat(actual.getPostcode()).isEqualTo(expectedAddressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(expectedAddressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(expectedAddressEntity.getBuildingNumber());
    }

    @Test
    void canFindAllAddresses() {
        //when
        realAddressService.findAll();
        //then
        Mockito.verify(addressRepository, Mockito.times(1)).findAll();
    }

    @Test
    void canDeleteAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();
        addressRepository.save(addressEntity);
        assertThat(addressEntity.getId()).isNotNull();

        //when
        addressRepository.deleteById(addressEntity.getId());

        //then
        assertThat(addressRepository.findById(addressEntity.getId())).isNotPresent();
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
    void canUpdateAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();

        //when
        Mockito.when(addressRepository.findById(anyLong())).thenReturn(Optional.of(addressEntity));
        final AddressResponse actual = realAddressService.findById(1L);

        //then
        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
        assertThat(actual.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(actual.getBuildingNumber()).isEqualTo(addressEntity.getBuildingNumber());
    }

    @Test
    @Disabled //fix
    void canUpdateStreetAndBuildingNumberOfAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();
        final AddressRequestPatch addressRequestPatch = new AddressRequestPatch();
        final String updatedStreet = "updated street";
        final String updatedBuildingNumber = "updated building number";
        addressRequestPatch.setStreet(updatedStreet);
        addressRequestPatch.setBuildingNumber(updatedBuildingNumber);
        Long id = 1L;

        // Add a null check for the id parameter
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        // Add a null check for the addressRequestPatch parameter
        if (addressRequestPatch == null) {
            throw new IllegalArgumentException("addressRequestPatch must not be null");
        }

        //when
        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(addressEntity));
        final AddressResponse actual = realAddressService.updateStreetAndBuildingNumberById(id, addressRequestPatch);

        //then
        assertThat(actual.getStreet()).isEqualTo(updatedStreet);
        assertThat(actual.getBuildingNumber()).isEqualTo(updatedBuildingNumber);
        assertThat(actual.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(actual.getCountry()).isEqualTo(addressEntity.getCountry());
        assertThat(actual.getId()).isEqualTo(addressEntity.getId());
        assertThat(actual.getPostcode()).isEqualTo(addressEntity.getPostcode());
    }

    @Test //fix
    void canGetAddressEntityById() {
        //given
        final AddressEntity addressEntity = prepareMockAddressEntity();
        addressEntity.setId(98L);
        addressRepository.save(addressEntity);

        //when
        final Optional<AddressEntity> optional = addressRepository.findById(98L);

        //then
        assertThat(optional).isPresent();
        final AddressEntity actual = optional.get();
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