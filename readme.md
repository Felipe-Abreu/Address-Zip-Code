<h1 align="center">
    Consulta de CEP e cálculo do frete
</h1>

<h4 align="center">
    Utilizando Java juntamente com Framework Spring Boot, foi realizado o desenvolvimento de uma API Rest
</h4>

<p align="center">
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/felipe-abreu/Address-Zip-Code">
    <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/felipe-abreu/Address-Zip-Code">
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/Felipe-Abreu/Address-Zip-Code">
    <a href="https://github.com/Felipe-Abreu/Address-Zip-Code/commits/master">
        <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/felipe-abreu/Address-Zip-Code">
    </a>
    <a href="https://github.com/Felipe-Abreu/Address-Zip-Code/issues">
        <img alt="Repository issues" src="https://img.shields.io/github/issues/Felipe-Abreu/Address-Zip-Code">
    </a>
    <img alt="License" src="https://img.shields.io/badge/license-MIT-yellowgreen">
</p>

## :information_source: Informações do projeto

Esse projeto foi utilizado com as seguintes tecnologias:

- Framework Spring Boot 2.7.2;
- Gradlew;
- Java 11;
- IDE Intellij;
- Cucumber;
- jUnit;
- Swagger;


## 📓 Requisitos do projeto

Realizar consulta de CEP e, na resposta já deve se obter o valor do frete, seguindo a condição que dependendo da região 
de cada, o valor será diferente.<br>
Valores por regiões:
- Sudeste (R$ 7,85)
- Centro-Oeste (R$ 12,50)
- Sul (R$ 17,30)
- Norte (R$ 20,83)
- Nordeste (R$ 15,98)

Fica assim, sendo esperado o seguinte retorno.<br>
JSON
----

```json
POST v1/consulta-endereco
REQUEST
{
  "cep": "01001000"
}
RESPONSE HTTP 200
{
  "cep": "01001-000",
  "rua": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "estado": "SP",
  "frete": 7.85
}
```

## :computer: Utilizando a aplicação

Para se fazer uso da aplicação, basta rodar a mesma localmente seguindo os versionamentos informados.
<br>
Após a aplicação subir, acessando http://localhost:8080/api já vai conseguir acessar o swagger
<br><br>
Se for de escolha realizar os testes utilizando postman, é necessário realizar um post com o caminho http://localhost:8080/api/01001000

---
Feito por Felipe Abreu :wave: [Venha me conhecer um pouco mais!](https://www.linkedin.com/in/felipe-abreu)
