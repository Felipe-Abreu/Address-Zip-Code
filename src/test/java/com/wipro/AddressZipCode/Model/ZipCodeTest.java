package com.wipro.AddressZipCode.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZipCodeTest {

    @Test
    public void shouldCreateZipCodeInstance() {
        ZipCode zipCode = new ZipCode();
        Assertions.assertNotNull(zipCode);
    }

    @Test
    public void shouldSetAndGetCep() {
        ZipCode zipCode = new ZipCode();
        String cep = "12345-678";
        zipCode.setCep(cep);
        Assertions.assertEquals(cep, zipCode.getCep());
    }

    @Test
    public void shouldSetAndGetLogradouro() {
        ZipCode zipCode = new ZipCode();
        String logradouro = "Rua A";
        zipCode.setLogradouro(logradouro);
        Assertions.assertEquals(logradouro, zipCode.getLogradouro());
    }

    @Test
    public void shouldSetAndGetComplemento() {
        ZipCode zipCode = new ZipCode();
        String complemento = "Sala 1";
        zipCode.setComplemento(complemento);
        Assertions.assertEquals(complemento, zipCode.getComplemento());
    }

    @Test
    public void shouldSetAndGetBairro() {
        ZipCode zipCode = new ZipCode();
        String bairro = "Centro";
        zipCode.setBairro(bairro);
        Assertions.assertEquals(bairro, zipCode.getBairro());
    }

    @Test
    public void shouldSetAndGetLocalidade() {
        ZipCode zipCode = new ZipCode();
        String localidade = "São Paulo";
        zipCode.setLocalidade(localidade);
        Assertions.assertEquals(localidade, zipCode.getLocalidade());
    }

    @Test
    public void shouldSetAndGetUf() {
        ZipCode zipCode = new ZipCode();
        String uf = "SP";
        zipCode.setUf(uf);
        Assertions.assertEquals(uf, zipCode.getUf());
    }

    @Test
    public void shouldSetAndGetFrete() {
        ZipCode zipCode = new ZipCode();
        Double frete = 10.0;
        zipCode.setFrete(frete);
        Assertions.assertEquals(frete, zipCode.getFrete());
    }

}
