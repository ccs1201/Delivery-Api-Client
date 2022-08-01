package com.delivery.client.model;

import lombok.Data;

@Data
public class EnderecoModel {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private MunicipioModel municipio;
}
