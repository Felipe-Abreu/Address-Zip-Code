package com.wipro.AddressZipCode.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ApiModel(description = "Dados do endereço")
public class ZipCode {

    @NotNull
    @Pattern(regexp = "\\d{5}-\\d{3}|\\d{8}", message = "CEP inválido")
    public String cep;
    @JsonProperty("rua")
    public String logradouro;
    @JsonProperty("complemento")
    public String complemento;
    @JsonProperty("bairro")
    public String bairro;
    @JsonProperty("cidade")
    public String localidade;
    @JsonProperty("estado")
    public String uf;
    @JsonProperty("frete")
    public Double frete;

}
