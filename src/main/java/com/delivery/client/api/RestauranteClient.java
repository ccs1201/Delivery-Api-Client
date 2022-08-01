package com.delivery.client.api;

import com.delivery.client.api.exception.ClientApiException;
import com.delivery.client.model.PageModel;
import com.delivery.client.model.RestauranteModel;
import com.delivery.client.model.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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
            // Como o retorno do get é um page temos de implementar uma
            // classe que represente nossa response como um page contendo
            // uma coleção de elementos do tipo {@code RestauranteModel}
            // e usar o método exchange da API {@code RestTemplate}
            // passando um {@code ParameterizedTypeReference<PageModel<RestauranteModel>>()}
            // para que o resultado seja convertido para o nosso {@code PageModel}
            ResponseEntity<PageModel<RestauranteModel>> responseEntity =
                    restTemplate.exchange(getURI(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<PageModel<RestauranteModel>>() {
                            });

            // De posse do {@code ResponseEntity} o getBody()
            // nos retorna um {@code PageModel<RestauranteModel>}
            PageModel<RestauranteModel> pageModel = responseEntity.getBody();

            // Agora podemos pegar a nossa coleção de objetos dentro
            // do {@code PageModel}
            Collection<RestauranteModel> restaurantes = pageModel.getContent();

            return restaurantes;

        } catch (RestClientResponseException e) {

            throw new ClientApiException("", e);
        }
    }

    public RestauranteModel post(RestauranteInput restauranteInput) {
        try {
            var response = restTemplate.postForObject(getURI(), restauranteInput, RestauranteModel.class);
            return response;

        } catch (HttpClientErrorException e) {
            throw new ClientApiException(e);
        }
    }

    private URI getURI() {
        return URI.create(URL + PATH);
    }
}
