package com.delivery.client.model;

import lombok.Data;

import java.util.Collection;

@Data
public class PageModel<T> {

    private Collection<T> content;
    private int size;
    private Long totalElements;
    private int totalPages;
    private int number;


}
