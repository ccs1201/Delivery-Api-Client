package com.delivery.client.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseExceptionModel {

    private String detail;
    private OffsetDateTime dateTime;
    private String status;

    List<Details> details = new ArrayList<>();

    @Data
    public static class Details {
        private String field;
        private String fieldValidationMessage;
        private String rejectedValue;
    }
}
