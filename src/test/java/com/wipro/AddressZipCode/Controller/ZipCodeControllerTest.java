package com.wipro.AddressZipCode.Controller;

import com.wipro.AddressZipCode.Model.ZipCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipCodeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testConsultZipCodeValid() {
        String cep = "01001-000";
        ResponseEntity<ZipCode> response = restTemplate.getForEntity("/api/{cep}", ZipCode.class, cep);
        ZipCode zipCode = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(zipCode);
        assertEquals(cep, zipCode.getCep());
        assertEquals("Praça da Sé", zipCode.getLogradouro());
        assertEquals("lado ímpar", zipCode.getComplemento());
        assertEquals("Sé", zipCode.getBairro());
        assertEquals("São Paulo", zipCode.getLocalidade());
        assertEquals("SP", zipCode.getUf());
        assertTrue(zipCode.getFrete() > 0);
    }

    @Test
    public void testConsultZipCodeInvalid() {
        String cep = "12345-678";
        ResponseEntity<String> response = restTemplate.getForEntity("/api/{cep}", String.class, cep);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains(cep));
    }

    @Test
    public void testConsultZipCodeNotFound() {
        String cep = "99999-999";
        ResponseEntity<String> response = restTemplate.getForEntity("/api/{cep}", String.class, cep);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains(cep));
    }

    @Test
    public void testConsultZipCodeInternalServerError() {
        String cep = "01001-000";
        ResponseEntity<String> response = restTemplate.getForEntity("/api/{cep}", String.class, cep);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("Ocorreu um erro interno"));
    }

}
