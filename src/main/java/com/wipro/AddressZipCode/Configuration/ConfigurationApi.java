package com.wipro.AddressZipCode.Configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigurationApi {

    @Value("${app.urlexternal}")
    private String viaCepApi;

}
