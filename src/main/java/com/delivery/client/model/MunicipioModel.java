package com.delivery.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class MunicipioModel {

    private Integer id;

    private String nome;
    @JsonIgnoreProperties({"id", "sigla"})
    private EstadoModel estado;
}
