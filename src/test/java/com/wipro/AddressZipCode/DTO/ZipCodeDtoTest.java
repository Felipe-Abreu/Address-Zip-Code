package com.wipro.AddressZipCode.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZipCodeDtoTest {

    @Test
    public void shouldCreateZipCodeDtoInstance() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        Assertions.assertNotNull(zipCodeDto);
    }

    @Test
    public void shouldSetAndGetCep() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String cep = "12345-678";
        zipCodeDto.setCep(cep);
        Assertions.assertEquals(cep, zipCodeDto.getCep());
    }

    @Test
    public void shouldSetAndGetRua() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String rua = "Rua A";
        zipCodeDto.setRua(rua);
        Assertions.assertEquals(rua, zipCodeDto.getRua());
    }

    @Test
    public void shouldSetAndGetComplemento() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String complemento = "Sala 1";
        zipCodeDto.setComplemento(complemento);
        Assertions.assertEquals(complemento, zipCodeDto.getComplemento());
    }

    @Test
    public void shouldSetAndGetBairro() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String bairro = "Bairro A";
        zipCodeDto.setBairro(bairro);
        Assertions.assertEquals(bairro, zipCodeDto.getBairro());
    }
    @Test
    public void shouldSetAndGetCidade() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String cidade = "Cidade A";
        zipCodeDto.setCidade(cidade);
        Assertions.assertEquals(cidade, zipCodeDto.getCidade());
    }

    @Test
    public void shouldSetAndGetEstado() {
        ZipCodeDto zipCodeDto = new ZipCodeDto();
        String estado = "Estado A";
        zipCodeDto.setEstado(estado);
        Assertions.assertEquals(estado, zipCodeDto.getEstado());
    }
}