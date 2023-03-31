Feature: Consulta de endereço a partir do CEP

  Background:
    Given um endereço válido com CEP "12345-678"

  Scenario: Consulta de endereço com sucesso
    When o usuário consulta o endereço pelo CEP
    Then o sistema retorna as informações do endereço
