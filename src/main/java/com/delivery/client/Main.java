package com.delivery.client;

import com.delivery.client.api.RestauranteClient;
import com.delivery.client.api.exception.ClientApiException;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient client = new RestauranteClient("http://localhost:8080", restTemplate);

            var restaurantesModel = client.getAll();

            restaurantesModel.forEach(System.out::println);
        } catch (ClientApiException e) {
            System.out.println(e.getResponseExceptionModel().getDetail());
            System.out.println(e.getResponseExceptionModel());
        }
    }
}
