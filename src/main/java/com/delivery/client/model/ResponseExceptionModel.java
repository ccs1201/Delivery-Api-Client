package com.delivery.client.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ResponseExceptionModel {

    private String detail;
    private OffsetDateTime dateTime;
    private String status;
}
