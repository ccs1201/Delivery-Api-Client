package com.delivery.client.model.input;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

@JsonRootName("endereco")
@Data
@Builder
public class EnderecoInput {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private MunicipioIdInput municipio;
}
