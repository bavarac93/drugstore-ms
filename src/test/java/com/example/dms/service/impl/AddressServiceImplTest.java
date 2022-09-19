package com.example.dms.service.impl;

import com.example.dms.dao.AddressRepository;
import com.example.dms.dto.AddressRequest;
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

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        Mockito.when(addressRepository.save(Mockito.any(AddressEntity.class))).thenReturn(mapper.dtoToEntity(addressRequest));
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
        verify(addressRepository, times(1)).findAll();
    }
    @Test
    @Disabled
    void willNotAddAddressWhenPostcodeIsEmpty() {
        // fix

        // Given
        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setBuildingNumber("2A");
        addressRequest.setCity("Zenica");
        addressRequest.setCountry("Bosna i Hercegovina");
        addressRequest.setPostcode("");
        addressRequest.setStreet("Makovi");
        Mockito.when(addressRepository.save(Mockito.any(AddressEntity.class))).thenReturn(mapper.dtoToEntity(addressRequest));
        underTest.create(addressRequest);
        // When
        assertThatThrownBy(() -> {
            addressRequest.getPostcode();
        }).hasMessage("The address must include the postcode.");

        // Then
        Mockito.verifyNoInteractions(addressRepository);
    }


    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void deleteById() {
    }

    @Test
    @Disabled
    void updateById() {
    }

    @Test
    @Disabled
    void updateStreetAndBuildingNumberById() {
    }

    @Test
    @Disabled
    void getAddressEntityById() {
    }

    @Test
    @Disabled
    void findAddressesInTheSameCity() {
    }
}