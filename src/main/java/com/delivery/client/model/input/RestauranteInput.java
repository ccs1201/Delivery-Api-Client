package com.delivery.client.model.input;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RestauranteInput {


    private String nome;

    private BigDecimal taxaEntrega;

    private CozinhaIdInput cozinha;

    private EnderecoInput endereco;
}
