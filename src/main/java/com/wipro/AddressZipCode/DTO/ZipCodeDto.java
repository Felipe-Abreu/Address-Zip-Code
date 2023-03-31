package com.wipro.AddressZipCode.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ZipCodeDto {

    @JsonFormat(pattern = "\\d{5}-\\d{3}")
    @JsonProperty("cep")
    public String cep;
    @JsonProperty("logradouro")
    public String rua;
    @JsonProperty("complemento")
    public String complemento;
    @JsonProperty("bairro")
    public String bairro;
    @JsonProperty("localidade")
    public String cidade;
    @JsonProperty("uf")
    public String estado;
    @JsonProperty("frete")
    public Double frete;

}
