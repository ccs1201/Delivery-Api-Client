package com.delivery.client.api;

import com.delivery.client.api.exception.ClientApiException;
import com.delivery.client.model.PageModel;
import com.delivery.client.model.RestauranteModel;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;

@AllArgsConstructor
public class RestauranteClient {

    private static final String PATH = "/api/restaurantes/";
    private String URL;
    private RestTemplate restTemplate;

    public Collection<RestauranteModel> getAll() {

        try {
            ResponseEntity<PageModel<RestauranteModel>> responseEntity =
                    restTemplate.exchange(getURI(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<PageModel<RestauranteModel>>() {
                            });

            PageModel<RestauranteModel> model = responseEntity.getBody();

            Collection<RestauranteModel> restaurantes = model.getContent();

            return restaurantes;
        } catch (RestClientResponseException e) {

            throw new ClientApiException("",e);
        }

    }

    private URI getURI() {
        return URI.create(URL + PATH);
    }
}
