package com.bosch.example.dto;

public record ViaCEPJson(
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String uf,
    String ibge,
    String gia,
    String ddd,
    String saifi
) { }
