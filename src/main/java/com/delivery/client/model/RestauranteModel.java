package com.delivery.client.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteModel {

    private Long id;
    private String nome;
    private BigDecimal taxaEntrega;
    private Boolean ativo;
    private Boolean aberto;
    private CozinhaModel cozinha;
    private EnderecoModel endereco;

}
