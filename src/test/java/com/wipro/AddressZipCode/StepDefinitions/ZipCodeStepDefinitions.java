package com.wipro.AddressZipCode.StepDefinitions;

import com.wipro.AddressZipCode.Model.ZipCode;
import com.wipro.AddressZipCode.Service.ZipCodeService;
import io.cucumber.java.pt.*;
import org.junit.Assert;

public class ZipCodeStepDefinitions {

    private final ZipCodeService zipCodeService;
    private String cep;
    private ZipCode zipCode;

    public ZipCodeStepDefinitions(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }

    @Dado("que um usuário consultou um CEP válido")
    public void thatAUserQueriedAValidZipCode() {
        cep = "01001000";
    }

    @Quando("a API ViaCEP retorna os dados do CEP consultado")
    public void theViaCEPAPIReturnsDataFromTheQueriedZipCode() {
        zipCode = zipCodeService.consumingZipCodeJson(cep);
    }

    @Então("os dados do CEP consultado são retornados corretamente")
    public void theQueriedZipCodeDataIsReturnedCorrectly() {
        Assert.assertEquals("São Paulo", zipCode.getLocalidade());
        Assert.assertEquals("SP", zipCode.getUf());
    }

}

