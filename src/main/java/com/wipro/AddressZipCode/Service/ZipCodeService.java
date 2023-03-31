package com.wipro.AddressZipCode.Service;

import com.wipro.AddressZipCode.Configuration.ConfigurationApi;
import com.wipro.AddressZipCode.DTO.ZipCodeDto;
import com.wipro.AddressZipCode.Enums.States;
import com.wipro.AddressZipCode.Model.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService {

    private final ConfigurationApi configurationApi;
    private final RestTemplate restTemplate;

    @Autowired
    public ZipCodeService(ConfigurationApi configurationApi, RestTemplate restTemplate) {
        this.configurationApi = configurationApi;
        this.restTemplate = restTemplate;
    }

    public ZipCode consumingZipCodeJson(String cep) {
        String url = configurationApi.getViaCepApi() + cep + "/json";
        var response = restTemplate.getForObject(url, ZipCodeDto.class);

        ZipCode zipCode = new ZipCode();
        zipCode.setCep(response.getCep());
        zipCode.setLogradouro(response.getRua());
        zipCode.setComplemento(response.getComplemento());
        zipCode.setBairro(response.getBairro());
        zipCode.setLocalidade(response.getCidade());
        zipCode.setUf(response.getEstado().toUpperCase());
        zipCode.setFrete(calculateShipping(response));

        return zipCode;
    }

    private Double calculateShipping(ZipCodeDto address) {
        String uf = address.getEstado().toUpperCase();
        double shipping = Double.parseDouble(String.valueOf(States.valueOf(uf).getRegion()));
        address.setFrete(shipping);
        return address.getFrete();
    }

}
