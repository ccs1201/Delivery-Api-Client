package com.delivery.client.model.input;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonRootName("municipio")
public class MunicipioIdInput {

    private Long id;
}
