package com.delivery.client;

import com.delivery.client.api.RestauranteClient;
import com.delivery.client.api.exception.ClientApiException;
import com.delivery.client.model.input.EnderecoInput;
import com.delivery.client.model.input.MunicipioIdInput;
import com.delivery.client.model.input.RestauranteInput;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class Main {

    private static final String URL = "http://localhost:8080";

    public static void main(String[] args) {

        getAll();

        var restaurante = RestauranteInput.builder()
                .nome("Teste Java Client")
                .taxaEntrega(BigDecimal.valueOf(1000, 2))
                .cozinha(null)
                //CozinhaIdInput.builder().id(1L).build())
                .endereco(
                        EnderecoInput.builder()
                                .cep("88100000")
                                .complemento("Loja 01")
                                .logradouro("Av das araucárias")
                                .bairro("palhoça")
                                .numero("54A")
                                .municipio(
                                        MunicipioIdInput.builder().id(1L).build())
                                .build()
                ).build();

        post(restaurante);
    }

    private static void getAll() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient client = new RestauranteClient(URL, restTemplate);

            var restaurantesModel = client.getAll();

            restaurantesModel.forEach(System.out::println);
        } catch (ClientApiException e) {
            System.out.println("Detalhes da Exception: " + e.getResponseExceptionModel().getDetail());
            System.out.println(e.getResponseExceptionModel());
        }
    }

    private static void post(RestauranteInput restauranteInput) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient client = new RestauranteClient(URL, restTemplate);

            System.out.println("Restaurante Criado \n" + client.post(restauranteInput));

        } catch (ClientApiException e) {
            //System.out.println(e.getResponseExceptionModel().getDetail());
            e.getResponseExceptionModel().getDetails().forEach(
                    fieldError ->
                            System.out.printf("%s: %s Valor rejeitado: %s%n",
                                    fieldError.getField(),
                                    fieldError.getFieldValidationMessage(),
                                    fieldError.getRejectedValue()));
        }
    }
}
