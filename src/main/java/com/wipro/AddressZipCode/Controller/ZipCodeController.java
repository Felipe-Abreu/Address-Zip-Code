package com.wipro.AddressZipCode.Controller;

import com.wipro.AddressZipCode.Model.ZipCode;
import com.wipro.AddressZipCode.Service.ZipCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST CEP")
@CrossOrigin(origins = "*")
public class ZipCodeController {

    @Autowired
    private final ZipCodeService zipCodeService;
    private String zipCodeValue;

    public ZipCodeController(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }

    @PostMapping(value = "{cep}", produces = "application/json")
    @ApiOperation(value = "Retorna um endereço calculando o frete conforme a região do estado.")
    public ZipCode consultZipCode(@Valid @PathVariable("cep") String cep) {
        zipCodeValue = cep;
        return zipCodeService.consumingZipCodeJson(cep);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        String errorMessage = "O CEP " + zipCodeValue + " está incorreto.";
        return ResponseEntity.status(ex.getStatusCode()).body(errorMessage);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleInvalidCepException(NullPointerException ex) {
        String errorMessage = "O CEP " + zipCodeValue + " não foi encontrado.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno, aguarde um momento e " +
                "tente novamente, caso persista, contato o administrador.");
    }

}
