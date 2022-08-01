package com.delivery.client.api.exception;

import com.delivery.client.model.ResponseExceptionModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

@Slf4j
public class ClientApiException extends RuntimeException {

    @Getter
    private ResponseExceptionModel responseExceptionModel;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        deserializeResponseModelException(cause);
    }

    private void deserializeResponseModelException(RestClientResponseException cause) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();

        try {
            responseExceptionModel = mapper.readValue(cause.getResponseBodyAsString(), ResponseExceptionModel.class);
        } catch (JsonProcessingException e) {
            log.warn("Erro ao desserializar exception vinda da API.");
        }


    }
}
