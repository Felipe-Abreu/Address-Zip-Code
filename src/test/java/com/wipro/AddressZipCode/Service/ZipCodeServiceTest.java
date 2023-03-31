package com.wipro.AddressZipCode.Service;

import com.wipro.AddressZipCode.Configuration.ConfigurationApi;
import com.wipro.AddressZipCode.DTO.ZipCodeDto;
import com.wipro.AddressZipCode.Enums.States;
import com.wipro.AddressZipCode.Model.ZipCode;
import com.wipro.AddressZipCode.Service.ZipCodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ZipCodeServiceTest {

    @Mock
    private ConfigurationApi configurationApi;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ZipCodeService zipCodeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConsumeZipCodeJsonAndReturnZipCodeInstance() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        zipCodeDto.setCep("12345-678");
        zipCodeDto.setRua("Rua A");
        zipCodeDto.setComplemento("Sala 1");
        zipCodeDto.setBairro("Bairro A");
        zipCodeDto.setCidade("Cidade A");
        zipCodeDto.setEstado("SP");

        when(configurationApi.getViaCepApi()).thenReturn("https://viacep.com.br/ws/");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(zipCodeDto);

        ZipCode zipCode = zipCodeService.consumingZipCodeJson("12345678");

        Assertions.assertEquals(zipCodeDto.getCep(), zipCode.getCep());
        Assertions.assertEquals(zipCodeDto.getRua(), zipCode.getLogradouro());
        Assertions.assertEquals(zipCodeDto.getComplemento(), zipCode.getComplemento());
        Assertions.assertEquals(zipCodeDto.getBairro(), zipCode.getBairro());
        Assertions.assertEquals(zipCodeDto.getCidade(), zipCode.getLocalidade());
        Assertions.assertEquals(States.SP.getRegion(), zipCode.getFrete());
    }

    @Test
    public void shouldReturnHttpClientErrorExceptionWhenZipCodeIsInvalid() {
        when(configurationApi.getViaCepApi()).thenReturn("https://viacep.com.br/ws/");
        when(restTemplate.getForObject(anyString(), any())).thenThrow(HttpClientErrorException.class);

        Assertions.assertThrows(HttpClientErrorException.class, () -> {
            zipCodeService.consumingZipCodeJson("12345678");
        });
    }

}